package com.wxapp.video.controller;


import com.wxapp.video.common.IMoocJSONResult;
import com.wxapp.video.entity.Users;
import com.wxapp.video.service.IUsersService;
import com.wxapp.video.vo.UsersVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@RestController
@RequestMapping("/user")
@Api(value="用户相关业务的接口", tags= {"用户相关业务的controller"})
public class UsersController {
    @Autowired
    private IUsersService usersService;

    //测试
    @RequestMapping("/test")
    public List<Users> findAll() {
        List<Users> users = usersService.list();
        return users;
    }

    @ApiOperation(value="查询用户信息", notes="查询用户信息的接口")
    @ApiImplicitParam(name="userId", value="用户id", required=true,
            dataType="String", paramType="query")
    @PostMapping("/query")
    public IMoocJSONResult query(String userId){
        //判空
        if(StringUtils.isBlank(userId)){
            return IMoocJSONResult.errorMsg("用户ID不能为空！");
        }
        Users result = usersService.getById(userId);
        UsersVo usersVo = new UsersVo();
        BeanUtils.copyProperties(result,usersVo);
        return IMoocJSONResult.ok(usersVo);
    }



    @ApiOperation(value="用户上传头像", notes="用户上传头像的接口")
    @ApiImplicitParam(name="userId", value="用户id", required=true,
            dataType="String", paramType="query")
    @PostMapping("/uploadFace")
    public IMoocJSONResult uploadFace(String userId, @RequestParam("file") MultipartFile[] files) throws Exception {
        //判断用户名不能为空
        if (StringUtils.isBlank(userId)) {
            return IMoocJSONResult.errorMsg("用户id不能为空，请重试！");
        }

        //文件保存的命名空间
        String fileSpace = "D:/wxapp";

        //保存到数据库的相对路径
        String uploadPathDB = "/" + userId + "/face";

        //定义输入输出流
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            if (files!=null && files.length>0){
                String filename = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(filename)){
                    //组装成最终路径
                    String finalFacePath = fileSpace + uploadPathDB + "/" + filename;
                    //数据库的相对路径
                    uploadPathDB+=("/"+filename);
                    //将路径写入文件对象outfile
                    File outfile = new File(finalFacePath);
                    //如果没有路径文件夹，则创建
                    if (outfile.getParentFile()!=null || !outfile.getParentFile().isDirectory()){
                        outfile.getParentFile().mkdirs();
                    }
                    //将文件对象outfile写入输出流
                    fileOutputStream = new FileOutputStream(outfile);
                    //初始化输入流
                    inputStream = files[0].getInputStream();
                    //复制属性
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            }else {
                return IMoocJSONResult.errorMsg("上传失败！");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return IMoocJSONResult.errorMsg("上传失败！");
        } finally {
            //关闭流
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        //将用户ID和图片相对路径上传到数据库
        Users u = new Users();
        u.setId(userId);
        u.setFaceImage(uploadPathDB);
        usersService.updateById(u);


        return IMoocJSONResult.ok(uploadPathDB);

    }

}

