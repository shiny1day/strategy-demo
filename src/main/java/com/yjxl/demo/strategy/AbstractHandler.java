package com.yjxl.demo.strategy;

import java.util.List;

/**
 * @author shiny
 * @email shiny@servingcloud.com
 * @date 2021/11/15 10:40
 * @Copyright Copyright (c) 2016 servingcloud Inc. All Rights Reserved.
 * @desc
 */
public abstract class AbstractHandler {

    /**
     * 业务处理实现抽象方法
     *
     * @param name
     * @return
     */
    public abstract String strategy(String name);


    /**
     * 返回业务类型,可以配置多个事件也可以是单个事件
     *
     * @return
     */
    public abstract List<String> names();

}
