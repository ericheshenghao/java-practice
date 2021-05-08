package cn.siques.springbootstartmetrics.aop;

import com.codahale.metrics.annotation.Counted;
import org.springframework.stereotype.Component;

/**
 * @author : heshenghao
 * @date : 23:31 2021/5/5
 */
@Component
public class MockService  {


    @Counted
    public void doSth(){

            System.out.println("just do sth");

    }


}
