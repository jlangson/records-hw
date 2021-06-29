package com.jared.records.comparator;

import com.jared.records.model.Record;

import java.util.Comparator;

public class BirthDateAscendingSorter implements Comparator<Record> {
    @Override
    public int compare(Record o1, Record o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
