package com.xtructure.graph.handler;

import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.exception.SysException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.alibaba.cola.dto.Response.buildFailure;

/**
 * Description: // Controller统一异常封装类
 * <p>
 * Created by wangziren on 2021/4/8.
 * Create time: 4:20 下午
 */
@ControllerAdvice
public class SpringExceptionHandler {

    /**
     * 自定义业务异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    public ResponseEntity<Object> handleBizException(BizException e) {
        return new ResponseEntity<>(buildFailure("BizException", e.getMessage()), HttpStatus.OK);
    }

    /**
     * 自定义系统异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(SysException.class)
    public ResponseEntity<Object> handleSysException(SysException e) {
        return new ResponseEntity<>(buildFailure("SysException", e.getMessage()), HttpStatus.OK);
    }

    /**
     * 托底方案
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(final Exception e) {
        return new ResponseEntity<>(buildFailure("Exception", "系统异常!"), HttpStatus.METHOD_FAILURE);
    }
}
