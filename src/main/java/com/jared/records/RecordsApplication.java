package com.jared.records;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class RecordsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RecordsApplication.class, args);

		String pipes = new String(Files.readAllBytes(Paths.get("src/main/resources/data/pipes.csv")));
		System.out.println(pipes);
	}

}
