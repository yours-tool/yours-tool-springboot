package yours.tool.springboot.pojo.dto;

import com.google.common.collect.Lists;
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
public class CountDownDto extends BaseDto {

    @NotBlank(message = "主题不能为空")
    private String subject;

    @NotBlank(message = "类型不能为空")
    private String type;

    @NotNull(message = "日期不能为空")
    private Date date;

    private List<String> label = Lists.newArrayList();


    private BigDecimal money = new BigDecimal(0);

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
}
