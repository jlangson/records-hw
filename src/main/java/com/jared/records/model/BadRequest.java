package com.jared.records.model;

//for error handling in POST
public class BadRequest {
    private String error="Badly formatted request was sent";
    private String request;
    private String info="Send text in the correct format";
    private String correctFormat="lastname | firstname | gender | favoritecolor | dateOfBirth";
    private String note="Format can also be space or comma delimited";

    public BadRequest(String request){
        this.request=request;
    }

    @Override
    public String toString() {
        return "BadRequest{" +
                "error='" + error + '\'' +
                ", request='" + request + '\'' +
                ", info='" + info + '\'' +
                ", correctFormat='" + correctFormat + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
