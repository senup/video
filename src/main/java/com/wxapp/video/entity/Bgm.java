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
@ApiModel(value="Bgm对象", description="")
public class Bgm implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String author;

    private String name;

    @ApiModelProperty(value = "播放地址")
    private String path;


}
