package com.shbh.sentinel.feign;

import com.shbh.sentinel.feign.impl.UsersFeignCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "users", fallback = UsersFeignCallBack.class)
public interface UsersFeign {
    @RequestMapping(value = "/users/getMap", method = RequestMethod.GET)
    Map getMap(@RequestParam("billId") Integer billId);
}
