package com.luo.ad.service;


import com.luo.ad.exception.AdException;
import com.luo.ad.vo.CreateUserRequest;
import com.luo.ad.vo.CreateUserResponse;


public interface IUserService {

    CreateUserResponse createUser(CreateUserRequest request)
            throws AdException;
}
