package yours.tool.springboot.enums;

/**
 * @description: 倒计时类型
 * @author：wbh
 * @data 2023/2/1 8:50
 * @version: v1.0
 **/
public enum CountDownTypeEnum {

    //空
    EMPTY("EMPTY","空"),
    //法定节日
    FESTIVAL("FESTIVAL","法定节日"),
    //法定节假日
    STATUTORY_HOLIDAY("STATUTORY_HOLIDAY","法定节假日"),
    //续费
    RENEW("RENEW","续费"),
    //事件
    EVENT("EVENT","事件");

    CountDownTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;
    public static String getMessage(String code){
        for (CountDownTypeEnum thisEnum: CountDownTypeEnum.values()) {
            if (thisEnum.getCode().equals(code)) {
                return thisEnum.getMessage();
            }
        }
        return "";
    }

    public static String getCode(String message){
        for (CountDownTypeEnum thisEnum : CountDownTypeEnum.values()) {
            if (thisEnum.getMessage().equals(message)){
                return thisEnum.getCode();
            }
        }
        return null;
    }

    public static CountDownTypeEnum getEnumByCode(String code) {
        for (CountDownTypeEnum thisEnum: CountDownTypeEnum.values()) {
            if (thisEnum.getCode().equals(code)) {
                return thisEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
