package com.luo.ad.dao;

import com.luo.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdUserRepository extends JpaRepository<AdUser, Long> {


    AdUser findByUsername(String username);
}
