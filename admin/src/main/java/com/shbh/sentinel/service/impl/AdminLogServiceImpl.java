package com.shbh.sentinel.service.impl;

import com.shbh.sentinel.entity.AdminLog;
import com.shbh.sentinel.mapper.AdminLogMapper;
import com.shbh.sentinel.service.IAdminLogService;
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
