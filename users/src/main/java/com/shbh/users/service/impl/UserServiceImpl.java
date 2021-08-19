package com.shbh.users.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shbh.users.entity.User;
import com.shbh.users.mapper.UserMapper;
import com.shbh.users.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
