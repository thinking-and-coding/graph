package com.xtructure.graph.web;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Description: // 响应式编程Controller
 * <p>
 * Created by wangziren on 2021/4/7.
 * Create time: 8:56 下午
 */
@Slf4j
@RestController
@RequestMapping("/reactive")
public class ReactiveController {

    @GetMapping("mono")
    public Mono<String> mono() {
        log.info("|->ReactiveController.mono");
        return Mono.just("hello webflux");
    }

    @GetMapping("asyncMono")
    public Mono<Object> asyncMono() {
        return Mono.create(monoSink -> {
            log.info("创建 Mono.monoSink:{}", JSON.toJSONString(monoSink));
            monoSink.success("hello webflux");
        })
                //当订阅者去订阅发布者的时候，该方法会调用
                .doOnSubscribe(subscription -> {
                    log.info("subscription:{}", JSON.toJSONString(subscription));
                })
                // 当订阅者收到数据时，该方法会调用
                .doOnNext(o -> {
                    log.info("o:{}", JSON.toJSONString(o));
                });
    }
}
