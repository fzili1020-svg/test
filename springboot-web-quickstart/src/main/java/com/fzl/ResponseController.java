package com.fzl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //1.响应状态码
        response.setStatus(401);
        //2.响应头
        response.setHeader("name","fzl");
        //3.响应体
        response.getWriter().write("<h1>HelloResponse</h1>");
    }
    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity.status(401).header("name","fzl").body("<h1>HelloResponse</h1>");
    }
}
