package myspring.user.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.UserService;
import myspring.user.vo.PersonVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class UserClient {
	@Autowired
	ApplicationContext context;
	@Autowired
	UserService service;
	
	@Autowired
	SqlSession session;
	
	@Test @Ignore
	public void insertSEQ() {
		int cnt = session.update("userNS.insertPerson", new PersonVO("9407231634744", "둘리", "경기", "1234"));
		System.out.println(cnt);
	}
	
	@Test @Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("dooly", "연아3", "여3", "경기3"));
		System.out.println(service.getUser("dooly"));
	}

	@Test
	public void deleteUserTest() {
		service.deleteUser("dooly");

		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
	

	@Test
	@Ignore
	public void insertUserTest() {
		service.insertUser(new UserVO("polar", "연아", "여", "경기"));

		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}

	@Test
	//@Ignore
	public void getUserTest() {
		UserVO user = session.selectOne("userNS.selectUserById","dooly");
		System.out.println(user);
//		UserVO user = service.getUser("dooly");
//		System.out.println("User 정보 : " + user);
//		assertEquals("둘리", user.getName());
	}

	@Test
	@Ignore
	public void dataSourceTest() {
		DataSource ds = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
