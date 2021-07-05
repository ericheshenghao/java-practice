package cn.siques.controller;

import cn.siques.service.GreetingsService;
import org.springframework.stereotype.Component;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques.controller
 * @Description:
 * @date : 2021/7/5 16:18
 */
@Component
public class GreetingsServiceImpl implements GreetingsService {
    @Override
    public String sayHi(String name) {
        return "hi,"+name;
    }
}
