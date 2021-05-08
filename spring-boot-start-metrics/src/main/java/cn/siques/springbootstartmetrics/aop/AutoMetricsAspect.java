package cn.siques.springbootstartmetrics.aop;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.jmx.JmxReporter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

import static com.codahale.metrics.MetricRegistry.name;

/**
 * @author : heshenghao
 * @date : 23:52 2021/5/5
 */

@Component
@Aspect
public class AutoMetricsAspect {
   protected ConcurrentHashMap<String , Meter> meters = new ConcurrentHashMap<>();
    protected  ConcurrentHashMap<String,Meter> exceptionMeters = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, Timer> timers = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, Counter> counters = new ConcurrentHashMap<>();


  @Resource
   MetricRegistry metricRegistry;

  @Autowired
    JmxReporter jmxReporter;

    @Bean
    public MetricRegistry metricRegistry(){
        return new MetricRegistry();
    }


    @Pointcut(value = "execution(public * *(..))")
    public void publicMethods(){

;    }


    @Before("publicMethods() && @annotation(countedAnnotation) ")
    public void instrumentCounted(JoinPoint point, Counted countedAnnotation){
        String name = name(point.getTarget().getClass(), StringUtils.hasLength(countedAnnotation.name())?
                countedAnnotation.name():point.getSignature().getName(),"counter");
        // 如果该 name 还没有与一个 value 关联 则通过 metricRegistry.counter(key) 去设置一个value
        // 否则返回已经存在的value
        Counter counter = counters.computeIfAbsent(name, key -> metricRegistry.counter(key));
        counter.inc();
    }



}
