package yours.tool.springboot.helper.mybatis;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author： wbh
 * @Date: 2021/12/13 15:09
 * @Version: v1.0
 **/
@Aspect
@Component
public class MybatisAspectj {

    // 配置织入点
    @Pointcut("execution(public * com.baomidou.mybatisplus.core.mapper.BaseMapper.selectOne(..))")
    public void selectOneAspect() {
    }

    @Before("selectOneAspect()")
    public void beforeSelect(JoinPoint point) {
        Object arg = point.getArgs()[0];
        if (arg instanceof AbstractWrapper) {
            arg = (AbstractWrapper) arg;
            ((AbstractWrapper) arg).last("limit 1");
        }
    }

}
