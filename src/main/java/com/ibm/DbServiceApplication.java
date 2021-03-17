package com.ibm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbServiceApplication implements CommandLineRunner{

	
	private static final Logger log = LoggerFactory.getLogger(DbServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
	}

	@Autowired
	private BookRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("Start Application...............");
		
		repository.save(new Book("GoLang"));
		repository.save(new Book("Java"));
		repository.save(new Book("Python"));
		repository.save(new Book("Scala"));
		
		
		System.out.println("findAll Demo");
		repository.findAll().forEach(x -> System.out.println(x));
		
		System.out.println("findByIdDemo");
		repository.findById(1l).ifPresent(x -> System.out.println(x));
		
		
		System.out.println("findByName Demo");
		repository.findByName("GoLang").forEach(x -> System.out.println(x));
		
		
		
	}

}
