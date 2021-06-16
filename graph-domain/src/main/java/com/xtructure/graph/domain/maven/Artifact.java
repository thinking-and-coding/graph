package com.xtructure.graph.domain.maven;

import lombok.Data;

import java.util.List;

/**
 * Description: // Artifact领域对象
 * <p>
 * Created by wangziren on 2021/4/19.
 * Create time: 4:59 下午
 */
@Data
public class Artifact {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目描述
     */
    private String describe;

    /**
     * 许可证
     */
    private String license;

    /**
     * 标签
     */
    private List<String> tags;

    /**
     * 最新maven坐标
     */
    private String mavenSite;

    /**
     * 被引项目
     */
    private List<Artifact> usedByList;
}
