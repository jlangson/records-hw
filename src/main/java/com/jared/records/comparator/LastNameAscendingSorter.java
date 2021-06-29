package com.jared.records.comparator;

import com.jared.records.model.Record;
import java.util.Comparator;

public class LastNameAscendingSorter implements Comparator<Record>{

    //A before Z
    @Override
    public int compare(Record o1, Record o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}