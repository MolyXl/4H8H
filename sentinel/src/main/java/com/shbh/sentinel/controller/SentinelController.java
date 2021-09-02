package com.shbh.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.shbh.sentinel.feign.UsersFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Mazhuli
 */
@RestController
public class SentinelController {
    private UsersFeign usersFeign;

    @Autowired
    public void setUsersFeign(@Qualifier("com.shbh.sentinel.feign.UsersFeign") UsersFeign usersFeign) {
        this.usersFeign = usersFeign;
    }


    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public Map test1(Integer billId) {
        if (billId.equals(1)) {
            throw new RuntimeException("1异常");
        }
        return usersFeign.getMap(billId);
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public Map test2(Integer billId) {
        if (billId.equals(1)) {
            throw new RuntimeException("1异常");
        }
        return usersFeign.getMap(billId);
    }

}
