package yours.tool.springboot.pojo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @description: 倒计时
 * @author：wbh
 * @data 2023/2/2 14:36
 * @version: v1.0
 **/
@ApiModel(value = "倒计时修改入参")
public class CountDownUpdateDto extends CountDownDto {

    @ApiModelProperty(value = "倒计时id")
    @NotBlank(message = "倒计时id不能为空")
    private String countDownId;

    public String getCountDownId() {
        return countDownId;
    }

    public void setCountDownId(String countDownId) {
        this.countDownId = countDownId;
    }
}
