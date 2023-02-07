package yours.tool.springboot.helper.excepiton;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import yours.tool.springboot.helper.response.ResultResponse;

import javax.validation.ValidationException;

/**
 * @Author wbh
 * @Description 全局统一异常处理
 * @Date 2021/6/18 10:41
 * @Version: v1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultResponse<Void> handlerException(Exception e) {
        log.error("【系统抛出handlerException】 —— 异常内容如下：{}", e);
        return ResultResponse.ofError("服务器正在开小差~~");
    }

    // 直接在方法参数列表中使用注解进行校验，不通过时抛出的异常
    // e.g. public String testValidator(@Sort @RequestParam String sort)

    /**
     * 这个错误在接口的参数列表中如果有 BindingResult 校验会到这里
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResultResponse<Void> validationException(ValidationException e) {
        log.error("【系统抛出ValidationException异常】 —— 异常内容如下：{}", e);
        return ResultResponse.ofError(e.getMessage());
    }

    // 校验实体类中字段不通过时抛出的异常
    // e.g. @Sort private String sort;

    /**
     * 这个错误在接口的参数列表中如果没有有 BindingResult 校验会到这里
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultResponse<Void> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("【系统抛出MethodArgumentNotValidException异常】 —— 异常内容如下：{}", e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        return ResultResponse.ofError(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

    /**
     * 统一处理参数校验错误异常(非Spring接口数据绑定验证) 目前未捕获异常
     *
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultResponse<Void> bindException(BindException e) {
        log.error("【系统抛出BindException异常】 —— 异常内容如下：{}", e);
        return ResultResponse.ofError(e.getMessage());
    }

    /**
     * 统一处理参数校验错误异常 目前未捕获异常 不加@Valid的时候出现
     * 异常信息示例:  For input string: "1422015143827001344 	"
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResultResponse<Void> illegalArgumentException(IllegalArgumentException e) {
        log.error("【系统抛出IllegalArgumentException异常】 —— 异常内容如下：{}", e);
        String illegalValue = null;
        String eMsg = e.getMessage();
        if (StrUtil.isNotBlank(eMsg)) {
            final String beginStr = ": \"";
            int tempIdx = eMsg.indexOf(beginStr);
            if (tempIdx != -1) {
                int beginIdx = tempIdx + beginStr.length();
                int endIdx = eMsg.indexOf("\"", beginIdx);
                if (endIdx != -1) {
                    illegalValue = eMsg.substring(beginIdx, endIdx);
                }
            }
        }
        return ResultResponse.ofError(illegalValue != null ? ("不合法的值(" + illegalValue + ")") : e.getMessage());
    }

    /**
     * 统一处理参数校验错误异常 目前未捕获异常 不加@Valid的时候出现
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResultResponse<Void> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("【系统抛出HttpRequestMethodNotSupportedException异常】 —— 异常内容如下：{}", e);
        return ResultResponse.ofError("请求方式错误");
    }

    /**
     * 统一处理参数校验错误异常 目前未捕获异常 不加@Valid的时候出现
     * 异常信息示例:  Required request parameter 'xxx' is not present
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultResponse<Void> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("【系统抛出MissingServletRequestParameterException异常】 —— 异常内容如下：{}", e);
        String fieldName = null;
        String eMsg = e.getMessage();
        if (StrUtil.isNotBlank(eMsg)) {
            final String beginStr = "Required request parameter \'";
            int tempIdx = eMsg.indexOf(beginStr);
            if (tempIdx != -1) {
                int beginIdx = tempIdx + beginStr.length();
                int endIdx = eMsg.indexOf("\'", beginIdx);
                if (endIdx != -1) {
                    fieldName = eMsg.substring(beginIdx, endIdx);
                }
            }
        }
        return ResultResponse.ofError(StrUtil.isNotBlank(fieldName) ? (fieldName + "不能为空") : e.getMessage());
    }

    /**
     * 统一处理参数校验错误异常 目前未捕获异常 不加@Valid的时候出现
     * 异常信息示例:  Content type 'text/plain;charset=UTF-8' not supported
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public ResultResponse<Void> httpRequestMethodNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.error("【系统抛出HttpMediaTypeNotSupportedException异常】 —— 异常内容如下：{}", e);
        return ResultResponse.ofError("请使用约定的请求头ContentType");
    }

    /**
     * 统一处理参数校验错误异常 目前未捕获异常 不加@Valid的时候出现
     * 异常信息示例:  Required request body is missing: ...
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultResponse<Void> httpRequestMethodNotSupportedException(HttpMessageNotReadableException e) {
        log.error("【系统抛出HttpMessageNotReadableException异常】 —— 异常内容如下：{}", e);
        return ResultResponse.ofError("参数不能为空(或者参数错误)");
    }

}
