package com.luo.ad.client;

import com.luo.ad.client.vo.AdPlan;
import com.luo.ad.client.vo.AdPlanGetRequest;
import com.luo.ad.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// FeignClient 声明客户端
@FeignClient(value = "eureka-client-ad-sponsor", fallback = SponsorClientHystrix.class)
public interface SponsorClient {

    @RequestMapping(value = "/ad-sponsor/get/adPlan", method = RequestMethod.POST)
    CommonResponse<List<AdPlan>> adPlans(@RequestBody AdPlanGetRequest request);
}
