package com.shbh.user.feign;

import com.shbh.user.feign.impl.BillFeignCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "bill",fallback = BillFeignCallBack.class)
public interface BillFeign {
    @RequestMapping(value = "/test/getMap", method = RequestMethod.GET)
    Map getMap();
}
