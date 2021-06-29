package com.jared.records;
import com.jared.records.model.Record;
import com.jared.records.service.RecordService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.ArrayList;

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
        //file contents are:
        //Doyle, Hector, female, blue, 02/08/1936
        //Peck | Germaine | female | indigo | 06/26/1990
        //Summers  Lane  female  indigo  07/14/1988

        final String[] filePaths = new String[]{
                "src/test/java/resources/data/commas.csv",
                "src/test/java/resources/data/pipes.csv",
                "src/test/java/resources/data/spaces.csv"
        };
        ArrayList<Record> records = RecordService.createAllRecordsFromFile(filePaths);
        ArrayList<Record> answers = new ArrayList<>();
        answers.add(RecordService.rowToRecord("Doyle, Hector, female, blue, 02/08/1936"));
        answers.add(RecordService.rowToRecord("Peck | Germaine | female | indigo | 06/26/1990"));
        answers.add(RecordService.rowToRecord("Summers  Lane  female  indigo  07/14/1988"));
        assertEquals(answers, records);
    }



}
