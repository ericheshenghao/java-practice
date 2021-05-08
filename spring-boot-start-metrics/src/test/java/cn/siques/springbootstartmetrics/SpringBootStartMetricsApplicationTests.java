package cn.siques.springbootstartmetrics;

import cn.siques.springbootstartmetrics.aop.MockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootApplication
class SpringBootStartMetricsApplicationTests {

    @Autowired
    MockService mockService;

	@Test
	void contextLoads() {
	    mockService.doSth();
	}

}
