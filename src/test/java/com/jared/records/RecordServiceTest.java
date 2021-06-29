package com.jared.records;
import com.jared.records.comparator.GenderSorter;
import com.jared.records.model.Record;
import com.jared.records.service.RecordService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordServiceTest {
    //creates rows to represent data from a read file
    //files can be pipe, comma, or space separated
   public static final String[] commaRows = new String[]{
            "Doyle, Hector, female, blue, 02/08/1936",
            "English, Hamish, male, yellow, 01/11/2012",
            "Mejia, Rudyard, female, red, 01/10/1945"
   };
   public static final String[] pipeRows = new String[]{
           "Peck | Germaine | female | indigo | 06/26/1990",
           "Mills | Hoyt | female | yellow | 09/08/1919",
           "Young | Karyn | female | indigo | 11/08/1997"
   } ;
    public static final String[] spaceRows = new String[]{
            "Summers  Lane  female  indigo  07/14/1988",
            "Alston  Calista  male  violet  03/30/1985",
            "Rasmussen  William  male  indigo  12/04/1944"
    };

    //file contents are:
    //Doyle, Hector, female, blue, 02/08/1936
    //Doyle2, Hector, female, blue, 02/08/1936
    //Doyle3, Hector, female, blue, 02/08/1936

    //Peck | Germaine | female | indigo | 06/26/1990
    //Peck2 | Germaine | female | indigo | 06/26/1990

    //Summers  Lane  female  indigo  07/14/1988
    //Summers2  Lane  female  indigo  07/14/1988
    public static final String[] filePaths = new String[]{
            "src/test/java/resources/data/commas.csv",
            "src/test/java/resources/data/pipes.csv",
            "src/test/java/resources/data/spaces.csv"
    };
    public static final Record recordOne = new Record("Autumn", "Susan", "female", "green", "07/18/1988");
    public static final Record recordTwo = new Record("Summers", "Lane", "female", "indigo", "07/14/1988");
    public static final Record recordThree = new Record("Alston", "Calista", "male", "violet", "03/30/1985");
    public static final Record recordFour = new Record("Rasmussen", "William", "male", "indigo", "12/04/1944");


    //following tests are for rowToRecord
    @Test
    public void createRecordFromCommaRow(){
        Record record = RecordService.rowToRecord(commaRows[0]);
        Record answer = new Record("Doyle", "Hector", "female", "blue", "02/08/1936");
        assertEquals(answer, record);
    }

    @Test
    public void createRecordFromPipeRow(){
        Record record = RecordService.rowToRecord(pipeRows[0]);
        Record answer = new Record("Peck", "Germaine", "female", "indigo", "06/26/1990");
        assertEquals(answer, record);
    }

    @Test
    public void createRecordFromSpaceRow(){
        Record record = RecordService.rowToRecord(spaceRows[0]);
        Record answer = new Record("Summers", "Lane", "female", "indigo", "07/14/1988");
        assertEquals(answer, record);
    }

    @Test
    public void createRecordFromBadDataShouldFail(){
        Record record = RecordService.rowToRecord("aldjq93487asdjalsdq3784sjda-add091jda-d1d");
        Record answer = new Record();
        assertEquals(answer, record);
    }

    @Test
    public void readRecordsFromFile() throws IOException {
        ArrayList<Record> records = RecordService.createAllRecordsFromFile(filePaths[0]);
        ArrayList<Record> answers = new ArrayList<>();
        answers.add(RecordService.rowToRecord("Doyle, Hector, female, blue, 02/08/1936"));
        answers.add(RecordService.rowToRecord("Doyle2, Hector, female, blue, 02/08/1936"));
        answers.add(RecordService.rowToRecord("Doyle3, Hector, female, blue, 02/08/1936"));
        assertEquals(answers, records);
    }

    //only tests GenderSorter. Does not test sorting on last name also after gender.
    @Test
    public void sortRecordsByGender(){
        ArrayList<Record> answers = new ArrayList<>();
        ArrayList<Record> results = new ArrayList<>();

        answers.add(recordOne);
        answers.add(recordThree);

        results.add(recordThree);
        results.add(recordOne);
//
//        System.out.println("answers\n"+answers+"\n===\n");
//        System.out.println("unsorted\n" + results + "\n==\n");

        Collections.sort(results, new GenderSorter());
//        System.out.println("sorted\n" + results +"\n==\n");

        assertEquals(answers, results);
    }

    @Test
    public void sortRecordsByGenderThenLastNameAscending(){
        ArrayList<Record> answers = new ArrayList<>();
        ArrayList<Record> unsorted = new ArrayList<>();

        answers.add(recordOne);
        answers.add(recordTwo);
        answers.add(recordThree);
        answers.add(recordFour);

        //add records in unsorted order then call sort
        unsorted.add(recordTwo);
        unsorted.add(recordThree);
        unsorted.add(recordOne);
        unsorted.add(recordFour);

        ArrayList<Record> results = RecordService.sortByGenderThenLastNameAscending(unsorted);
//        System.out.println(answers);
//        System.out.println(results);
        assertEquals(answers, results);

    }

    @Test
    public void sortRecordsByLastNameDescending(){
        ArrayList<Record> answers = new ArrayList<>();
        ArrayList<Record> unsorted = new ArrayList<>();

        //recordsOne to recordsFour are shared between tests, so there is no inherent ordering
        answers.add(recordTwo);
        answers.add(recordFour);
        answers.add(recordOne);
        answers.add(recordThree);

        unsorted.add(recordThree);
        unsorted.add(recordTwo);
        unsorted.add(recordFour);
        unsorted.add(recordOne);

        ArrayList<Record> results = RecordService.sortByLastNameDescending(unsorted);

        assertEquals(answers, results);

    }



}
