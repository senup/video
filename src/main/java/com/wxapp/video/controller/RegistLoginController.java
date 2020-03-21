package com.wxapp.video.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wxapp.video.common.IMoocJSONResult;
import com.wxapp.video.common.MD5Utils;
import com.wxapp.video.entity.Users;
import com.wxapp.video.service.IUsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RegistLoginController {

    @Autowired
    private IUsersService usersService;


    @PostMapping("/regist")
    public IMoocJSONResult regist(@RequestBody Users user ) throws Exception {
        //判断用户是否为空
        if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())){
            return IMoocJSONResult.errorMsg("用户名或密码不能为空！");
        }

        //判断用户是否存在
        boolean result = usersService.queryUsernameIsExist(user.getUsername());
        if(!result){
            //初始化信息
            user.setNickname(user.getUsername());
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            user.setFansCounts(0);
            user.setReceiveLikeCounts(0);
            user.setFollowCounts(0);
            //保存用户
            usersService.saveUser(user);
        }else{
            return IMoocJSONResult.errorMsg("用户名已存在，请再换一个！");

        }
        return IMoocJSONResult.ok();



    }


}
