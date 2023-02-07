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

    /**
     * 倒计时通知id
     */
    public Long getCountDownNotifyId() {
        return countDownNotifyId;
    }

    /**
     * 倒计时通知id
     */
    public void setCountDownNotifyId(Long countDownNotifyId) {
        this.countDownNotifyId = countDownNotifyId;
    }

    /**
     * 倒计时id
     */
    public Long getCountDownId() {
        return countDownId;
    }

    /**
     * 倒计时id
     */
    public void setCountDownId(Long countDownId) {
        this.countDownId = countDownId;
    }

    /**
     * 提醒内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 提醒内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 时间
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * 时间
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    /**
     * 提醒状态
     */
    public String getRemindStatus() {
        return remindStatus;
    }

    /**
     * 提醒状态
     */
    public void setRemindStatus(String remindStatus) {
        this.remindStatus = remindStatus;
    }

    /**
     * 填充
     */
    public String getFill() {
        return fill;
    }

    /**
     * 填充
     */
    public void setFill(String fill) {
        this.fill = fill;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CountDownNotify other = (CountDownNotify) that;
        return (this.getCountDownNotifyId() == null ? other.getCountDownNotifyId() == null : this.getCountDownNotifyId().equals(other.getCountDownNotifyId()))
            && (this.getCountDownId() == null ? other.getCountDownId() == null : this.getCountDownId().equals(other.getCountDownId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDatetime() == null ? other.getDatetime() == null : this.getDatetime().equals(other.getDatetime()))
            && (this.getRemindStatus() == null ? other.getRemindStatus() == null : this.getRemindStatus().equals(other.getRemindStatus()))
            && (this.getFill() == null ? other.getFill() == null : this.getFill().equals(other.getFill()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCountDownNotifyId() == null) ? 0 : getCountDownNotifyId().hashCode());
        result = prime * result + ((getCountDownId() == null) ? 0 : getCountDownId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDatetime() == null) ? 0 : getDatetime().hashCode());
        result = prime * result + ((getRemindStatus() == null) ? 0 : getRemindStatus().hashCode());
        result = prime * result + ((getFill() == null) ? 0 : getFill().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", countDownNotifyId=").append(countDownNotifyId);
        sb.append(", countDownId=").append(countDownId);
        sb.append(", content=").append(content);
        sb.append(", type=").append(type);
        sb.append(", datetime=").append(datetime);
        sb.append(", remindStatus=").append(remindStatus);
        sb.append(", fill=").append(fill);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}