package com.xtructure.graph.web;

import com.alibaba.cola.exception.ExceptionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: // RedisController
 * <p>
 * Created by wangziren on 2021/4/8.
 * Create time: 3:16 下午
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

    @GetMapping("/exc")
    public String exc() {
        log.info("|->RedisController.exc");
        throw ExceptionFactory.bizException("测试日志方法!");
    }
}
