package com.wxapp.video.service.impl;

import com.wxapp.video.entity.Comments;
import com.wxapp.video.mapper.CommentsMapper;
import com.wxapp.video.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程评论表 服务实现类
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
