package com.jared.records;
import org.junit.jupiter.api.Test;
import com.jared.records.model.Record;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {

    public static final Record recordOne = new Record("Langson", "Jared", "male", "blue", "10/14/1988");
    public static final Record recordTwo = new Record("Langson", "Jared", "male", "blue", "10/14/1988");

    @Test
    public void areRecordsWithSameValuesEqual(){
        assertEquals(recordOne, recordTwo);
    }

    @Test
    public void isRecordEqualToItself(){
        assertEquals(recordOne, recordOne);
    }
}
