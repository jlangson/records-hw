package com.jared.records;
import com.jared.records.model.Record;
import com.jared.records.service.RecordService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

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

    }

    @Test
    public void createRecordFromSpaceRow(){

    }

    @Test
    public void createRecordFromBadDataShouldFail(){

    }



}
