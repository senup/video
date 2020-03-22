package com.wxapp.video;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testJunitRunWith {

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
}
