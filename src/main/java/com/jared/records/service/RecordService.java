package com.jared.records.service;
import com.jared.records.model.Record;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecordService {

    //turn row into a Record
    //rows will not contain delimiters of other types in the fields.
    //delimiters are "," "|" " "
    public static Record rowToRecord(String row){
        Record record = new Record();

        if(row.contains(",")){
            String[] fields = row.split(",");
            for(int i=0; i < fields.length; i++){
                fields[i] = fields[i].trim();
            }
            record.setLastName(fields[0]);
            record.setFirstName(fields[1]);
            record.setGender(fields[2]);
            record.setFavoriteColor(fields[3]);
            record.setDateOfBirth(fields[4]);
        } else if (row.contains("|")){

        } else if (row.contains(" ")){

        } else { //bad row if this happens
            //TODO what happens here? Log it?

        }
        return record;
    }

    //turn all rows in a file into a Record collection
    public static List<Record> createAllRecordsFromFile(ArrayList<String> filePath) throws IOException {
        //filler so it compiles TODO write method
        ArrayList<Record> records = new ArrayList<>();
        return records;
    }

    //merge records
    public static List<Record> mergeTwoRecordLists(ArrayList<Record> recordsOne, ArrayList<Record> recordsTwo){
        //filler so it compiles TODO write method
        ArrayList<Record> records = new ArrayList<>();
        return records;
    }

    //sort by gender
    public static List<Record> sortByGender(ArrayList<Record> records){
        //filler so it compiles TODO write method
        ArrayList<Record> sortedRecords = new ArrayList<>();
        return records;
    }

    //sort by birth date, ascending
    public static List<Record> sortByBirthDateAscending(ArrayList<Record> records){
        //filler so it compiles TODO write method
        ArrayList<Record> sortedRecords = new ArrayList<>();
        return records;
    }

    //sort by last name, descending
    public static List<Record> sortByLastNameDescending(ArrayList<Record> records){
        //filler so it compiles TODO write method
        ArrayList<Record> sortedRecords = new ArrayList<>();
        return records;
    }

    //output sorted by gender
    public static void printGenderSort(){

    }

    //output sorted by birth date, ascending
    public static void printBirthDateAscendingSort(){

    }

    //output sorted by last name descending
    public static void printLastNameDescendingSort(){

    }
}
