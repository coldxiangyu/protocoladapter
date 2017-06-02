package com.lxy.controller;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.lxy.webservice.impl.HelloServiceImpl;

/**
 * 此类为继承EmbeddedServletContainerCustomizer的实现方案，可以修改为自定义端口等
 * 目前只做基本的cxf实现，实现协议适配，不深入研究
 * CxfConfig是此类的现用类，均采用默认设置，若需特殊设置，启用此类
 * */
/*@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }


    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/webservices/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(),new HelloServiceImpl());
        endpoint.publish("/hello");
        return endpoint;
    }
}*/