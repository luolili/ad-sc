package com.luo.ad.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusCtr {
    @Value("${sf.user.id}")
    private int id;

    @GetMapping("status")
    public String status() {
        return "st";
    }
}
