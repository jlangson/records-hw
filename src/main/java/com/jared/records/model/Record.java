package com.jared.records.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Record {
    private String lastName="";
    private String firstName="";
    private String gender="";
    private String favoriteColor="";
    private LocalDate dateOfBirth;
    //date in records are given as MM/dd/yyyy. DateTimeFormatter is needed for LocalDate which defaults to YYYY-MM-DD
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public Record(String lastName, String firstName, String gender, String favoriteColor, String dateOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.favoriteColor = favoriteColor;
        this.dateOfBirth = LocalDate.parse(dateOfBirth, dateFormat);
    }

    public Record() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    @Override
    public String toString() {
        return "Record{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", favoriteColor='" + favoriteColor + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    //equality is when every field is identical
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj  == null || obj.getClass() != this.getClass()){
            return false;
        }
        Record record = (Record) obj;
        return this.lastName.equals(record.getLastName()) &&
                this.firstName.equals(record.getFirstName()) &&
                this.gender.equals(record.getGender()) &&
                this.favoriteColor.equals(record.getFavoriteColor()) &&
                this.dateOfBirth.equals(record.getDateOfBirth());
    }
    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, gender, favoriteColor, dateOfBirth);
    }


}
