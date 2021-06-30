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

    //keeps arraylists synchronized
    //sorting is done on write based on assumption that reads are more common than writes
    public void add(Record record){
        genderSorted.add(record);
        birthDateSorted.add(record);
        lastNameSorted.add(record);
        genderSorted = RecordService.sortByGenderThenLastNameAscending(genderSorted);
        birthDateSorted = RecordService.sortByBirthDateAscending(birthDateSorted);
        lastNameSorted = RecordService.sortByLastNameDescending(lastNameSorted);
    }

    public ArrayList<Record> getGenderSorted(){
        return genderSorted;
    }

    public ArrayList<Record> getBirthDateSorted() {
        return birthDateSorted;
    }

    public  ArrayList<Record> getLastNameSorted(){
        return lastNameSorted;
    }
}
