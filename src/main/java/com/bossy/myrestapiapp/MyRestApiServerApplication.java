package com.bossy.myrestapiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.bossy.myrestapiapp"})
public class MyRestApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestApiServerApplication.class, args);
	}

}
