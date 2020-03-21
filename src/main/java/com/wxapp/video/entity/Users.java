package com.wxapp.video.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Users对象", description="")
public class Users implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "我的头像，如果没有默认给一张")
    private String faceImage;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "我的粉丝数量")
    private Integer fansCounts;

    @ApiModelProperty(value = "我关注的人总数")
    private Integer followCounts;

    @ApiModelProperty(value = "我接受到的赞美/收藏 的数量")
    private Integer receiveLikeCounts;


}
