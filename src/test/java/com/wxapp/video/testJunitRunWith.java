package com.wxapp.video;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxapp.video.entity.Users;
import com.wxapp.video.entity.Videos;
import com.wxapp.video.mapper.VideosMapperCustom;
import com.wxapp.video.service.IUsersService;
import com.wxapp.video.service.IVideosService;
import com.wxapp.video.service.IVideosServiceCustom;
import com.wxapp.video.service.impl.VideosServiceCustomImpl;
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
    @Autowired
    private IVideosServiceCustom videosService;


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


//    @Autowired
//    private FyUserService service;
//
//    /**
//     * 联表查询并分页
//     */
//    @Test
//    public void contextLoads() {
//        // 当前页，总条数 构造 page 对象
//        Page<UserRoleVo> page = new Page<>(1, 10);
//        page.setRecords(service.selectUserListPage(page));
//        System.out.println(page);
//    }


    //        private List<T> records;   对象列表
//        private long total;			总记录
//        private long size;			每页记录数
//        private long current;		当前的页数
//        private List<OrderItem> orders;    //和数据库列有关
//        private boolean optimizeCountSql;  //是否记录优化
//        private boolean isSearchCount;     //是否搜索



    //测试分页+ 多表
//    @Test
//    public void test4(){
//        Page<VideosVo> page = new Page<>(2, 5);
//        Page<VideosVo> results = videosMapperCustom.queryAllVideos(page);
//        List<VideosVo> resultList = results.getRecords();
//
//        for (VideosVo r:resultList
//                ) {
//            System.out.println("一条记录："+r);
//        }
//        System.out.println("============================");
//        results.hasNext();
//        System.out.println("是否有下一页:"+results.hasNext());
//        System.out.println("当前页:"+results.getCurrent());
//        System.out.println("总数："+results.getTotal());
//        System.out.println("getPages():"+results.getPages());
//        System.out.println("getOrders():"+results.getOrders());
//        System.out.println("getSize():"+results.getSize());
//    }


//    @Test
//    public void testPageAndMoreCondition(){
//        Videos videos = new Videos();
//        videos.setVideoDesc("风");
//        Page<VideosVo> objectPage = new Page<>();
//        Page<VideosVo> page = videosService.queryAllVideos(videos,1,objectPage);
//        System.out.println(page.getTotal());
//    }

}
