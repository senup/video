package com.wxapp.video;

import com.wxapp.video.entity.Users;
import com.wxapp.video.service.IUsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testJunitRunWith {
    @Autowired
    private IUsersService usersService;

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
}
