package com.spi;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.spi
 * @Description:
 * @date : 2021/7/8 21:26
 */
public class ChinaMobileMessageSender implements MessageSender {
    @Override
    public void send() {
        System.out.println("我是移动，我给你发短信");
    }
}
