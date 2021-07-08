package com.spi;

import java.util.ServiceLoader;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.spi
 * @Description:
 * @date : 2021/7/8 21:28
 */
public class TestMain {

    public static void main(String[] args) {
        ServiceLoader<MessageSender> serviceLoader = ServiceLoader.load(MessageSender.class);
        for (MessageSender messageSender : serviceLoader) {
            messageSender.send();
        }

    }

}
