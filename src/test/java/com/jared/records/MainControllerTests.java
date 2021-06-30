package com.jared.records;
import com.jared.records.controller.MainController;
import com.jared.records.model.Record;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

public class MainControllerTests {
//    public static ResponseEntity<ArrayList<Record>> genderResponse;
//    public static ResponseEntity<ArrayList<Record>> birthDateResponse;
//    public static ResponseEntity<ArrayList<Record>> lastNameResponse;
//    public static ResponseEntity<Void> goodCreateResponse;
//    public static ResponseEntity<Void> badCreateResponse;
//
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

        assertEquals(HttpStatus.SC_OK, httpResponse);

    }
    @Test
    public void testGetRecordsByGender_Headers(){

    }
    @Test
    //should return a json with the first column is gender
    public void testGetRecordsByGender_Payload(){

    }

    @Test
    public void testGetRecordsByBirthDate_ResponseCode(){

    }
    @Test
    public void testGetRecordsByBirthDate_Headers(){

    }
    @Test
    public void testGetRecordsByBirthDate_Payloiad(){

    }

    @Test
    public void testGetRecordsByLastName_ResponseCode(){

    }
    @Test
    public void testGetRecordsbyLastName_Headers(){

    }
    @Test
    public void testGetRecordsByLastName_Payload(){

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
