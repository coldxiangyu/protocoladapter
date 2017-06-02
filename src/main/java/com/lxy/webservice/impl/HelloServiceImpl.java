package com.lxy.webservice.impl;

import javax.jws.WebService;

import com.lxy.webservice.HelloService;

@WebService(targetNamespace="http://webservice.lxy.com/",endpointInterface = "com.lxy.webservice.HelloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public String getName(String param) {
		return "hello "+param;
	}

}
