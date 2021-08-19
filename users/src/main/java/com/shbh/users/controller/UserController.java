package com.shbh.users.controller;


import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.shbh.users.entity.User;
import com.shbh.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/getMap", method = RequestMethod.GET)
    public Map getMap(@RequestParam("billId") Integer billId) {
        User user = new User();
        user.setGender(1);
        user.setEmailAddress("99999@qq.com");
        user.setRegTime(new Date());
        userService.save(user);
        if (billId.equals(3)) {
            throw new RuntimeException("回滚吧");
        }
        HashMap hashMap = new HashMap(16);
        hashMap.put("aa", 23);
        return hashMap;
    }
}

