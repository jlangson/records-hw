package com.jared.records;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;


public class MainControllerTests {

//    //three tests per GET endpoint: response code, headers, and payload
//    //POST needs two response code tests since it can return success or fail
//
    @BeforeAll
    public static void setup() throws IOException{
        String[] args = new String[]{""};
        RecordsApplication.main(args);

    }

    @AfterAll
    public static void cleanup(){
        System.exit(0);
    }

    @Test
    public void testGetRecordsByGender_ResponseCode() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/records/gender");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

    }
    @Test
    public void testGetRecordsByGender_Headers() throws IOException{
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet("http://localhost:8080/records/gender");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();

        assertEquals(jsonMimeType, mimeType);

    }
    @Test
    //should return a json with the first column is gender
    public void testGetRecordsByGender_Payload() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/records/gender");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        response.getEntity().getContent();
        System.out.println();

        assertEquals(0,1); //force it to fail since not finished

    }

    @Test
    public void testGetRecordsByBirthDate_ResponseCode() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/records/birthdate");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

    }
    @Test
    public void testGetRecordsByBirthDate_Headers() throws IOException {
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet("http://localhost:8080/records/birthdate");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        String mimetype = ContentType.getOrDefault(response.getEntity()).getMimeType();

        assertEquals(jsonMimeType, mimetype);

    }
    @Test
    public void testGetRecordsByBirthDate_Payloiad(){

        assertEquals(0,1); //force it to fail since not finished
    }

    @Test
    public void testGetRecordsByLastName_ResponseCode() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/records/name");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

    }
    @Test
    public void testGetRecordsbyLastName_Headers() throws IOException {
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet("http://localhost:8080/records/name");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();

        assertEquals(jsonMimeType, mimeType);

    }
    @Test
    public void testGetRecordsByLastName_Payload(){
        assertEquals(0,1); //force it to fail since not finished

    }

    @Test
    public void testCreateRecordSuccess_ResponseCode(){

    }
    @Test
    public void testCreateRecordFailure_ResponseCode(){

    }
    @Test
    public void testCreateRecord_Header(){

    }



}
