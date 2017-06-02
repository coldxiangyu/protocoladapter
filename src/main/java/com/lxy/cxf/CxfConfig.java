package com.lxy.cxf;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.lxy.webservice.HelloService;
import com.lxy.webservice.impl.HelloServiceImpl;

@SpringBootApplication
public class CxfConfig {
	
	public static void main(String[] args) {
        SpringApplication.run(CxfConfig.class, args);
    }
	
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/webservices/*");
    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    @Bean
    public HelloService helloService() {
        return new HelloServiceImpl();
    }
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), helloService());
        endpoint.publish("/hello");
        return endpoint;
    }
    
}