package myspring.di.xml.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import junit.framework.Assert;
import myspring.di.xml.Hello;

public class HelloBeanTest {

	@Test
	public void hellobean() {
		
		//1. Spring 컨테이너 객체를 생성
		BeanFactory factory = new GenericXmlApplicationContext("/config/beans.xml");
		
		//2 bean 객체를 요청
		Hello hello1 = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		System.out.println(hello1 == hello2);
		
		//3. assertSame() 메서드를 호출해서 주소
		Assert.assertSame(hello1, hello2);
		
		
	}
}
