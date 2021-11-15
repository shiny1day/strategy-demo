package com.yjxl.demo.service;

import com.yjxl.demo.strategy.AbstractHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiny
 * @email shiny@servingcloud.com
 * @date 2021/11/15 10:45
 * @Copyright Copyright (c) 2016 servingcloud Inc. All Rights Reserved.
 * @desc
 */
@Service
public class ContextHandlerService implements ApplicationContextAware {

    /**
     * name - handler的映射关系
     */
    private static final Map<String, AbstractHandler> HANDLER_MAP = new HashMap<>();

    private ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口获取springboot容器对象
     * 方便创建完成对象后进行初始化
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    /**
     * @PostConstruct 声明在创建完成对象并且注入属性后执行该方法
     */
    @PostConstruct
    public void init() {
        //获取AbstractHandler类的所有实现类
        Map<String, AbstractHandler> type = applicationContext.getBeansOfType(AbstractHandler.class);
        for (Map.Entry<String, AbstractHandler> entry : type.entrySet()) {
            //获取单个实现类
            AbstractHandler value = entry.getValue();
            if (CollectionUtils.isEmpty(value.names())) {
                continue;
            }

            //注册事件，并且循环全部注册
            for (String name : value.names()) {
                HANDLER_MAP.put(name, value);
            }
        }
    }

    /**
     * 业务处理类的路由方法
     *
     * @param name
     * @return
     */
    public String strategy(String name) {
        AbstractHandler handler = HANDLER_MAP.get(name);
        if (handler == null) {
            return "i do not know~";
        }
        return handler.strategy(name);
    }

}
