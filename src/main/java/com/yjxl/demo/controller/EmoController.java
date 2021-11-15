package com.yjxl.demo.controller;

import com.yjxl.demo.service.ContextHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiny
 * @email shiny@servingcloud.com
 * @date 2021/11/15 10:40
 * @Copyright Copyright (c) 2016 servingcloud Inc. All Rights Reserved.
 * @desc
 */
@RestController
public class EmoController {

    @Autowired
    private ContextHandlerService handlerService;

    @GetMapping("/emo")
    public String getEmoByName(String name) {
        return handlerService.strategy(name);
    }

}
