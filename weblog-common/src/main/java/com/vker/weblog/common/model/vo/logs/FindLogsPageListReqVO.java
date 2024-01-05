package com.vker.weblog.common.model.vo.logs;

import com.vker.weblog.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;

/**
 * @Author: 寒江雪
 * @Date: 2024-01-05
 * @Description: 查询日志分页数据入参
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "查询日志分页数据入参 VO")
public class FindLogsPageListReqVO extends BasePageQuery {

    @ApiModelProperty(value = "IP地址")
    private String ip;

    @ApiModelProperty(value = "开始时间")
    private LocalDate startDate;

    @ApiModelProperty(value = "结束时间")
    private LocalDate endDate;

}
