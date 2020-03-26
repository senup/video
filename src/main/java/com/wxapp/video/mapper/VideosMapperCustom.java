package com.wxapp.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

//    @Select("SELECT * FROM fy_user u LEFT JOIN fy_role r ON u.role = r.id")
//    List<UserRoleVo> selectUserListPage(Page<UserRoleVo> pagination);

    List<VideosVo> queryAllVideos(Page<VideosVo> pagination);

}
