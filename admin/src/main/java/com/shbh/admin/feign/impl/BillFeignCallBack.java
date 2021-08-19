package com.shbh.admin.feign.impl;

import com.shbh.admin.feign.BillFeign;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BillFeignCallBack implements BillFeign {
    @Override
    public Map getMap(Integer billId) {
        System.out.println("feign熔断降级");
        HashMap hashMap = new HashMap(1);
        hashMap.put("chufa", "feign熔断降级");
        return hashMap;
    }
}
