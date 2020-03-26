package com.wxapp.video.service.impl;

import com.wxapp.video.entity.Videos;
import com.wxapp.video.mapper.VideosMapper;
import com.wxapp.video.org.n3r.idworker.Sid;
import com.wxapp.video.service.IVideosService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private VideosMapper videosMapper;

    @Autowired
    private Sid sid;


    public String saveVideo(Videos video){
        String id = sid.nextShort();
        video.setId(id);
        videosMapper.insert(video);
        return id;
    }

    @Override
    public String updateVideo(String videoId, String uploadPathDB) {
        Videos video = new Videos();
        video.setId(videoId);
        video.setCoverPath(uploadPathDB);
        videosMapper.updateById(video);
        return videoId;
    }

}
