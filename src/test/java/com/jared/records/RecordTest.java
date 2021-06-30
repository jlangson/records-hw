package com.jared.records;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.jared.records.model.Record;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {
    static Record recordOne;
    static Record recordTwo;
    static Record emptyRecordOne;

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
    public void testIsRecordTwoIdOneMoreThanRecordOneID(){

        assertEquals(recordTwo.getId(), recordOne.getId()+1);
    }

    @Test
    public void testEmptyRecordIdIsNegativeOne(){
        assertEquals(-1, emptyRecordOne.getId());
    }

    @Test
    public void testIsValidOnBadRecordExpectFalse(){
        assertEquals(false, emptyRecordOne.isValid());
    }

    @Test
    public void testIsValidOnGoodRecordExpectTrue(){
        assertEquals(true, recordOne.isValid());
    }
}
