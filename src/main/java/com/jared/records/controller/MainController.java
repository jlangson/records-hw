package com.jared.records.controller;

import com.jared.records.RecordsApplication;
import com.jared.records.model.Record;
import com.jared.records.respository.RecordRepositoryFake;
import com.jared.records.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class MainController {

    RecordRepositoryFake repository = new RecordRepositoryFake(RecordsApplication.initialData);

    //TODO remove this in production
    @GetMapping(value = "/")
    public ArrayList<Record> sanityCheckRepositoryInitialized(){
        return repository.getBirthDateSorted();
    }

    @PostMapping(value = "/records")
    public ResponseEntity<Void> createRecord(@RequestBody String string, BindingResult bindingResult){ //do I need BindingResult?
        //is changed on good data
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Record record
        try{
            Record record = RecordService.rowToRecord(string);
        } catch (Exception e){
            //if it fails bad response sent back by default values
        }

        if(record.isValid()){
            response = new ResponseEntity<>(HttpStatus.CREATED);
            //remember to save it
            //also include the created record in the response
            System.out.println(record);
        } else{
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

//        try{
//            Record record = RecordService.rowToRecord(string);
//            response = new ResponseEntity<>(HttpStatus.CREATED);
//            System.out.println(record);
//        } catch (Exception e){
//            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        return response;
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
