package com.shbh.admin.feign;

import com.shbh.admin.feign.impl.BillFeignCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "bill",fallback = BillFeignCallBack.class)
public interface BillFeign {
    @RequestMapping(value = "/bill/getMap", method = RequestMethod.GET)
    Map getMap(@RequestParam("billId") Integer billId);
}
