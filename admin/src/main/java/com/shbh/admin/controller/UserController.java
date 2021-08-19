package com.shbh.admin.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.shbh.admin.entity.Admin;
import com.shbh.admin.feign.BillFeign;
import com.shbh.admin.feign.UsersFeign;
import com.shbh.admin.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Mazhuli
 */
@RestController
public class UserController {
    @Autowired
    private BillFeign billFeign;
    @Autowired
    private UsersFeign usersFeign;
    @Autowired
    private IAdminService adminService;
    @LcnTransaction
    @Transactional
    @RequestMapping(value = "/getMap", method = RequestMethod.GET)
    public Map getMap(Integer billId) {
        if (billId.equals(1)) {
            throw new RuntimeException("1异常");
        }
        Admin admin = new Admin();
        admin.setName("dddd");
        adminService.save(admin);
        return usersFeign.getMap(billId);
    }


}
