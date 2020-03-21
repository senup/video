package com.wxapp.video.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 举报用户表
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UsersReport对象", description="举报用户表")
public class UsersReport implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    @ApiModelProperty(value = "被举报用户id")
    private String dealUserId;

    private String dealVideoId;

    @ApiModelProperty(value = "类型标题，让用户选择，详情见 枚举")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "举报人的id")
    private String userid;

    @ApiModelProperty(value = "举报时间")
    private LocalDateTime createDate;


}
