package com.wxapp.video.controller;


import com.wxapp.video.entity.Users;
import com.wxapp.video.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@RestController
@RequestMapping("/")
public class UsersController {
    @Autowired
    private IUsersService usersService;
    @RequestMapping("/test")
    public List<Users> findAll() {
        List<Users> users = usersService.list();
        return users;
    }

}

