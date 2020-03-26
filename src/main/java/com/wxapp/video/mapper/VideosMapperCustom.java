package com.wxapp.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxapp.video.entity.Videos;
import com.wxapp.video.vo.VideosVo;

import java.util.List;

/**
 * <p>
 * 视频信息表 Mapper 接口
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
public interface VideosMapperCustom extends BaseMapper<VideosVo> {

    List<VideosVo> queryAllVideos();

}
