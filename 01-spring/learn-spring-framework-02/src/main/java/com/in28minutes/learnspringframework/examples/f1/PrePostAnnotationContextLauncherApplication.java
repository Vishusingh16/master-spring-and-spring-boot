package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass{
	private SomeDependency someDependency;
public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready");
	}
@PostConstruct
public void initialize() {
	someDependency.getReady();
	
}
	
@PreDestroy
public void CleanUp() {
	System.out.println("Cleaned Up");
}
}

@Component
class SomeDependency{

	public void getReady() {
		 
		System.out.println("methods are getting ready");
	}
	
	
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {
	
	public static void main(String[] args) {

		try (var context = 
				new AnnotationConfigApplicationContext
					(PrePostAnnotationContextLauncherApplication.class)) {
			
		
				Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
 
		}
	}
}
