package com.shbh.user.controller;

import com.shbh.user.feign.BillFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazhuli
 */
@RequestMapping("/test")
@RestController
public class TestController {
    @Autowired
    private BillFeign billFeign;
    @RequestMapping(value = "/getMap", method = RequestMethod.GET)
    public Map getMap(){
        return billFeign.getMap();
    }
}
