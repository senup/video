package com.wxapp.video.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxapp.video.entity.Videos;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxapp.video.vo.VideosVo;

/**
 * <p>
 * 视频信息表 服务类
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
public interface IVideosService extends IService<Videos> {
    String saveVideo(Videos video);

    String updateVideo(String videoId, String uploadPathDB);

}
