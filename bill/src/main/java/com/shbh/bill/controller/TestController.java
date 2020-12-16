package com.shbh.bill.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazhuli
 */
@RequestMapping("/test")
@RestController
public class TestController {
    @RequestMapping(value = "/getMap", method = RequestMethod.GET)
    public Map getMap(HttpServletRequest request) {
        int serverPort = request.getServerPort();
        HashMap hashMap = new HashMap(16);
        hashMap.put("aa",23);
        hashMap.put("serverPort",serverPort);
        return hashMap;
    }
}
