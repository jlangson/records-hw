package com.jared.records.comparator;
import java.util.Comparator;
import com.jared.records.model.Record;

//sorts by gender only. female comes before male
public class GenderSorter implements Comparator<Record> {

    @Override
    public int compare(Record o1, Record o2) {
        return 0;
    }
}
