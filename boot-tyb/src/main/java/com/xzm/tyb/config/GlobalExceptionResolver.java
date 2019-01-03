package com.xzm.tyb.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import com.xzm.tyb.common.entity.ServerResponse;
import com.xzm.tyb.common.exception.RRException;
//import org.apache.shiro.authz.UnauthenticatedException;
//import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionResolver {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

//    @ExceptionHandler(UnauthenticatedException.class)
//    public void page401(HttpServletResponse response, UnauthenticatedException e) {
//        logger.debug("===page401==HttpServletResponse==" + e.getMessage());
////        ServerResponse<Object> result = new ServerResponse<>();
////            result.setCode(RetCode.UNAUTHEN).setMsg("用户未登录").setData(null);
////        responseResult(response, result);
//    }
//
//    @ExceptionHandler(UnauthorizedException.class)
//    public void page403(HttpServletResponse response, UnauthorizedException e) {
//        logger.debug("===page403==HttpServletResponse==" + e.getMessage());
////        RetResult<Object> result = new RetResult<>();
////        result.setCode(RetCode.UNAUTHZ).setMsg("用户没有访问权限").setData(null);
////        responseResult(response, result);
//    }
    /** 路径方法找不到异常 */
    @ExceptionHandler(NoHandlerFoundException.class)
    public void page403(HttpServletResponse response, NoHandlerFoundException  e) {
//        HttpStatus notFound = HttpStatus.NOT_FOUND;
        logger.debug("===方法找不到==HttpServletResponse==" + e.getMessage());
        ServerResponse<Object> serverResponse =
                ServerResponse.createByErrorCodeMessage(404,"找不到"+e.getMessage());
        responseResult(response,serverResponse);
    }
    /**
     * 业务异常的处理
     */
    @ExceptionHandler(value = RRException.class)
    public void serviceExceptionHandler(HttpServletResponse response, RRException e) {
//        RetResult<Object> result = new RetResult<>();
//        result.setCode(RetCode.FAIL).setMsg(e.getMessage()).setData(null);
//        responseResult(response, result);
        logger.debug("全局业务异常==");
        ServerResponse<Object> serverResponse =
                ServerResponse.createByErrorCodeMessage(e.getCode(),e.getMessage());
        responseResult(response,serverResponse);
    }
    /**
     * 其他异常统一处理
     */
    @ExceptionHandler(value = Exception.class)
    public void exceptionHandler(HttpServletResponse response, Exception e) {
        logger.debug("===其他异常统一处理==" + e.getMessage());
//        logger.debug("===其他异常统一处理==" + e.getMessage());
//        RetResult<Object> result = new RetResult<>();
//        result.setCode(RetCode.INTERNAL_SERVER_ERROR).setMsg("服务器打酱油了，请稍后再试~");
//        logger.error(e.getMessage(), e);
//        responseResult(response, result);
        ServerResponse<Object> serverResponse =
                ServerResponse.createByErrorCodeMessage(404,"找不到"+e.getMessage());
        responseResult(response,serverResponse);
    }

//
//    @ExceptionHandler(value = {IOException.class, RuntimeException.class})
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    private MyInfo illegalParamsExceptionHandler(Exception ex) {
//    }
//
//    @ExceptionHandler(value = {NoHandlerFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ModelAndView noMapping(Exception ex) {
//        HttpServletRequest request= MyClass.getRequest();
//        LOGGER.error("error-----404---->" + request.getContextPath(), ex);
//        return new ModelAndView("errorpage/error");
//    }
    /**
     * @param response
     * @param result
     * @Title: responseResult
     * @Description: 响应结果
     * @Reutrn void
     */
    private void responseResult(HttpServletResponse response, ServerResponse<Object> result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
