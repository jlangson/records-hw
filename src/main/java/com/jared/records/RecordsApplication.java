package com.jared.records;

import com.jared.records.model.Record;
import com.jared.records.service.RecordService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@SpringBootApplication
public class RecordsApplication {
	public static ArrayList<Record> initialData; //to pass the data to the controller.

	public static void main(String[] args) throws IOException {
		initialData = RecordsConsole.readData(RecordService.paths);
		SpringApplication.run(RecordsApplication.class, args);
	}

}
