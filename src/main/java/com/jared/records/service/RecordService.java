package com.jared.records.service;
import com.jared.records.model.Record;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RecordService {
    public static final String paths[] = new String[]{
            "src/main/resources/data/pipes.csv",
            "src/main/resources/data/spaces.csv",
            "src/main/resources/data/commas.csv"};

    public static Record createRecordFromRowGivenDelimiter(String row, String delimiter){
        Record record = new Record();
        String[] fields = row.split(delimiter);
        for(int i=0; i < fields.length; i++){
            fields[i] = fields[i].trim();
        }
        record.setLastName(fields[0]);
        record.setFirstName(fields[1]);
        record.setGender(fields[2]);
        record.setFavoriteColor(fields[3]);
        record.setDateOfBirth(fields[4]);
        return record;
    }

    //turn row into a Record
    //rows will not contain delimiters of other types in the fields.
    //delimiters are "," "|" " "
    public static Record rowToRecord(String row){
        Record record = new Record();

        if(row.contains(",")){
            record = createRecordFromRowGivenDelimiter(row, ",");
        } else if (row.contains("|")){
            record = createRecordFromRowGivenDelimiter(row, "\\|");
        } else if (row.contains(" ")){
            record = createRecordFromRowGivenDelimiter(row, "\\s+");
        } else { //bad row if this happens
            //TODO what happens here? Log it?

        }
        return record;
    }

    //turn all rows in a file into a Record collection
    public static ArrayList<Record> createAllRecordsFromFile(String filePath) throws IOException {
        ArrayList<Record> records = new ArrayList<>();
        Path path = Paths.get(filePath);
        String entireFile = new String(Files.readAllBytes(path));
        String[] rows = entireFile.split("\n"); //create rows on newlines
        for(int i=0; i < rows.length; i++){
            Record record = rowToRecord(rows[i]);
            records.add(record);
        }

        return records;
    }

    //merge records
    public static ArrayList<Record> mergeTwoRecordLists(ArrayList<Record> recordsOne, ArrayList<Record> recordsTwo){
        //filler so it compiles TODO write method
        ArrayList<Record> records = new ArrayList<>();
        return records;
    }

    //sort by gender
    public static ArrayList<Record> sortByGender(ArrayList<Record> records){
        //filler so it compiles TODO write method
        ArrayList<Record> sortedRecords = new ArrayList<>();
        return records;
    }

    //sort by birth date, ascending
    public static ArrayList<Record> sortByBirthDateAscending(ArrayList<Record> records){
        //filler so it compiles TODO write method
        ArrayList<Record> sortedRecords = new ArrayList<>();
        return records;
    }

    //sort by last name, descending
    public static ArrayList<Record> sortByLastNameDescending(ArrayList<Record> records){
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
