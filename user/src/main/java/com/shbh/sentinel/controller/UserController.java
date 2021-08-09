package com.shbh.sentinel.controller;

import com.shbh.sentinel.feign.BillFeign;
import com.shbh.sentinel.thirdPart.BaiDuSpeech;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
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

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> fileList = multipartRequest.getFiles("file");
        JSONObject jsonObject = BaiDuSpeech.ptSpeech(fileList.get(0));
        System.out.println(jsonObject);
    }

}
