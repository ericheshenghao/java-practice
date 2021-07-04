package cn.siques.controller;

import cn.siques.service.GreetingsService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques.consumer.controller
 * @Description:
 * @date : 2021/7/4 21:32
 */
@RestController
public class DubboWeb {

    @DubboReference
    private GreetingsService greetingsService ;

    @GetMapping("/getInfo")
    public String getInfo () {
        return greetingsService.sayHi("何胜豪") ;
    }
}
