package com.luo.ad.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StatusCtr {

    @Value(("${sf.user.name}"))
    private String name;
    @GetMapping("status")
    public String status() {
        log.info("remote sf name:{}", name);
        return "st";
    }


}
