package com.leo.keepboot;

import com.leo.keepboot.dao.RoleMapper;
import com.leo.keepboot.model.Role;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KeepbootApplicationTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleMapper roleMapper;
	@Test
	void contextLoads() {
		Role role = new Role();
		role.setRoleName("李华");
		role.setNote("好人");
		roleMapper.insertRole(role); //reids中缓存了key=redis_role_67，值为role对象
		logger.info("add req: " + role.toString());
		System.out.println(role); //Role [id=67, roleName=李华, note=好人]
	}

	public static void main(String[] args) {
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://127.0.0.1:8080/services/user?wsdl");
		// 需要密码的情况需要加上用户名和密码
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
		Object[] objects = new Object[0];
		try {
			// invoke("方法名",参数1,参数2,参数3....);
			objects = client.invoke("postInfo", "maple");
			System.out.println("返回数据:" + objects[0].toString());
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}
