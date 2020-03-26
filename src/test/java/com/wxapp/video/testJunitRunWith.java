package com.wxapp.video;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxapp.video.entity.Users;
import com.wxapp.video.entity.Videos;
import com.wxapp.video.mapper.VideosMapperCustom;
import com.wxapp.video.service.IUsersService;
import com.wxapp.video.vo.VideosVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testJunitRunWith {
    @Autowired
    private IUsersService usersService;
    @Autowired
    private VideosMapperCustom videosMapperCustom;

    @Test
    public void line() {
        System.out.println("======================================================================================");
    }



    @Test
    public void testFileCreate(){
        line();
        File file = new File("D:/outer/inner/haha.txt");
        System.out.println(file.getParentFile().isDirectory());
        if(file.getParentFile()!=null || !file.getParentFile().isDirectory()){
            file.getParentFile().mkdirs();
        }
    }


    //测试更新功能
    @Test
    public void testuploadFacePath(){
        Users u = new Users();
        u.setId("200321GZTKR6SPPH");
        u.setFaceImage("hahahah");
        usersService.updateById(u);
    }


    //测试查询全部功能
    @Test
    public void testListAll(){
        List<Users> users = usersService.list();
        for (Users u:users) {
            System.out.println(u);
        }

    }



    //测试查询全部功能+分页
    @Test
    public void testListAllPage(){
        IPage<Users> userPage=new Page<>(2,2);
        IPage<Users> page = usersService.page(userPage);
        List<Users> records = page.getRecords();
        System.out.println(page);
        for (Users u:records) {
            System.out.println(u);
        }

}



    //测试查询全部功能+分页+条件
    @Test
    public void testListAllPage2(){
        IPage<Users> userPage=new Page<>(2,2);
        //条件查询
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.like("nickname","a");
        IPage<Users> page = usersService.page(userPage,wrapper);

        List<Users> records = page.getRecords();
        System.out.println(page);
        for (Users u:records) {
            System.out.println(u);
        }

    }



}
