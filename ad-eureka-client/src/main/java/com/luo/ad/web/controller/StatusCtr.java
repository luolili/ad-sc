package com.luo.ad.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusCtr {


    @GetMapping("status")
    public String status() {
        return "st";
    }
}
