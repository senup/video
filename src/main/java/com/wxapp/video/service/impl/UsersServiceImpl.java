package com.wxapp.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wxapp.video.entity.Users;
import com.wxapp.video.mapper.UsersMapper;
import com.wxapp.video.org.n3r.idworker.Sid;
import com.wxapp.video.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    @Override
    public boolean queryUsernameIsExist(String username) {
        QueryWrapper<Users> wrapper=new QueryWrapper<>();
        wrapper.eq("username",username);
        Users result = usersMapper.selectOne(wrapper);
        return result==null?false:true;
    }

    @Override
    public void saveUser(Users user) {
        String userId = sid.nextShort();
        user.setId(userId);
        usersMapper.insert(user);
    }
}
