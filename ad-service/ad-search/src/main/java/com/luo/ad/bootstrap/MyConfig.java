package com.luo.ad.bootstrap;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * zi定义的配置类
 * ApplicationContextInitializer spring 的接口
 */
@Configuration
public class MyConfig implements ApplicationContextInitializer {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment env = applicationContext.getEnvironment();

        MutablePropertySources propertySources = env.getPropertySources();

        //定义一个新的 PropertySource
        propertySources.addFirst(createPropertySource());
    }

    private PropertySource createPropertySource() {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "mee");
        PropertySource propertySource = new MapPropertySource("my-property-source", map);
        return propertySource;
    }
}
