package com.wxapp.video.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 视频信息表
 * </p>
 *
 * @author 涛哥
 * @since 2020-03-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Videos对象", description="视频信息表")
public class VideosVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String userId;

    private String audioId;

    private String videoDesc;

    private String videoPath;

    private Float videoSeconds;

    private Integer videoWidth;

    private Integer videoHeight;

    private String coverPath;

    private Long likeCounts;

    private Integer status;

    private Date createTime;

    private String faceImage;

    private String nickname;


}
