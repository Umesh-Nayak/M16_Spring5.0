package com.cg.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

	public static void main(String[] args) {
		ApplicationContext c=new ClassPathXmlApplicationContext("beans.xml");
		/*Airtel a=c.getBean(Airtel.class);
		a.SimType();
		a.Membership();*/
		
		Sim j=c.getBean(Sim.class);
		j.SimType();
		j.Membership();
		System.out.println("The program is executed....!");
		
	}
		

}
