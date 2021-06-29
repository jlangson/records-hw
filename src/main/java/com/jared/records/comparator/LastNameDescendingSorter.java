package com.jared.records.comparator;

import com.jared.records.model.Record;

import java.util.Comparator;

public class LastNameDescendingSorter implements Comparator<Record>{

    //Z before A
    @Override
    public int compare(Record o1, Record o2) {
        // multiply by -1 reverses sort order. Default sort order is ascending
        return -1 * o1.getLastName().compareTo(o2.getLastName());
    }
}