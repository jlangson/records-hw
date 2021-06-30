package com.jared.records;
import com.jared.records.model.Record;
import com.jared.records.service.RecordService;

import java.io.IOException;
import java.util.ArrayList;

//for running part one of the assignment
public class RecordsConsole {

    public static ArrayList<Record> readData(String[] filePaths) throws IOException {
        //to store the inputs from every file before they are merged
        ArrayList<ArrayList<Record>> recordOfRecords = new ArrayList<>();
        ArrayList<Record> initialList = new ArrayList<>(); //where merged records are stored

        for(int i=0; i < filePaths.length; i++){
            ArrayList<Record> records = RecordService.createAllRecordsFromFile(filePaths[i]);
            recordOfRecords.add(records);
        }

        for(int i=0; i < recordOfRecords.size(); i++){
            initialList.addAll(recordOfRecords.get(i));
        }
        System.out.println(initialList.size()); //expect 300

        return initialList;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Record> initialList = readData(RecordService.paths);


        //keeps three sorted ArrayLists so program doesn't need to resort when a different output is called
        ArrayList<Record> recordsSortedByGenderThenLastNameAscending = RecordService.sortByGenderThenLastNameAscending(initialList);
        ArrayList<Record> recordsSortedByBirthDateAscending = RecordService.sortByBirthDateAscending(initialList);
        ArrayList<Record> recordsSortedByLastNameDescending = RecordService.sortByLastNameDescending(initialList);

        //ouputs
        System.out.println("Records sorted by gender then lastname in ascending order\n==========");
        RecordService.printGenderThenLastNameAscendingSort(recordsSortedByGenderThenLastNameAscending);
        System.out.println("Records sorted by dateOfBirth in ascending order\n=============");
        RecordService.printBirthDateAscendingSort(recordsSortedByBirthDateAscending);
        System.out.println("Records sortd by lastname in descending order\n============");
        RecordService.printLastNameDescendingSort(recordsSortedByLastNameDescending);
    }
}
