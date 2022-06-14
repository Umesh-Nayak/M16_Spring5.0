package com.tns.springaw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Body {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		Human human=ac.getBean("human",Human.class);
		human.display();
		
	}

}
