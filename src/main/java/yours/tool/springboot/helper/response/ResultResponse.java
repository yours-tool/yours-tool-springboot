package yours.tool.springboot.helper.response;



import yours.tool.springboot.enums.ResultStatusEnum;

import java.io.Serializable;


/**
 * @Author wbh
 * @Description rpc调用返参
 * @Date 2021/6/17 16:08
 * @Version: v1.0
 */

public class ResultResponse<T> implements Serializable {

    private static final long serialVersionUID = 5989814216497545490L;

    /** 状态码*/
    private Integer status;

    /** 消息正文*/
    private String msg;

    /** 数据*/
    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功
     * @param data 数据
     * @return
     */
    public static <T> ResultResponse<T> ofSuccess(T data) {
        ResultResponse RpcResponse = new ResultResponse();
        RpcResponse.setStatus(ResultStatusEnum.SUCCESS.getCode());
        if (null != data) {
            RpcResponse.setData(data);
        }
        return RpcResponse;
    }

    /**
     * 成功
     * @return
     */
    public static ResultResponse ofSuccess() {
        return ofSuccess(null);
    }

    /**
     * 失败
     * @param msg 提示语
     * @return
     */
    public static ResultResponse ofError(String msg) {
        ResultResponse RpcResponse = new ResultResponse();
        RpcResponse.setStatus(ResultStatusEnum.FAIL.getCode());
        RpcResponse.setMsg(msg);
        return RpcResponse;
    }

    /**
     * 失败
     * @return
     */
    public static ResultResponse ofError() {
       return ofError("");
    }

    /**
     * 构造一个异常的API返回
     * @param resultStatusEnum 枚举
     */
    public static ResultResponse ofException(ResultStatusEnum  resultStatusEnum) {
        ResultResponse RpcResponse = new ResultResponse();
        RpcResponse.setStatus(resultStatusEnum.getCode());
        RpcResponse.setMsg(resultStatusEnum.getMessage());
        return RpcResponse;
    }

    /**
     * 构造一个异常的API返回
     * @param code 返回code
     * @param message 返回数据
     * @return 数据
     */
    public static ResultResponse ofException(Integer code ,String message) {
        ResultResponse RpcResponse = new ResultResponse();
        RpcResponse.setStatus(code);
        RpcResponse.setMsg(message);
        return RpcResponse;
    }

    /**
     * 构造一个异常的API返回
     */
    public static ResultResponse ofException() {
        return ofException(ResultStatusEnum.BAD_REQUEST);
    }




}
