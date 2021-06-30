package com.jared.records;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.jared.records.model.Record;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {
    static Record recordOne;
    static Record recordTwo;
    static Record emptyRecordOne; //for testing id

    @BeforeAll
    static void setup(){
        recordOne = new Record("Langson", "Jared", "male", "blue", "10/14/1988");
        recordTwo = new Record("Langson", "Jared", "male", "blue", "10/14/1988");
        emptyRecordOne = new Record();
    }

    @Test
    public void testAreRecordsWithSameValuesEqual(){
        assertEquals(recordOne, recordTwo);
    }

    @Test
    public void testIsRecordEqualToItself(){
        assertEquals(recordOne, recordOne);
    }

    //makes sure record  ids are incremented
    @Test
    public void testIsFirstRecordIdOne(){
        assertEquals(1, recordOne.getId());
    }

    @Test
    public void testIsSecondRecordIdTwo(){
        assertEquals(2, recordTwo.getId());
    }

    @Test
    public void testEmptyRecordIdIsNegativeOne(){
        assertEquals(-1, emptyRecordOne.getId());
    }
}
