package com.jared.records;



import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;


public class MainControllerTests {

    //two tests per GET endpoint: response code and headers
    //payload tests not implemented since GET requests return entire database
    //POST needs two response code tests since it can return success or fail
    @BeforeAll
    public static void setup() throws IOException {
        String[] args = new String[]{""};
        RecordsApplication.main(args);

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
//    @Test
//    public void testGetRecordsByGender_Payload() throws IOException {
//        HttpUriRequest request = new HttpGet("http://localhost:8080/records/gender");
//
//        HttpResponse response = HttpClientBuilder.create().build().execute(request);
//        response.getEntity().getContent();
//        System.out.println();
//
//        assertEquals(0,1); //force it to fail since not finished
//
//    }

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
//    @Test
//    public void testGetRecordsByBirthDate_Payload(){
//
//        assertEquals(0,1); //force it to fail since not finished
//    }

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
//    @Test
//    public void testGetRecordsByLastName_Payload(){
//        assertEquals(0,1); //force it to fail since not finished
//
//    }

    @Test
    public void testCreateRecordSuccess_ResponseCode() throws IOException {
        //setup
        HttpClient httpClient = HttpClients.createDefault();
        String string = "Imaginary | Person | male | green | 12/25/2020";
        StringEntity entity = new StringEntity(string,
                ContentType.create("text/plain", "UTF-8"));
        HttpPost httppost= new HttpPost("http://localhost:8080/records");
        httppost.setEntity(entity);

        //now I need to send it.
        HttpResponse response = httpClient.execute(httppost);

        assertEquals(HttpStatus.SC_CREATED, response.getStatusLine().getStatusCode());
    }
    @Test
    public void testCreateRecordFailure_ResponseCode() throws IOException {

        HttpClient httpClient = HttpClients.createDefault();
        String string = "sdalkjdoiawjdoqwjdioaj";
        StringEntity entity = new StringEntity(string,
                ContentType.create("text/plain", "UTF-8"));
        HttpPost httppost= new HttpPost("http://localhost:8080/records");
        httppost.setEntity(entity);

        //now I need to send it.
        HttpResponse response = httpClient.execute(httppost);

        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());

    }
    @Test
    public void testCreateRecord_Header() throws IOException {
        //setup
        String jsonMimeType = "application/json";
        HttpClient httpClient = HttpClients.createDefault();
        String string = "Imaginary | Person | male | green | 12/25/2020";
        StringEntity entity = new StringEntity(string,
                ContentType.create("text/plain", "UTF-8"));
        HttpPost httppost= new HttpPost("http://localhost:8080/records");
        httppost.setEntity(entity);

        //now I need to send it.
        HttpResponse response = httpClient.execute(httppost);
        
        String mimetype = ContentType.getOrDefault(response.getEntity()).getMimeType();

        assertEquals(jsonMimeType, mimetype);

    }
}
