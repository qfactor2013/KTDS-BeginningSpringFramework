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
	
	//빈으로 등록한 GenericSimpleXML 어쩌고를 여기에 주입함 
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
		//1. 단건 조회
		
		UserVO user =  sqlSession.selectOne("userNS.selectUserByName", "gildong");
		System.out.println("출력 : " + user);
		
		List<UserVO> listUserVo = sqlSession.selectList("userNS.selectUserAll");
		
		for(UserVO vo : listUserVo) {
			System.out.println(vo);			
		}
		
		UserVO oneUser = new UserVO("vega", "아무개", "남", "서울");
		//2. 등록
		int cnt = sqlSession.insert("userNS.insertUser", oneUser);
		System.out.println("등록된 건수 : " + cnt);
		
		
	}
}
