package com.luo.ad.web.controller;

import com.luo.ad.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(User.class)
public class UserCtr {

    private final User user;

   /* @Value("${sf.user.id}")
    private int id;*/

    @Autowired
    public UserCtr(User user) {
        this.user = user;
    }

    @GetMapping("/id")
    public int getVal() {

        return 29;
    }

    @GetMapping("/user")
    public User getUser() {

        return user;
    }
}
