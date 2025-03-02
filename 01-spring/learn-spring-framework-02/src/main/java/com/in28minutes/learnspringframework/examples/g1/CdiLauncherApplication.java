package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;



//@Component
@Named
class BussinessServices{
	private DataService dataService;


	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		
		this.dataService = dataService;
	}
	
	public DataService getDataService() {
		System.out.println("Working on CDI");
		return dataService;
	}

	
}

//@Component
@Named
class DataService{
	
}




@Configuration
@ComponentScan
public class CdiLauncherApplication {
	
	public static void main(String[] args) {

		try (var context = 
				new AnnotationConfigApplicationContext
					(CdiLauncherApplication.class)) {
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			
			System.out.println(context.getBean(BussinessServices.class).getDataService());

		}
	}
}
