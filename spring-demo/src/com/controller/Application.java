package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.to.Hello;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Hello h1 = (Hello)context.getBean("h1");
		System.out.println(h1.getMessage());
		Hello h2 = (Hello)context.getBean("h2");
		System.out.println(h2.getMessage());
	}
}
