package cn.siques.service;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques.rpc.service
 * @Description:
 * @date : 2021/7/4 21:56
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public void sayHello(String name) {
        System.out.println("hi,"+name);
    }
}
