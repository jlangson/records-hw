package com.jared.records;
import com.jared.records.model.Record;
import com.jared.records.service.RecordService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RecordServiceTest {
    //creates rows to represent data from a read file
    //files can be pipe, comma, or space separated
   public static final String[] commaRows = new String[]{
            "Stacy, Jacobson, female, yellow, 05/12/21",
            "Cyrus, Cardenas, male, violet, 05/10/22",
            "Zeph, Holloway, male, violet, 03/31/22"};
   public static final String[] pipeRows = new String[]{
            "Troy | Dillard | female | red | 04/14/22",
            "Florence | Lawson | female | orange | 10/01/20",
            "Athena | Ortiz | male | yellow | 12/14/20"};
    public static final String[] spaceRows = new String[]{
            "Kimberly Zimmerman female blue 04/23/22",
            "Francis White male indigo 09/19/20",
            "Austin Simon female violet 05/30/22"};
    
    //following tests are for rowToRecord
    @Test
    public static void createRecordFromCommaRow(){
        Record record = RecordService.rowToRecord(commaRows[0]);
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
