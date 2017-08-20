package com.qinxi1992.websocket.controller;

import com.qinxi1992.websocket.bean.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
@Slf4j
public class Index {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    /*@Resource
    private RedisTemplate<String, String> redisTemplate;*/


    @GetMapping("/")
    public String index(){
        //redisTemplate.boundSetOps("test:index").add("123");
        return "index";
    }


    @MessageMapping("/test")
    public void test(Message message, Principal principal) {
        log.info(message.toString()+principal.toString());
        simpMessagingTemplate.convertAndSendToUser(principal.getName().equals("test")?"test1":"test", "/queue/notifications",message);
    }
}
