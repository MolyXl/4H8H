package com.shbh.admin.service.impl;

import com.shbh.admin.entity.AdminLog;
import com.shbh.admin.mapper.AdminLogMapper;
import com.shbh.admin.service.IAdminLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@Service
public class AdminLogServiceImpl extends ServiceImpl<AdminLogMapper, AdminLog> implements IAdminLogService {

}
