package com.jared.records.model;

//for use in handling Bad Post Requests
public class RecordWithError extends Record {
    private String error = "A bad response was sent";
    private String request;

    public RecordWithError(String request){
        this.request = request;
    }

}
