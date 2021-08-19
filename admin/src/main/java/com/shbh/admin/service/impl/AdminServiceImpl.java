package com.shbh.admin.service.impl;

import com.shbh.admin.mapper.AdminMapper;
import com.shbh.admin.entity.Admin;
import com.shbh.admin.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
