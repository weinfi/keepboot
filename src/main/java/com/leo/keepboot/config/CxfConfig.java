package com.leo.keepboot.config;

/**
 * Description:
 * Created by Liuq on 2019-12-02.
 */
import javax.xml.ws.Endpoint;

import com.leo.keepboot.webservice.HelloCxf;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:CxfConfig
 * @Description:cxf����webservice����
 * @author Jerry
 * @date:2018��4��10������4:12:24
 */
@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;

    @Autowired
    HelloCxf helloCxf;

    /**
     * �˷��������Ǹı���Ŀ�з�������ǰ׺�����˴�127.0.0.1����localhost���ܷ���ʱ����ʹ��ipconfig�鿴����ip������
     * �˷�����ע�ͺ�:wsdl���ʵ�ַΪhttp://127.0.0.1:8080/services/user?wsdl
     * ȥ��ע�ͺ�wsdl���ʵ�ַΪ��http://127.0.0.1:8080/soap/user?wsdl
     * @return
     */
/*    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }*/

    /** JAX-WS
     * վ�����
     * **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, helloCxf);
        endpoint.publish("/user");
        return endpoint;
    }

}
