package cn.siques.springbootstartweb;

import cn.siques.springbootstartmetrics.aop.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootStartWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartWebApplication.class, args);
	}

	@Autowired
    MockService mockService;

	@GetMapping("/dosth")
	public void doSth(){
	    mockService.doSth();
    }

}
