package com.jared.records;
import org.junit.jupiter.api.Test;
import com.jared.records.model.Record;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {

    @Test
    public void areRecordsWithSameValuesEqual(){
        Record recordOne = new Record("Langson", "Jared", "male", "blue", "10/14/1988");
        Record recordTwo = new Record("Langson", "Jared", "male", "blue", "10/14/1988");
        assertEquals(recordOne, recordTwo);
    }

    @Test
    public void isRecordEqualToItself(){
        Record recordOne = new Record("Langson", "Jared", "male", "blue", "10/14/1988");
        assertEquals(recordOne, recordOne);
    }
}
