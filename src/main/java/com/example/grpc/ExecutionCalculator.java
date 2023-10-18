package com.example.grpc;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.util.List;

import ch.qos.logback.classic.Level;
import com.test.example.Request;
import com.test.example.Response;
import com.test.example.TestServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ExecutionCalculator {


    public static void restCall(long index) {
        String apiUrl = "http://localhost:8999/contracts/" + index;

        long startTime = System.currentTimeMillis();


        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.ALL));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                requestEntity,
                TestResponse.class
        );

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;


        System.out.println("Rest Execution time: " + executionTime + " milliseconds");
    }

    public static void callGrpc(long index) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("127.0.0.1", 2000)
                .usePlaintext()
                .build();


        TestServiceGrpc.TestServiceBlockingStub stub = TestServiceGrpc.newBlockingStub(channel).
                withMaxInboundMessageSize(265886334);

        Request request = Request.newBuilder().setId(index).build();


        long startTime = System.currentTimeMillis();

         stub.call(request);

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        System.out.println("gRPC Execution time: " + executionTime + " milliseconds");

        //channel.shutdown();
    }
}
