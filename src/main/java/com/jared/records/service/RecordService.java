package com.jared.records.service;
import com.jared.records.comparator.BirthDateAscendingSorter;
import com.jared.records.comparator.GenderSorter;
import com.jared.records.comparator.LastNameAscendingSorter;
import com.jared.records.comparator.LastNameDescendingSorter;
import com.jared.records.model.Record;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordService {
    public static final String paths[] = new String[]{
            "src/main/resources/data/pipes.csv",
            "src/main/resources/data/spaces.csv",
            "src/main/resources/data/commas.csv"};

    public static Record createRecordFromRowGivenDelimiter(String row, String delimiter){
        String[] fields = row.split(delimiter);
        for(int i=0; i < fields.length; i++){
            fields[i] = fields[i].trim();
        }
        String lastName = fields[0];
        String firstName = fields[1];
        String gender = fields[2];
        String favoriteColor = fields[3];
        String dateOfBirth = fields[4];


        return new Record(lastName, firstName, gender, favoriteColor, dateOfBirth);
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
            //empty constructor makes a Record with id -1 which is a way to detect bad inputs.
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
    
    //sort by gender primarily (female before male) then ascending last name.
    public static ArrayList<Record> sortByGenderThenLastNameAscending(ArrayList<Record> records){
        //to make a non-destructive sort
        ArrayList<Record> recordsCopy = new ArrayList<>(records);
        Collections.sort(recordsCopy, new GenderSorter()
                                        .thenComparing(new LastNameAscendingSorter()));
        return recordsCopy;
    }

    //sort by birth date, ascending
    public static ArrayList<Record> sortByBirthDateAscending(ArrayList<Record> records){
        //to make a non-destructive sort
        ArrayList<Record> recordsCopy = new ArrayList<>(records);
        Collections.sort(recordsCopy, new BirthDateAscendingSorter());
        return recordsCopy;
    }

    //sort by last name, descending
    public static ArrayList<Record> sortByLastNameDescending(ArrayList<Record> records){
        //to make a non-destructive sort
        ArrayList<Record> recordsCopy = new ArrayList<>(records);
        Collections.sort(recordsCopy, new LastNameDescendingSorter());
        return recordsCopy;
    }

    //output sorted by gender
    public static void printGenderThenLastNameAscendingSort(ArrayList<Record> records){
        for(int i=0; i < records.size(); i++){
            Record record = records.get(i);
            System.out.println(record.outputByGenderFirstThenLastName());
        }
    }

    //output sorted by birth date, ascending
    public static void printBirthDateAscendingSort(ArrayList<Record> records){
        for(int i=0; i < records.size(); i++){
            Record record = records.get(i);
            System.out.println(record.outputByBirthDateFirst());
        }

    }

    //output sorted by last name descending
    public static void printLastNameDescendingSort(ArrayList<Record> records){
        for(int i=0; i < records.size(); i++){
            Record record = records.get(i);
            System.out.println(record.outputByLastNameFirst());
        }
    }
}
