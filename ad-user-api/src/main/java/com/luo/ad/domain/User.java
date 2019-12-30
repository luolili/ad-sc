package com.luo.ad.domain;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class User {

    private Long id;
    private String name;

    //级联valid
    private List<@Valid Role> roleList;
}
