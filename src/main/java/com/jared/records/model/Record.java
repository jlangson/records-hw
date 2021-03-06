package com.jared.records.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Record {
    //first record starts at 1. this is increased as new records are made.
    private static int currentIdValue = 1;
    //default values to avoid null pointer errors in .equals()
    private int id=-1; //shows bad data was attempted to be entered.
    private String lastName="";
    private String firstName="";
    private String gender="";
    private String favoriteColor="";
    private LocalDate dateOfBirth=LocalDate.MIN;
    //date in records are given as MM/dd/yyyy. DateTimeFormatter is needed for LocalDate which defaults to YYYY-MM-DD
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public Record(String lastName, String firstName, String gender, String favoriteColor, String dateOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.favoriteColor = favoriteColor;
        this.dateOfBirth = LocalDate.parse(dateOfBirth, dateFormat);
        id = currentIdValue;
        currentIdValue++;
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
        this.dateOfBirth = LocalDate.parse(dateOfBirth, dateFormat);
    }

    //no setter. Don't want id changed.
    public int getId(){
        return id;
    }

    public String formatDateOfBirth(){
        String month = String.valueOf(dateOfBirth.getMonthValue());
        String year = String.valueOf(dateOfBirth.getYear());
        String day = String.valueOf(dateOfBirth.getDayOfMonth());
        return month + "/"  + day + "/" + year;
    }

    //assists with record validation.
    //invalid records should not be added.
    //not exhaustive
    public boolean isValid(){
        //if any of those are true, the record is invalid.
        //! reverses the truth values
        return !(id==-1 || lastName.equals("") || firstName.equals("") || favoriteColor.equals("") || gender.equals("") || dateOfBirth.equals(LocalDate.MIN));
    }


    @Override
    public String toString() {
        return "Record{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", favoriteColor='" + favoriteColor + '\'' +
                ", dateOfBirth='" + formatDateOfBirth() + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    //equality is when there is identical content. Every field but id should be identical.
    //this is for sorting. With unique ids, requiring equality on id would break sorting.
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

    //for displaying results when sorted by gender so gender appears first.
    public String outputByGenderFirstThenLastName(){
        return "Record{ " +
                "gender='" + gender + '\'' +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", favoriteColor='" + favoriteColor + '\'' +
                ", dateOfBirth='" + formatDateOfBirth() + '\'' +
                " }";
    }

    //for displaying results when sorted by birthday so birthday appears first
    public String outputByBirthDateFirst(){
        return "Record{ " +
                "dateOfBirth='" + formatDateOfBirth() + '\'' +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", favoriteColor='" + favoriteColor + '\'' +
                " }";
    }

    //for displaying by LastName first
    //used to be identical to toString(). Added in case toString was changed (which happened)
    // so there is a consistent access to getting output with lastName as the first column.
    public String outputByLastNameFirst(){
        return "Record{ " +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", favoriteColor='" + favoriteColor + '\'' +
                ", dateOfBirth='" + formatDateOfBirth() + '\'' +
                " }";
    }

}
