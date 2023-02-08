package yours.tool.springboot.pojo.base;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * @Author wbh
 * @Description 分页入参
 * @Date 2021/6/28 14:01
 */
@ApiModel("分页入参")
public class PageDto extends BaseDto {

    private static final long serialVersionUID = -7536046811589532095L;

    @NotNull(message = "页数不能为空")
    @ApiModelProperty(value = "页数", required = true)
    private Integer page;

    @NotNull(message = "条数不能为空")
    @ApiModelProperty(value = "条数", required = true)
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
