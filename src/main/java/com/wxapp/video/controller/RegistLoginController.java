package com.wxapp.video.controller;

import com.wxapp.video.common.IMoocJSONResult;
import com.wxapp.video.common.MD5Utils;
import com.wxapp.video.entity.Users;
import com.wxapp.video.service.IUsersService;
import com.wxapp.video.vo.UsersVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@Api(value = "用户注册和登陆的接口",tags = {"注册和登陆的controller"})
public class RegistLoginController extends BasicController{

    @Autowired
    private IUsersService usersService;


    @ApiOperation(value = "用户注册",notes = "用户注册的接口")
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
        user.setPassword("");
        UsersVo usersVo = setUserRedisSessionToken(user);

        return IMoocJSONResult.ok(usersVo);
    }

    //公用方法
    public UsersVo setUserRedisSessionToken(Users user){
        String uniqueToken = UUID.randomUUID().toString();
        redis.set(USER_REDIS_SESSION+":"+user.getId(),uniqueToken,1000*60*30);

        UsersVo vo = new UsersVo();
        BeanUtils.copyProperties(user,vo);
        vo.setUserToken(uniqueToken);
        return vo;
    }

    @ApiOperation(value = "用户登陆",notes = "用户登陆的接口")
    @PostMapping("/login")
    public IMoocJSONResult login(@RequestBody Users user ) throws Exception {
        String username = user.getUsername();
        String password=user.getPassword();

        //判断用户是否为空
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return IMoocJSONResult.errorMsg("用户名或密码不能为空！");
        }

        //通过用户名和密码查询，得到用户对象
        Users result = usersService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        if(result!=null){
            result.setPassword("");
            UsersVo usersVo = setUserRedisSessionToken(result);
            return IMoocJSONResult.ok(usersVo);
        }else {
            return IMoocJSONResult.errorMsg("用户名或密码错误，请重试！");

        }


    }

}
