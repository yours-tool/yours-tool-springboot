package yours.tool.springboot.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;


@TableName(value ="count_down_notify")
public class CountDownNotify implements Serializable {
    /**
     * 倒计时通知id
     */
    @TableId(value = "count_down_notify_id", type = IdType.INPUT)
    private Long countDownNotifyId;

    /**
     * 倒计时id
     */
    private Long countDownId;

    /**
     * 提醒内容
     */
    private String content;

    /**
     * 类型
     */
    private String type;

    /**
     * 时间
     */
    private Date datetime;

    /**
     * 提醒状态
     */
    private String remindStatus;

    /**
     * 填充
     */
    private String fill;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Long getCountDownNotifyId() {
        return countDownNotifyId;
    }

    public void setCountDownNotifyId(Long countDownNotifyId) {
        this.countDownNotifyId = countDownNotifyId;
    }

    public Long getCountDownId() {
        return countDownId;
    }

    public void setCountDownId(Long countDownId) {
        this.countDownId = countDownId;
    }

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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getRemindStatus() {
        return remindStatus;
    }

    public void setRemindStatus(String remindStatus) {
        this.remindStatus = remindStatus;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CountDownNotify{");
        sb.append("countDownNotifyId=").append(countDownNotifyId);
        sb.append(", countDownId=").append(countDownId);
        sb.append(", content='").append(content).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", datetime=").append(datetime);
        sb.append(", remindStatus='").append(remindStatus).append('\'');
        sb.append(", fill='").append(fill).append('\'');
        sb.append('}');
        return sb.toString();
    }
}