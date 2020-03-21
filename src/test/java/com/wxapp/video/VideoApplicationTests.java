package com.wxapp.video;

import com.wxapp.video.entity.Users;
import com.wxapp.video.service.IUsersService;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class VideoApplicationTests {
	@Autowired
	private IUsersService usersService;

	@Test
	public void contextLoads() {
		List<Users> users = usersService.list();
		for (Users u:users) {
			System.out.println(u);
		}
	}

    @Test
    public void queryForPage() {

    }


}
