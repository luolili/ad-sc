package com.luo.ad.client;

import com.luo.ad.client.vo.AdPlan;
import com.luo.ad.client.vo.AdPlanGetRequest;
import com.luo.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SponsorClientHystrix implements SponsorClient {

    @Override
    public CommonResponse<List<AdPlan>> adPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "-err");
    }
}
