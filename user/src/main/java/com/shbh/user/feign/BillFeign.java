package com.shbh.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("bill")
public interface BillFeign {
    @RequestMapping(value = "/test/getMap", method = RequestMethod.GET)
    Map getMap();
}
