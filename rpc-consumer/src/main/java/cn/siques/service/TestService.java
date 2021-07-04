package cn.siques.service;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques.rpc.service
 * @Description:
 * @date : 2021/7/4 22:19
 */
@Component
public interface TestService {

    void sayHello(String name);
}
