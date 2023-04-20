package com.gdy.thieseback.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery {

    @ApiModelProperty("当前页")
    private Integer current;
    @ApiModelProperty("每页的数量")
    private Integer size;

    @ApiModelProperty(
            hidden = true
    )
    private String ascs;

    @ApiModelProperty(
            hidden = true
    )
    private String descs;


}
