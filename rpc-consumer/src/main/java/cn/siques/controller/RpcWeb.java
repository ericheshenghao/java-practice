package cn.siques.controller;

import cn.siques.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RpcWeb {

//    @RpcReference
//    private GreetingsService greetingsService;

    @Autowired
    RpcClient rpcClient;

    @GetMapping("/getInfo")
    public Object getInfo () {
        GreetingsService greetingsService = rpcClient.doMethod(GreetingsService.class);
        return  greetingsService.sayHi("何胜豪");
    }
}
