package com.xtructure.graph.web;

import com.alibaba.cola.exception.ExceptionFactory;
import com.wzr.exceptionlog.ExceptionLog;
import com.xtructure.graph.common.GraphAssert;
import com.xtructure.graph.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private RedisGraphController redisGraphController;

    @Cacheable(cacheNames = "cache", keyGenerator = "myKeyGenerator", condition = "#key!=null and #value!=null")
    @GetMapping("/add/{key}/{value}")
    public String add(@PathVariable("key") String key, @PathVariable("value") String value) {
        GraphAssert.notBlank(key, "add方法输入参数{key}为空!");
        GraphAssert.notBlank(value, "add方法输入参数{value}为空!");
        log.info("|->RedisController.add(key:{},value:{})", key, value);
        redisUtil.set(key, value);
        return "OK";
    }

    @GetMapping("/del/{key}")
    public String del(@PathVariable("key") String key) {
        GraphAssert.notBlank(key, "del方法输入参数{key}为空!");
        log.info("|->RedisController.del(key:{})", key);
        redisUtil.del(key);
        return "OK";
    }

    @GetMapping("/exc")
    public String exc() {
        log.info("|->RedisController.exc");
        throw ExceptionFactory.bizException("测试日志方法!");
    }

    @GetMapping("/log")
    public String log() {
        log.info("|->RedisController.log");
        redisGraphController.testAnnotation();
        return "OK";
    }

    @GetMapping("/log2")
    public String log2() {
        log.info("|->RedisController.log2");
        redisGraphController.testAnnotation2("运行时异常!");
        return "OK";
    }

}
