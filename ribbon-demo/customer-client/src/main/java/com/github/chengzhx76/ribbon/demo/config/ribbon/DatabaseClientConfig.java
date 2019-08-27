package com.github.chengzhx76.ribbon.demo.config.ribbon;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.config.DynamicProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/19
 */
public class DatabaseClientConfig extends DefaultClientConfigImpl {

    private final Map<String, DynamicStringProperty> dynamicProperties = new ConcurrentHashMap<>();

    private String clientName;

    public DatabaseClientConfig(String clientName) {
        super();
        this.clientName = clientName;
        this.dynamicProperties.clear();
    }

    @Override
    protected void setPropertyInternal(final String propName, Object value) {
        String stringValue = (value == null) ? "" : String.valueOf(value);
        properties.put(propName, stringValue);
        if (!super.isEnableDynamicProperties()) {
            return;
        }
        String configKey = getConfigKey(propName);
        final DynamicStringProperty prop = DynamicPropertyFactory.getInstance().getStringProperty(configKey, null);
        Runnable callback = new Runnable() {
            @Override
            public void run() {
                String value = prop.get();
                if (value != null) {
                    properties.put(propName, value);
                } else {
                    properties.remove(propName);
                }
            }

            // equals and hashcode needed
            // since this is anonymous object is later used as a set key

            @Override
            public boolean equals(Object other){
                if (other == null) {
                    return false;
                }
                if (getClass() == other.getClass()) {
                    return toString().equals(other.toString());
                }
                return false;
            }

            @Override
            public String toString(){
                return propName;
            }

            @Override
            public int hashCode(){
                return propName.hashCode();
            }


        };
        prop.addCallback(callback);
        dynamicProperties.put(propName, prop);
    }

    private String getConfigKey(String propName) {
        return (clientName == null) ? getNameSpace() + "." + propName : getInstancePropName(clientName, propName);
    }

    @Override
    protected Object getProperty(String key) {
        if (super.isEnableDynamicProperties()) {
            String dynamicValue = null;
            DynamicStringProperty dynamicProperty = dynamicProperties.get(key);
            if (dynamicProperty != null) {
                dynamicValue = dynamicProperty.get();
            }
            if (dynamicValue == null) {
                dynamicValue = DynamicProperty.getInstance(getConfigKey(key)).getString();
                if (dynamicValue == null) {
                    dynamicValue = DynamicProperty.getInstance(getNameSpace() + "." + key).getString();
                }
            }
            if (dynamicValue != null) {
                return dynamicValue;
            }
        }
        return properties.get(key);

    }
}
