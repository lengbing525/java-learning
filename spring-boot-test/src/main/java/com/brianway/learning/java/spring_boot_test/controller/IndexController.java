package com.brianway.learning.java.spring_boot_test.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lengbing on 2017/5/12.
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/{ver}/restfulUrl",name = "test1")
    public String index(@RequestParam("context") String context,@PathVariable("ver") Integer ver) {

        return "restfulUrl";
    }
}
