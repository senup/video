package com.wxapp.video.service.impl;

import com.wxapp.video.entity.UsersFans;
import com.wxapp.video.mapper.UsersFansMapper;
import com.wxapp.video.service.IUsersFansService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户粉丝关联关系表 服务实现类
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@Service
public class UsersFansServiceImpl extends ServiceImpl<UsersFansMapper, UsersFans> implements IUsersFansService {

}
