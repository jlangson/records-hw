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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCorrectFormat() {
        return correctFormat;
    }

    public void setCorrectFormat(String correctFormat) {
        this.correctFormat = correctFormat;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
