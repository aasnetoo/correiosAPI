package com.edt.correiosAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CorreiosApiApplication {

	private static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {
		ctx = SpringApplication.run(CorreiosApiApplication.class, args);
	}
	public static void close(int code){
		SpringApplication.exit(ctx, () -> code);
	}

}
