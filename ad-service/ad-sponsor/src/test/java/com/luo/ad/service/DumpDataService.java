package com.luo.ad.service;

import com.alibaba.fastjson.JSON;
import com.luo.ad.App;
import com.luo.ad.constant.CommonStatus;
import com.luo.ad.dao.AdPlanRepository;
import com.luo.ad.dao.AdUnitRepository;
import com.luo.ad.dao.CreativeRepository;
import com.luo.ad.dao.unit_condition.AdUnitDistrictRepository;
import com.luo.ad.dao.unit_condition.AdUnitItRepository;
import com.luo.ad.dao.unit_condition.AdUnitKeywordRepository;
import com.luo.ad.dao.unit_condition.CreativeUnitRepository;
import com.luo.ad.dump.table.*;
import com.luo.ad.entity.AdPlan;
import com.luo.ad.entity.AdUnit;
import com.luo.ad.entity.Creative;
import com.luo.ad.entity.unit_condition.AdUnitDistrict;
import com.luo.ad.entity.unit_condition.AdUnitIt;
import com.luo.ad.entity.unit_condition.AdUnitKeyword;
import com.luo.ad.entity.unit_condition.CreativeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    public void dumpAdPlanTable(String fileName) {
        List<AdPlan> planList = adPlanRepository
                .findAllByPlanStatus(CommonStatus.VALID.getStatus());
        if (CollectionUtils.isEmpty(planList)) {
            return;
        }
        List<AdPlanTable> adPlanTableList = new ArrayList<>();
        planList.forEach(i -> {
            adPlanTableList.add(new AdPlanTable(
                    i.getId(), i.getUserId(),
                    i.getPlanStatus(),
                    i.getStartDate(),
                    i.getEndDate()
            ));
        });
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdPlanTable table : adPlanTableList) {
                writer.write(JSON.toJSONString(table));
                writer.newLine();
            }

        } catch (IOException e) {
            log.error("plan err");
        }


    }

    public void dumpAdUnitTable(String fileName) {
        List<AdUnit> list = adUnitRepository
                .findAllByUnitStatus(CommonStatus.VALID.getStatus());
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<AdUnitTable> tableList = new ArrayList<>();
        list.forEach(i -> {
            tableList.add(new AdUnitTable(
                    i.getId(),
                    i.getUnitStatus(),
                    i.getPositionType(),
                    i.getPlanId()
            ));
        });
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitTable table : tableList) {
                writer.write(JSON.toJSONString(table));
                writer.newLine();
            }

        } catch (IOException e) {
            log.error("unit err");
        }


    }

    public void dumpAdCreativeTable(String fileName) {
        List<Creative> list = creativeRepository
                .findAll();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<AdCreativeTable> tableList = new ArrayList<>();
        list.forEach(i -> {
            tableList.add(new AdCreativeTable(
                    i.getId(),
                    i.getName(),
                    i.getType(),
                    i.getMaterialType(),
                    i.getHeight(),
                    i.getWidth(),
                    i.getAuditStatus(),
                    i.getUrl()
            ));
        });
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdCreativeTable table : tableList) {
                writer.write(JSON.toJSONString(table));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("unit err");
        }
    }

    public void dumpAdCreativeUnitTable(String fileName) {
        List<CreativeUnit> list = creativeUnitRepository
                .findAll();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<AdCreativeUnitTable> tableList = new ArrayList<>();
        list.forEach(i -> {
            tableList.add(new AdCreativeUnitTable(
                    i.getCreativeId(),
                    i.getUnitId()
            ));
        });
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdCreativeUnitTable table : tableList) {
                writer.write(JSON.toJSONString(table));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("unit err");
        }
    }

    public void dumpAdUnitDistinctTable(String fileName) {
        List<AdUnitDistrict> list = adUnitDistrictRepository
                .findAll();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<AdUnitDistrictTable> tableList = new ArrayList<>();
        list.forEach(i -> {
            tableList.add(new AdUnitDistrictTable(
                    i.getUnitId(),
                    i.getProvince(),
                    i.getCity()
            ));
        });
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitDistrictTable table : tableList) {
                writer.write(JSON.toJSONString(table));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("unit err");
        }
    }

    public void dumpAdUnitItTable(String fileName) {
        List<AdUnitIt> list = adUnitItRepository
                .findAll();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<AdUnitItTable> tableList = new ArrayList<>();
        list.forEach(i -> {
            tableList.add(new AdUnitItTable(
                    i.getUnitId(),
                    i.getItTag()
            ));
        });
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitItTable table : tableList) {
                writer.write(JSON.toJSONString(table));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("unit err");
        }
    }

    public void dumpAdUnitKeywordTable(String fileName) {
        List<AdUnitKeyword> list = adUnitKeywordRepository
                .findAll();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<AdUnitKeywordTable> tableList = new ArrayList<>();
        list.forEach(i -> {
            tableList.add(new AdUnitKeywordTable(
                    i.getUnitId(),
                    i.getKeyword()
            ));
        });
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitKeywordTable table : tableList) {
                writer.write(JSON.toJSONString(table));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("unit err");
        }
    }

}
