package com.wxapp.video.controller;


import com.wxapp.video.common.IMoocJSONResult;
import com.wxapp.video.entity.Bgm;
import com.wxapp.video.service.IBgmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/bgm")
@Api(value="背景音乐业务的接口", tags= {"背景音乐业务的controller"})
public class BgmController {

    @Autowired
    private IBgmService bgmService;

    @ApiOperation(value="获取背景音乐列表", notes="获取背景音乐列表的接口")
    @PostMapping("/list")
    public IMoocJSONResult queryBgmList(){
        List<Bgm> list = bgmService.list();
        return IMoocJSONResult.ok(list);
    }

}

