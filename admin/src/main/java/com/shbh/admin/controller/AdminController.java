package com.shbh.admin.controller;


import com.shbh.admin.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;
}

