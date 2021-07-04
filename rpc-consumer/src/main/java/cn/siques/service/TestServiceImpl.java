package cn.siques.service;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques.rpc.service
 * @Description:
 * @date : 2021/7/4 21:56
 */
@Component
public class TestServiceImpl  {

    @Autowired
    NacosServiceDiscovery discovery;

    @Autowired
    TestService testService;

    @PostConstruct
    public void dosome() throws NacosException {
        List<String> services = discovery.getServices();
        // 拿到ip，地址等，再使用 netty 进行底层的消息通信
        List<ServiceInstance> sdf = discovery.getInstances("rpc-provider");
        ServiceInstance instance = sdf.get(0);
        String host = instance.getHost();
        int port = instance.getPort();

    }



}
