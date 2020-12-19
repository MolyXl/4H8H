package com.shbh.user.feign.impl;

import com.shbh.user.feign.BillFeign;

import java.util.HashMap;
import java.util.Map;

public class BillFeignCallBack implements BillFeign {
    public Map getMap() {
        System.out.println("feign熔断降级");
        HashMap hashMap = new HashMap(1);
        hashMap.put("chufa","feign熔断降级");
        return hashMap;
    }
}
