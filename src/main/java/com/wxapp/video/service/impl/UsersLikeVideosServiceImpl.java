package com.wxapp.video.service.impl;

import com.wxapp.video.entity.UsersLikeVideos;
import com.wxapp.video.mapper.UsersLikeVideosMapper;
import com.wxapp.video.service.IUsersLikeVideosService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户喜欢的/赞过的视频 服务实现类
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@Service
public class UsersLikeVideosServiceImpl extends ServiceImpl<UsersLikeVideosMapper, UsersLikeVideos> implements IUsersLikeVideosService {

}
