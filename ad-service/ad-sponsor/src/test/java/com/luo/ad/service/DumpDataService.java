package com.luo.ad.service;

import com.luo.ad.App;
import com.luo.ad.dao.AdPlanRepository;
import com.luo.ad.dao.AdUnitRepository;
import com.luo.ad.dao.CreativeRepository;
import com.luo.ad.dao.unit_condition.AdUnitDistrictRepository;
import com.luo.ad.dao.unit_condition.AdUnitItRepository;
import com.luo.ad.dao.unit_condition.AdUnitKeywordRepository;
import com.luo.ad.dao.unit_condition.CreativeUnitRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DumpDataService {

    @Autowired
    AdPlanRepository adPlanRepository;
    @Autowired
    AdUnitRepository adUnitRepository;
    @Autowired
    CreativeRepository creativeRepository;
    @Autowired
    CreativeUnitRepository creativeUnitRepository;

    @Autowired
    AdUnitDistrictRepository adUnitDistrictRepository;
    @Autowired
    AdUnitItRepository adUnitItRepository;
    @Autowired
    AdUnitKeywordRepository adUnitKeywordRepository;

}
