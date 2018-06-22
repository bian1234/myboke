package com.byk.myboke.commen.acpect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author: bianyakun
 * @Date: 2018/6/19 18:22
 * @Todo:
 */

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);



    /**
     * @Author: bianyakun
     * @Date: 2018/6/21 11:13
     * @todo:    切点控制，所与的controller都要走这个切点
     * @param:   * @param null
     */
    @Pointcut("execution( * com.byk..controller.*.*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void logPointCut() {
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/6/21 11:14
     * @todo:    前置通知    在logPointCut() 方法前进行通知
     * @param:   * @param null
     */
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("请求地址 : " + request.getRequestURL().toString());
        logger.info("请求方式 : " + request.getMethod());
//        // 获取ip地址    ip可能是假的
//        logger.info("IP : " +ipUtil. );
        logger.info("请求的类和方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        logger.info("参数 : " + Arrays.toString(joinPoint.getArgs()));

    }

    /**
     * @Author: bianyakun
     * @Date: 2018/6/21 11:23
     * @todo:   后置通知获取返回值
     * @param:   * @param null
     */
    @AfterReturning(returning = "ret", pointcut = "logPointCut()")// returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
//        logger.debug("返回值 : " + ret.toString());
        logger.debug("返回值 : " + ret);
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/6/21 11:22
     * @todo:   环绕通知监控方法时间
     * @param:   * @param null
     */
    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        logger.info("耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }
}
