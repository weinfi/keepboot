package com.leo.keepboot.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Description:
 * Created by Liuq on 2019-12-02.
 */
//sei= http://127.0.0.1:8080/services/user?wsdl
@WebService(targetNamespace="http://webservice.keepboot.leo.com/",endpointInterface = "com.leo.keepboot.webservice.HelloCxf")
public interface HelloCxf {
    @WebMethod
    String postInfo(@WebParam(name = "a")String a);
}
