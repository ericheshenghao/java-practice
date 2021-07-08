package com.spi;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.spi
 * @Description:
 * @date : 2021/7/8 21:27
 */
public class UnicomMessageSender implements MessageSender {
    @Override
    public void send() {
        System.out.println("我是联通，我给你发短信");
    }
}
