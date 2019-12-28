package com.luo.ad.api;

import com.luo.ad.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//这里不写死名字,为了升级 客户端
@FeignClient(name = "${user.service.name}")
public interface UserService {

    @PostMapping("/user/save")
    boolean saveUser(User user);

    @GetMapping("/user/find/all")
    List<User> findAll();
}
