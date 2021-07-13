package com.xtructure.graph.common;

import com.alibaba.cola.exception.Assert;
import com.alibaba.cola.exception.BizException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;


/**
 * Description: // 项目增强Assert
 * <p>
 * Created by wangziren on 2021/4/8.
 * Create time: 5:16 下午
 */
public class GraphAssert extends Assert {

    /**
     * 对空字符串断言
     *
     * @param str        被判断字符串
     * @param errMessage 异常提示
     */
    public static void blank(String str, String errMessage) {
        if (StringUtils.isNotBlank(str)) {
            throw new BizException(errMessage);
        }
    }

    /**
     * 对非空字符串断言
     *
     * @param str        被判断字符串
     * @param errMessage 异常提示
     */
    public static void notBlank(String str, String errMessage) {
        if (StringUtils.isBlank(str)) {
            throw new BizException(errMessage);
        }
    }

    /**
     * 对字符串equals封装
     *
     * @param source     发起比较的字符串
     * @param target     被比较的字符串
     * @param errMessage 异常提示
     */
    public static void equals(String source, String target, String errMessage) {
        if (!StringUtils.equals(source, target)) {
            throw new BizException(errMessage);
        }
    }

    /**
     * 对字符串notEquals封装
     *
     * @param source     发起比较的字符串
     * @param target     被比较的字符串
     * @param errMessage 异常提示
     */
    public static void notEquals(String source, String target, String errMessage) {
        if (StringUtils.equals(source, target)) {
            throw new BizException(errMessage);
        }
    }

    /**
     * 等值校验
     *
     * @param source 数据值
     * @param target 目标值
     */
    public static void equals(Number source, Number target, String errMessage) {
        if (source == null || target == null || n2b(source, errMessage).compareTo(n2b(target, errMessage)) != 0) {
            throw new BizException(errMessage);
        }
    }

    /**
     * 最小值校验
     *
     * @param source 数据值
     * @param min    规定最小值
     */
    public static void min(Number source, Number min, String errMessage) {
        if (source == null || n2b(source, errMessage).compareTo(n2b(min, errMessage)) < 0) {
            throw new BizException(errMessage);
        }
    }

    /**
     * 最大值校验
     * <p>
     * source 数据值
     *
     * @param max 规定最大值
     */
    public static void max(Number source, Number max, String errMessage) {
        if (source == null || n2b(source, errMessage).compareTo(n2b(max, errMessage)) > 0) {
            throw new BizException(errMessage);
        }
    }

    /**
     * 将Number转为足够精度的BigDecimal类以便进行数值比较(只转换常用的4个类型)
     *
     * @param source 被转换的数据
     */
    private static BigDecimal n2b(Number source, String msg) {
        if (source instanceof BigDecimal) {
            return (BigDecimal) source;
        } else if (source instanceof Integer) {
            return BigDecimal.valueOf(source.intValue());
        } else if (source instanceof Long) {
            return BigDecimal.valueOf(source.longValue());
        } else if (source instanceof Float) {
            return BigDecimal.valueOf(source.floatValue());
        } else if (source instanceof Double) {
            return BigDecimal.valueOf(source.doubleValue());
        } else {
            throw new BizException(msg + "-不能识别的数据类型！source=" + source);
        }
    }

}
