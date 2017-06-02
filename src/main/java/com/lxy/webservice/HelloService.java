package com.lxy.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {
	@WebMethod
    String getName(String param);
}
