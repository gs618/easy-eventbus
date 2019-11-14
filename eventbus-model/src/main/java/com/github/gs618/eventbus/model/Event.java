package com.github.gs618.eventbus.model;

import java.io.Serializable;

/**
 * 事件类型接口
 *
 * 只有实现该接口的事件才会被处理，相当于一个监控器
 *
 * 之后可能使用注解代替
 *
 * @author s.c.gao
 */
public interface Event extends Serializable {
}
