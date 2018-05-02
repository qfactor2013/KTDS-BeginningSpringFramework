package myspring.user.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class DBTest {
	
	//������ ����� GenericSimpleXML ��¼���� ���⿡ ������ 
	@Autowired
	@Qualifier("dataSource")
	DataSource datasource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void student() {
		// TODO Auto-generated method stub
		List<StudentVO> listStudentVO = sqlSession.selectList("studentNS.selectStudentDeptById");
		for(StudentVO vo : listStudentVO) {
			System.out.println(vo);
		}
	}
	
	
	@Test
	public void connection() {
//		
//		System.out.println(sqlSessionFactory.getClass().getName());
		try {
			System.out.println(datasource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void sql() {
		// TODO Auto-generated method stub
		//1. �ܰ� ��ȸ
		
		UserVO user =  sqlSession.selectOne("userNS.selectUserByName", "gildong");
		System.out.println("��� : " + user);
		
		List<UserVO> listUserVo = sqlSession.selectList("userNS.selectUserAll");
		
		for(UserVO vo : listUserVo) {
			System.out.println(vo);			
		}
		
		UserVO oneUser = new UserVO("vega", "�ƹ���", "��", "����");
		//2. ���
		int cnt = sqlSession.insert("userNS.insertUser", oneUser);
		System.out.println("��ϵ� �Ǽ� : " + cnt);
		
		
	}
}