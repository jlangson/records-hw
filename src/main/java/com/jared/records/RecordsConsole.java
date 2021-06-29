package com.jared.records;
import com.jared.records.model.Record;
import com.jared.records.service.RecordService;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

//for running part one of the assignment
public class RecordsConsole {

    public static void main(String[] args) throws IOException {
        //to store the inputs from every file before they are merged
        ArrayList<ArrayList<Record>> recordOfRecords = new ArrayList<>();
        ArrayList<Record> mainList = new ArrayList<>(); //where merged records are stored

        for(int i=0; i < RecordService.paths.length; i++){
            ArrayList<Record> records = RecordService.createAllRecordsFromFile(RecordService.paths[i]);
            recordOfRecords.add(records);
        }

        for(int i=0; i < recordOfRecords.size(); i++){
            mainList.addAll(recordOfRecords.get(i));
        }
        System.out.println(mainList.size()); //expect 300

        //keeps three sorted ArrayLists so program doesn't need to resort when a different output is called
        ArrayList<Record> recordsSortedByGenderThenLastNameAscending = RecordService.sortByGenderThenLastNameAscending(mainList);
        ArrayList<Record> recordsSortedByBirthDateAscending = RecordService.sortByBirthDateAscending(mainList);
        ArrayList<Record> recordsSortedByLastNameDescending = RecordService.sortByLastNameDescending(mainList);

        RecordService.printGenderThenLastNameAscendingSort(recordsSortedByGenderThenLastNameAscending);
        RecordService.printBirthDateAscendingSort(recordsSortedByBirthDateAscending);
        
    }
}
