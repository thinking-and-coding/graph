package com.xtructure.graph.web;

import com.alibaba.fastjson.JSON;
import com.redislabs.redisgraph.ResultSet;
import com.xtructure.graph.utils.RedisGraphUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description: // RedisGraphController
 * <p>
 * Created by wangziren on 2021/4/14.
 * Create time: 8:44 下午
 */
@Slf4j
@RestController
@RequestMapping("/redisGraph")
public class RedisGraphController {

    @Resource
    private RedisGraphUtil redisGraphUtil;

    @GetMapping("/query")
    public String query() {
        log.info("|->RedisGraphController.query()");
        ResultSet resultSet = redisGraphUtil.query("social", "MATCH (n) RETURN count(n)");
        log.info("|->RedisGraphController.query.resultSet:{}", JSON.toJSONString(resultSet));
        return "OK";
    }
}
