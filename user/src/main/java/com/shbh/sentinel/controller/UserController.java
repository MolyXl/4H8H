package com.shbh.sentinel.controller;

import com.shbh.sentinel.feign.BillFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Mazhuli
 */
@RestController
public class UserController {
    @Autowired
    private BillFeign billFeign;

    @RequestMapping(value = "/getMap", method = RequestMethod.GET)
    public Map getMap(Integer billId) {
        if (billId.equals(1)) {
            throw new RuntimeException("1异常");
        }
        return billFeign.getMap(billId);
    }

}
