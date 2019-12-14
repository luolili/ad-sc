package com.luo.ad.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "sf.user")
public class User {
    private int id;
    private String name;
}
