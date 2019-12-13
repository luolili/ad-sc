package com.luo.ad.bootstrap;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 bootstrap 配置属性源:
 * http://localhost:7001/ad-search/actuator/env/spring.application.name
 * PropertySourceLocator sc 的接口
 */
public class MyPropertySourceLocator implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {

        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment configEnv = ConfigurableEnvironment.class.cast(environment);

            MutablePropertySources propertySources = configEnv.getPropertySources();
            propertySources.addFirst(createPropertySource());
        }
        return null;
    }

    private PropertySource createPropertySource() {

        Map<String, Object> map = new HashMap<>();
        map.put("spring.application.name", "demo name");
        PropertySource propertySource = new MapPropertySource("override-bootstrap-property-source", map);
        return propertySource;
    }
}
