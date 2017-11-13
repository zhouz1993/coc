package com.wis.util;

import java.util.HashMap;  
import java.util.Map;  
import java.util.Properties;  
      
import org.springframework.beans.BeansException;  
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;  
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;  
      
    /** 
     * 加载global.properties资源 
     *  
     * @author Tiya
     *  
     */  
    public class CustomizedPropertyPlaceholderConfigurer extends  
            PropertyPlaceholderConfigurer {  
      
    	/**
    	 * ctxPropertiesMap
    	 */
        private static final Map<String, Object> CTX = new HashMap<String, Object>();  
      
        @Override  
        protected void processProperties(
                ConfigurableListableBeanFactory beanFactoryToProcess,  
                Properties props) throws BeansException {  
            super.processProperties(beanFactoryToProcess, props);  
            for (Object key : props.keySet()) {  
                String keyStr = key.toString();  
                String value = props.getProperty(keyStr);  
                CTX.put(keyStr, value);  
            }  
        }  
      
        /**
         * getContextProperty
         * @param name String
         * @return Object
         */
        public static Object getContextProperty(String name) {  
            return CTX.get(name);  
        }  
      
}  

