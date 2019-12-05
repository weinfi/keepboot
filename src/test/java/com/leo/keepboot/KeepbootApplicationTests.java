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
		role.setRoleName("�");
		role.setNote("����");
		roleMapper.insertRole(role); //reids�л�����key=redis_role_67��ֵΪrole����
		logger.info("add req: " + role.toString());
		System.out.println(role); //Role [id=67, roleName=�, note=����]
	}

	public static void main(String[] args) {
		// ������̬�ͻ���
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://127.0.0.1:8080/services/user?wsdl");
		// ��Ҫ����������Ҫ�����û���������
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
		Object[] objects = new Object[0];
		try {
			// invoke("������",����1,����2,����3....);
			objects = client.invoke("postInfo", "maple");
			System.out.println("��������:" + objects[0].toString());
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}
