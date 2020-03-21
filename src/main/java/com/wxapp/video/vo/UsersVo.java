package com.wxapp.video.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@ApiModel(value="Users对象", description="这是用户对象")
public class UsersVo implements Serializable {

    private static final long serialVersionUID=1L;
    @ApiModelProperty(hidden = true)
    private String id;


    private String userToken;

    @ApiModelProperty(value = "用户名",name = "username",example = "zhangsan",required =true)
    private String username;

    @ApiModelProperty(value = "密码",name = "password",example = "123456",required =true)
    private String password;

    @ApiModelProperty(value = "我的头像，如果没有默认给一张",hidden = true)
    private String faceImage;

    @ApiModelProperty(value = "昵称",hidden = true)
    private String nickname;

    @ApiModelProperty(value = "我的粉丝数量",hidden = true)
    private Integer fansCounts;

    @ApiModelProperty(value = "我关注的人总数",hidden = true)
    private Integer followCounts;

    @ApiModelProperty(value = "我接受到的赞美/收藏 的数量",hidden = true)
    private Integer receiveLikeCounts;


}
