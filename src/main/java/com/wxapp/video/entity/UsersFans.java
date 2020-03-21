package com.wxapp.video.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户粉丝关联关系表
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UsersFans对象", description="用户粉丝关联关系表")
public class UsersFans implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    @ApiModelProperty(value = "用户")
    private String userId;

    @ApiModelProperty(value = "粉丝")
    private String fanId;


}
