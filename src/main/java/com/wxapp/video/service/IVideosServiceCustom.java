package com.wxapp.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxapp.video.entity.Videos;
import com.wxapp.video.vo.VideosVo;

import java.util.List;

/**
 * <p>
 * 视频信息表 服务类
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
public interface IVideosServiceCustom extends IService<VideosVo> {
    @Override
    List<VideosVo> list();


}
