package cn.lx.security.handlerException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * com.itheima.handlerException
 *
 * @Author Administrator
 * @date 18:05
 */
@ControllerAdvice
public class ExceptionAdvice {

    //403异常就跳转到这个页面
    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(){
        return "forward:/403.jsp";
    }
}
