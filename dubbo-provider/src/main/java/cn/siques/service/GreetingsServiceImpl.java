package cn.siques.service;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author: 何胜豪
 * @Title: 声明服务
 * @Package: cn.siques.service
 * @Description:
 * @date : 2021/7/4 21:02
 */
@DubboService
public class GreetingsServiceImpl implements GreetingsService {
    @Override
    public String sayHi(String name) {
        return "hi, " + name;
    }
}
