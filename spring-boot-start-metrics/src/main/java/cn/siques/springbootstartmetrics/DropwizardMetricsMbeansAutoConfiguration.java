package cn.siques.springbootstartmetrics;


import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jmx.JmxReporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;


/**
 * @author : heshenghao
 * @date : 23:39 2021/5/5
 */
@Configuration
@ComponentScan({"cn.siques.springbootstartmetrics.aop"})
@AutoConfigureAfter(AopAutoConfiguration.class)
public class DropwizardMetricsMbeansAutoConfiguration {

    @Value("${metrics.mbeans.domain.name:cn.siques.metrics}")
    String metricsMbeansDomainName;

    @Autowired
    MBeanServer mbeanServer;

    @Autowired
    MetricRegistry metricRegistry;



    @Bean
    public MBeanServer mbeanServer() {
        // bean容器
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        return server;
    }



    @Bean
    public JmxReporter jmxReporter(){
        JmxReporter reporter = JmxReporter.forRegistry(metricRegistry)
                .inDomain(metricsMbeansDomainName)
                .registerWith(mbeanServer)
                .build();
        reporter.start();
        return  reporter;
    }


}
