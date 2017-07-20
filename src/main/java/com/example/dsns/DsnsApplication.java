package com.example.dsns;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class DsnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsnsApplication.class, args);
	}
}
