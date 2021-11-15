package com.yjxl.demo.strategy.handler;

import com.yjxl.demo.strategy.AbstractHandler;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author shiny
 * @email shiny@servingcloud.com
 * @date 2021/11/15 13:59
 * @Copyright Copyright (c) 2016 servingcloud Inc. All Rights Reserved.
 * @desc
 */
@Component
public class HateController extends AbstractHandler {

    @Override
    public String strategy(String name) {
        return "hate...";
    }

    @Override
    public List<String> names() {
        return Arrays.asList("榴莲");
    }

}
