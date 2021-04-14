package com.xtructure.graph.utils;

import com.redislabs.redisgraph.ResultSet;
import com.redislabs.redisgraph.impl.api.RedisGraph;
import com.xtructure.graph.common.GraphAssert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Description: // RedisGraph工具类
 * <p>
 * Created by wangziren on 2021/4/14.
 * Create time: 8:17 下午
 */
@Slf4j
@Component
public class RedisGraphUtil {

    private static RedisGraph redisGraph;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    /**
     * 无参构造方法
     */
    private RedisGraphUtil() {

    }

    /**
     * 实例化方法
     */
    @PostConstruct
    private void init() {
        redisGraph = new RedisGraph(host, port);
    }

    public ResultSet query(String graphId, String query) {
        GraphAssert.notBlank(graphId, "graphId入参为空!");
        GraphAssert.notBlank(query, "query入参为空!");
        log.info("|->RedisGraphUtil.query(graphId:{},query:{})", graphId, query);
        ResultSet resultSet = redisGraph.query(graphId, query);
        return resultSet;
    }
}
