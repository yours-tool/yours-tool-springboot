package yours.tool.springboot.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import yours.tool.springboot.pojo.base.PageDto;

/**
 * @description: 倒计时
 * @author：wbh
 * @data 2023/2/2 14:36
 * @version: v1.0
 **/
@ApiModel(value = "倒计时列表入参")
public class CountDownListDto extends PageDto {

    @ApiModelProperty(value = "主题/标签")
    private String content;

    @ApiModelProperty(value = "类型")
    private String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
