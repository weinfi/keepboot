package com.leo.keepboot.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Created by Liuq on 2019-12-02.
 */
@Service
@PropertySource("classpath:cxfconfig.properties")
public class CallWebserviceImpl implements CallWebservice {
    @Value("${tc.address}")
    private String address;
    @Value("${tc.method}")
    private String method;
    @Override
    public String getdata() {
        try {
            // 接口地址
            //String address = "http://192.168.1.222:9080/spi/DbrzWebService?wsdl";

            // 代理工厂
            JaxWsDynamicClientFactory dcflient=JaxWsDynamicClientFactory.newInstance();
            Client client=dcflient.createClient(address);

            Object[] objects=client.invoke(method);
            System.out.println("*******"+objects[0].toString());
            String xml = objects[0].toString();
            return xml;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
