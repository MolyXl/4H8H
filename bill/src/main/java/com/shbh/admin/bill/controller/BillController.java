package com.shbh.admin.bill.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazhuli
 */
@RequestMapping("/bill")
@RestController
public class BillController {
    @Transactional
    @RequestMapping(value = "/getMap", method = RequestMethod.GET)
    public Map getMap(@RequestParam("billId") Integer billId) {
        if (billId.equals(2)) {
            throw new RuntimeException("2yichang");
        }
        HashMap hashMap = new HashMap(16);
        hashMap.put("aa", 23);
        return hashMap;
    }
}
