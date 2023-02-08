package yours.tool.springboot.pojo.base;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author wbh
 * @Description 分页视图
 * @Date 2021/6/28 13:26
 */
@ApiModel("分页视图")
public class PageVo<T> extends BaseVo {

    private static final long serialVersionUID = -5961181597688230462L;

    @ApiModelProperty(value = "通用参数")
    private List<T> dataList = Lists.newArrayList();

    @ApiModelProperty(value = "总条数")
    private Long total;

    public PageVo() {
    }

    public PageVo(List<T> dataList, Long total) {
        this.dataList = dataList;
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
