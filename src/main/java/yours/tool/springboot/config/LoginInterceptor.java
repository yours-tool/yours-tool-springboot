package yours.tool.springboot.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Description:
 * @Author：wbh
 * @Data 2022/3/19 10:16
 * @Version: v1.0
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        String jwtFromRequest = jwtHandler.getJwtFromRequest(request);
//        if (ValidateUtil.isEmpty(jwtFromRequest)){
//            return false;
//        }
//        //这里面是校验jwt的 如果失败会抛出异常
//        jwtHandler.parseJwt(jwtFromRequest);

        doPrintRequestLog(request);
        return true;
    }

    private void doPrintRequestLog(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, Object> headerMap = Maps.newHashMapWithExpectedSize(10);
        do {
            String header = headerNames.nextElement();
            headerMap.put(header, request.getHeader(header));
        } while (headerNames.hasMoreElements());

        String token = request.getParameter("token");
        if (StrUtil.isEmpty(token)) {
            token = request.getHeader("token");
        }
        log.info("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-■GOODS SERVICE■-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                        "请求地址  >>>  {}\n" +
                        "请求方法  >>>  {}\n" +
                        "请求参数  >>>  {}\n" +
                        "请求来源  >>>  {}\n" +
                        "用户令牌  >>>  {}\n",
                request.getRequestURI(),
                request.getMethod(),
                JSONUtil.toJsonStr(request.getParameterMap()),
                request.getRemoteAddr(),
                token
        );
    }
}
