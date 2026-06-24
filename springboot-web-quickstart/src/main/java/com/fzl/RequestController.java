package com.fzl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        //1.获取请求方式
        System.out.println(request.getMethod());
        //2.获取url
        System.out.println(request.getRequestURL().toString()); //   http://localhost:8080/request
        System.out.println(request.getRequestURI()); //   request
        //3.获取请求协议
        System.out.println(request.getProtocol());
        //4.获取请求参数
        System.out.println(request.getParameter("name"));
        //5.获取请求头
        System.out.println(request.getHeader("Accept"));
        return "ok";
    }
}
