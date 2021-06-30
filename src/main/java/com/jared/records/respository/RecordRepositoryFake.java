package com.jared.records.respository;

import com.jared.records.model.Record;
import com.jared.records.service.RecordService;

import java.util.ArrayList;

//simulates a DB
public class RecordRepositoryFake {
    private ArrayList <Record> genderSorted;
    private ArrayList <Record> birthDateSorted;
    private ArrayList <Record> lastNameSorted;

    //takes an AL of records and then creates the three different sorting criteria.
    public RecordRepositoryFake(ArrayList<Record> records) {
        genderSorted = RecordService.sortByGenderThenLastNameAscending(records);
        birthDateSorted = RecordService.sortByBirthDateAscending(records);
        lastNameSorted = RecordService.sortByLastNameDescending(records);
    }

    
}
