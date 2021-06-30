package com.jared.records.controller;

import com.jared.records.model.Record;
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

    @PostMapping(value = "/records")
    public ResponseEntity<Void> createRecord(@RequestBody Record record, BindingResult bindingResult){ //do I need BindingResult?
        //Filler so it compiles. TODO write this
        ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        return response;
    }

    @GetMapping(value = "/records/gender")
    public ResponseEntity<ArrayList<Record>> getRecordsByGender(){
        //Filler so it compiles. TODO write this
        ResponseEntity<ArrayList<Record>> response = new ResponseEntity<ArrayList<Record>>(HttpStatus.BAD_REQUEST);
        return response;

    }

    @GetMapping(value = "/records/birthdate")
    public ResponseEntity<ArrayList<Record>> getRecordsByBirthdate(){
        //Filler so it compiles. TODO write this
        ResponseEntity<ArrayList<Record>> response = new ResponseEntity<ArrayList<Record>>(HttpStatus.BAD_REQUEST);
        return response;
    }

    @GetMapping(value = "/records/name")
    public ResponseEntity<ArrayList<Record>> getRecordsByLastName(){
        //Filler so it compiles. TODO write this
        ResponseEntity<ArrayList<Record>> response = new ResponseEntity<ArrayList<Record>>(HttpStatus.BAD_REQUEST);
        return response;
    }


}
