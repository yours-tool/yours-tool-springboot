package yours.tool.springboot.enums;


/**
 * @Author wbh
 * @Description result状态码
 * @Date 2021/6/16 16:51
 * @Version: v1.0
 */
public enum ResultStatusEnum {
    /**
     * 成功
     */
    SUCCESS(10001,"成功"),
    /**
     * 失败
     */
    FAIL(10002,"失败"),
    /**
     * 系统异常
     */
    BAD_REQUEST(10003,"请求异常"),
    /**
     * 没有权限
     */
    UNAUTHORIZED(10004,"请先登录"),

    /**
     * 权限过期
     */
    ACCESS_DENIED(10005,"权限不足"),

    /**
     * token 异常
     */
    TOKEN_EXPIRED(10006,"token 异常！"),

    /**
     * 当前用户已在别处登录，请尝试更改密码或重新登录
     */
    TOKEN_OUT_OF_CTRL(10007,"当前用户已在别处登录，请尝试更改密码或重新登录");

    private Integer code;

    private String message;

    ResultStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
