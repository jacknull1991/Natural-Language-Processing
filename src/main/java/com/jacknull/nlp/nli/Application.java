package com.jacknull.nlp.nli;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Beans provided by spring boot:");
			
			String[] beans = ctx.getBeanDefinitionNames();
			Arrays.sort(beans);
			for (String b : beans) {
				System.out.println(b);
			}
		};
	}*/

}
