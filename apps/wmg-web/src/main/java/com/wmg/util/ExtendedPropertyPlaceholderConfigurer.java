/**
 * 
 */
package com.wmg.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author  huanggang
 * @date    2011-4-12
 * @version	1.0
 * 扩展Spring中的PropertyPlaceholderConfigurer
 * 通过@Properties注入给类的属性,来获得properties文件中定义的值
 */
public class ExtendedPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private Properties props;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory,
			Properties props) throws BeansException {
		super.processProperties(beanFactory, props);
		this.props=props;
	}
	
	/**
	 * 根据key值获取到value
	 * @param key properties的key
	 * @return Object properties的value
	 */
	public Object getProperty(String key){
		return props.get(key);
	}

    @Override
    protected void loadProperties(Properties props) throws IOException {
        super.loadProperties(props);
        Enumeration en = props.propertyNames();
        while (en.hasMoreElements()) {
            String property = (String) en.nextElement();
            System.setProperty(property, props.getProperty(property));
        }
    }

	
}
