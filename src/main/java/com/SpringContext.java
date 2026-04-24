package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.module.Address;
import com.module.User;

public class SpringContext {

	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
		User user1 = container.getBean("user", User.class);
		System.out.println(user1);
		Address address = container.getBean("address", Address.class);
		((AbstractApplicationContext) container).close();
	}

}
