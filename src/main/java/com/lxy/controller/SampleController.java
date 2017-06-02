package com.lxy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home(HttpServletRequest request) {
    	System.out.println("请求的协议方式："+request.getProtocol());
        return "Hello World!";
    }
    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}
