package com.csp.application.aspect;

import com.csp.application.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @description: 切面
 * @author: csp
 * @date: 2020/05/18
 */
@Aspect
@Configuration
@Profile("dev")
public class ServiceAspect {

    @Pointcut("execution(* com.csp.application.*Service.*(..))")
    private void excuteService() {}

    /**
     * 1.拦截service请求
     * 2.根据数据库查询结果修改返回值
     *
     * @throws Exception
     */
    @AfterReturning(value = "excuteService()", returning = "keys")
//    @AfterReturning(value = "@annotation(MockService)",returning = "keys")
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object keys) throws Exception {
        // 根据类名和方法名去数据库查询记录
        if (joinPoint.getSignature().getDeclaringTypeName() != null && joinPoint.getSignature().getName() != null) {
            // 判断接口开关

            // 类名（包含包路径） 表属性 前端配置
            // 方法名 表属性 前端配置

            // 如果有，则拦截请求

            // 从根据入参查询db相应配置结果
            Object[] args = joinPoint.getArgs();
            //  入参
            Object params;
            // 返回值
            Object object;

        } else {
            // 查不到，则说明未配置mock，直接返回结果

        }


        System.out.println("后置返回通知的返回值：" + keys);
        if (keys instanceof User) {
            User user = (User) keys;
            String message = user.getMessage();
            user.setMessage("通过AOP把值修改了 " + message);
        }
        System.out.println("修改完毕-->返回方法为:" + keys);

    }
}
