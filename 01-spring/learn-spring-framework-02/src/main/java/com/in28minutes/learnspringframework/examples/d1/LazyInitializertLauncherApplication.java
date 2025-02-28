package com.in28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



@Component
class ClassA{
	
}
@Component
@Lazy
class ClassB{
	private ClassA classA;
	
	public ClassB(ClassA  classA) {
		System.out.println("Some Initialization");
		this.classA = classA;
		
	}
	public void doSomething() {
		
		System.out.println("Do Something");
	}
}
@Configuration
@ComponentScan
public class LazyInitializertLauncherApplication {
	
	public static void main(String[] args) {

		try (var context = 
				new AnnotationConfigApplicationContext
					(LazyInitializertLauncherApplication.class)) {
			
			context.getBean(ClassB.class).doSomething();
			
//			Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);

		}
	}
}
