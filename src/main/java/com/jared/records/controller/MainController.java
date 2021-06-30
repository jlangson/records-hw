package com.jared.records.controller;

import com.jared.records.RecordsApplication;
import com.jared.records.model.BadRequest;
import com.jared.records.model.Record;
import com.jared.records.respository.RecordRepositoryFake;
import com.jared.records.service.RecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class MainController {

    RecordRepositoryFake repository = new RecordRepositoryFake(RecordsApplication.initialData);


    @PostMapping(value = "/records")
    public ResponseEntity<?> createRecord(@RequestBody String request){ //do I need BindingResult?
        //is changed on good data
        BadRequest badRequest = new BadRequest(request); //only sent if making a good record fails
        ResponseEntity<BadRequest> badResponse = new ResponseEntity<BadRequest>(badRequest, HttpStatus.BAD_REQUEST);

        try{
           Record record = RecordService.rowToRecord(request);
            if(record.isValid()) {
               ResponseEntity<Record> goodResponse = new ResponseEntity<Record>(record,HttpStatus.CREATED);

                //TODO also include the created record in the response
                repository.add(record);
                System.out.println("Record was added as " + record);
                return goodResponse;
            }
        } catch (Exception e){
            //badResponse is made by default so there's nothing to do here
            System.out.println("The bad request is " + badRequest);
        }

        return badResponse;
    }

    @GetMapping(value = "/records/gender")
    public ResponseEntity<ArrayList<Record>> getRecordsByGender(){
        //Filler so it compiles. TODO write this
        ArrayList<Record> records = repository.getGenderSorted();
        ResponseEntity<ArrayList<Record>> response = new ResponseEntity<ArrayList<Record>>(records, HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "/records/birthdate")
    public ResponseEntity<ArrayList<Record>> getRecordsByBirthdate(){
        ArrayList<Record> records = repository.getBirthDateSorted();
        ResponseEntity<ArrayList<Record>> response = new ResponseEntity<ArrayList<Record>>(records, HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "/records/name")
    public ResponseEntity<ArrayList<Record>> getRecordsByLastName(){
        ArrayList<Record> records = repository.getLastNameSorted();
        ResponseEntity<ArrayList<Record>> response = new ResponseEntity<ArrayList<Record>>(records, HttpStatus.OK);
        return response;
    }


}
