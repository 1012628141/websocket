package com.example.demo.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangmin
 * @Description: 四、web controller类
 * @date 2017-09-16 22:32:16
 */

@Controller
public class WiselyController {
    public  static int i=0;

    @MessageMapping("/welcome")  //浏览器向服务端发请求的地址，类似@RequestMapping
    @SendTo("/topic/getResponse") //当服务器端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    public WiselyResponse say() throws Exception{
        return getResponse();
    }

    @Scheduled(fixedRate = 1000)
    public WiselyResponse getResponse() throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(new Date()));
        //Thread.sleep(1000);
        return new WiselyResponse("welcome,"  +":"+dateFormat.format(new Date())+ " !");
    }

    /*@MessageMapping("/welcome")  //浏览器向服务端发请求的地址，类似@RequestMapping
    @SendTo("/topic/getResponse") //当服务器端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    public int say() throws Exception{

        return i++;
    }*/



}
