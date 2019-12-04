package com.luo.ad.controller;

import com.alibaba.fastjson.JSON;
import com.luo.ad.advice.annotation.IgnoreResponseAdvice;
import com.luo.ad.client.SponsorClient;
import com.luo.ad.client.vo.AdPlan;
import com.luo.ad.client.vo.AdPlanGetRequest;
import com.luo.ad.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class SearchController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SponsorClient sponsorClient;

    @IgnoreResponseAdvice
    @PostMapping("/get/adPlan")
    public CommonResponse<List<AdPlan>> adPlansByFeign(@RequestBody AdPlanGetRequest request) {
        log.info("--:{}", JSON.toJSONString(request));
        return sponsorClient.adPlans(request);
    }

    @SuppressWarnings("all")
    @IgnoreResponseAdvice
    @PostMapping("/get/adPlanByRest")
    public CommonResponse<List<AdPlan>> adPlans(@RequestBody AdPlanGetRequest request) {
        log.info("--:{}", JSON.toJSONString(request));
        return restTemplate.postForEntity("http://eureka-client-ad-sponsor/ad-sponsor/get/adPlan",
                request,
                CommonResponse.class)
                .getBody();
    }
}
