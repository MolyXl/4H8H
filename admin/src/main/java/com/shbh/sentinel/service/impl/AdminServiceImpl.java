package com.shbh.sentinel.service.impl;

import com.shbh.sentinel.mapper.AdminMapper;
import com.shbh.sentinel.entity.Admin;
import com.shbh.sentinel.service.IAdminService;
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
