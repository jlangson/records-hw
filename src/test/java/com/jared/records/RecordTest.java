package com.jared.records;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.jared.records.model.Record;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {
    static Record recordOne;
    static Record recordTwo;

    @BeforeAll
    static void setup(){
        recordOne = new Record("Langson", "Jared", "male", "blue", "10/14/1988");
        recordTwo = new Record("Langson", "Jared", "male", "blue", "10/14/1988");
    }
    
    @Test
    public void areRecordsWithSameValuesEqual(){
        assertEquals(recordOne, recordTwo);
    }

    @Test
    public void isRecordEqualToItself(){
        assertEquals(recordOne, recordOne);
    }
}
