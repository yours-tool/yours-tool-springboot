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

    /**
    * 倒计时id
    */
    private void setCountDownId(Long countDownId){
    this.countDownId = countDownId;
    }

    /**
    * 用户id
    */
    private void setUserId(Long userId){
    this.userId = userId;
    }

    /**
    * 主题
    */
    private void setSubject(String subject){
    this.subject = subject;
    }

    /**
    * 类型
    */
    private void setType(String type){
    this.type = type;
    }

    /**
    * 日期
    */
    private void setDate(Date date){
    this.date = date;
    }

    /**
    * 标签（以|分隔）
    */
    private void setLabel(String label){
    this.label = label;
    }

    /**
    * 金钱
    */
    private void setMoney(BigDecimal money){
    this.money = money;
    }


    /**
    * 倒计时id
    */
    private Long getCountDownId(){
    return this.countDownId;
    }

    /**
    * 用户id
    */
    private Long getUserId(){
    return this.userId;
    }

    /**
    * 主题
    */
    private String getSubject(){
    return this.subject;
    }

    /**
    * 类型
    */
    private String getType(){
    return this.type;
    }

    /**
    * 日期
    */
    private Date getDate(){
    return this.date;
    }

    /**
    * 标签（以|分隔）
    */
    private String getLabel(){
    return this.label;
    }

    /**
    * 金钱
    */
    private BigDecimal getMoney(){
    return this.money;
    }

}
