package com.ujeat.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 页面调度
 */
@Controller
public class DispatcherController {
    @GetMapping("/{page}")
    public String dispatcher(@PathVariable("page") String page){
        return page;
    }
}
