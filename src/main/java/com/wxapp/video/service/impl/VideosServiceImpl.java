package com.wxapp.video.service.impl;

import com.wxapp.video.entity.Videos;
import com.wxapp.video.mapper.VideosMapper;
import com.wxapp.video.service.IVideosService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 视频信息表 服务实现类
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@Service
public class VideosServiceImpl extends ServiceImpl<VideosMapper, Videos> implements IVideosService {

}
