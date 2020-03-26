package com.wxapp.video.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxapp.video.entity.Videos;
import com.wxapp.video.mapper.VideosMapper;
import com.wxapp.video.mapper.VideosMapperCustom;
import com.wxapp.video.org.n3r.idworker.Sid;
import com.wxapp.video.service.IVideosService;
import com.wxapp.video.service.IVideosServiceCustom;
import com.wxapp.video.vo.VideosVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 视频信息表 服务实现类
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@Service
public class VideosServiceCustomImpl extends ServiceImpl<VideosMapperCustom, VideosVo> implements IVideosServiceCustom {

    @Autowired
    private VideosMapperCustom videosMapperCustom;




    public List<VideosVo> queryAllVideos(Page<VideosVo> page) {

        return videosMapperCustom.queryAllVideos(page);
    }
}
