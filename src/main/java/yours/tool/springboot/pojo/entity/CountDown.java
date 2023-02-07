package yours.tool.springboot.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("count_down_t")
public class CountDown implements Serializable {

    /**
    * 倒计时id
    */
    @TableId(value = "count_down_id", type = IdType.INPUT)
    private Long countDownId;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 主题
    */
    private String subject;
    /**
    * 类型
    */
    private String type;
    /**
    * 日期
    */
    private Date date;
    /**
    * 标签（以|分隔）
    */
    private String label;
    /**
    * 金钱
    */
    private BigDecimal money;

    public Long getCountDownId() {
        return countDownId;
    }

    public void setCountDownId(Long countDownId) {
        this.countDownId = countDownId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CountDown{");
        sb.append("countDownId=").append(countDownId);
        sb.append(", userId=").append(userId);
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", date=").append(date);
        sb.append(", label='").append(label).append('\'');
        sb.append(", money=").append(money);
        sb.append('}');
        return sb.toString();
    }
}
