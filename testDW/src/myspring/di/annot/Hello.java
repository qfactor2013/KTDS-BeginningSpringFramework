package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello {
	@Value("${myname}")
	String name;

//	@Autowired
//	@Qualifier("stringPrinter")
	@Resource(name="${printer1}")
	Printer printer;

	
	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}
}
//@Autowired 
//public Hello(@Value("${db.username}") String name, @Qualifier("${printer}") Printer printer) {
/*
 * 	public Hello() {
	}

	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}

 */
