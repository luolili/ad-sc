package com.luo.ad.service;


import com.luo.ad.vo.CreativeRequest;
import com.luo.ad.vo.CreativeResponse;


public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}
