package com.example.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author tangmin  一、配置websocket
 * @Description: WebSocket是通过一个socket来实现双工异步通信能力的。
 *              但是直接使用WebSocket(或者SocketJS:WebSocket协议的模拟,增加当浏览器不支持WebSocket的时候的兼容性支持)
 *              协议开发程序会很烦琐，我们会使用它的子协议STOMP，它是一个更高级别的协议。
 *              STOMP是基于帧(frame)的格式来定义消息，
 *              与HTTP的request和response类似(具有类似于@RequestMapping的@MessageMapping)。
 *
 *              广播式：即服务端有消息时，会将信息发送给所有连接了当前endpoint的浏览器。
 *
 *  EnableWebSocketMessageBroker：①注解表示开启使用STOMP协议来传输基于代理(message broker)的消息，Broker就是代理的意思。
 *      这时控制器支持使用@MessageMapping ，就像使用@RequestMapping一样。
 *
 * @date 2017-09-16 22:01:05
 */
@Configuration
@EnableWebSocketMessageBroker//①
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * ② 注册STOMP协议的节点(endpoint)，并映射指定的URL。
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //③ 注册一个endpoint，并指定使用SockJS协议
        registry.addEndpoint("/endpointSang").withSockJS();
    }

    /**
     * ④ 配置消息代理(messageBroker)
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //⑤ 广播式应配置一个/topic消息代理
        registry.enableSimpleBroker("/topic");
    }

}
