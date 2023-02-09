package yours.tool.springboot.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import yours.tool.springboot.pojo.base.BaseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description: 倒计时
 * @author：wbh
 * @data 2023/2/2 14:36
 * @version: v1.0
 **/
@ApiModel(value = "倒计时入参")
public class CountDownListVo extends BaseDto {

    @ApiModelProperty(value = "倒计时id")
    private String countDownId;

    @ApiModelProperty(value = "主题")
    private String subject;

    @ApiModelProperty(value = "类型")
    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "日期")
    private Date date;

    @ApiModelProperty(value = "天")
    private Integer day;

    @ApiModelProperty(value = "标签")
    private List<String> label = Lists.newArrayList();

    @ApiModelProperty(value = "金额")
    private BigDecimal money = new BigDecimal(0);

    public String getCountDownId() {
        return countDownId;
    }

    public void setCountDownId(String countDownId) {
        this.countDownId = countDownId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
