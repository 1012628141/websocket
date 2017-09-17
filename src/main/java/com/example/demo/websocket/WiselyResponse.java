package com.example.demo.websocket;

/**
 * @author tangmin
 * @Description: 三、服务器端向浏览器发送此类消息
 * @date 2017-09-16 22:29:38
 */
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
