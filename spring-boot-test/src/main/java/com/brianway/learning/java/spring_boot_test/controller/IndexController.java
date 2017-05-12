package com.brianway.learning.java.spring_boot_test.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lengbing on 2017/5/12.
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        JSONObject object = new JSONObject();
        object.put("name","lengbing");
        object.put("version","1.0.0");
        object.put("time","2017-10-10");
        return object.toString();
    }
}
