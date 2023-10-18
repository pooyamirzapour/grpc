//package com.example.grpc;
//
//import com.test.example.Request;
//import com.test.example.Response;
//import com.test.example.TestServiceGrpc;
//import domain.RequestDTO;
//import domain.ResponseDTO;
//import io.grpc.ManagedChannel;
//import io.grpc.netty.NettyChannelBuilder;
//import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class ChannelManager {
//
//    public static void call() {
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
//
//        ManagedChannel channel = NettyChannelBuilder.forAddress("127.0.0.1", 2000).
//                usePlaintext().disableRetry().executor(executor).keepAliveTime(1000, TimeUnit.SECONDS)
//                .keepAliveWithoutCalls(true).build();
//
//        TestServiceGrpc.TestServiceBlockingStub testStub = TestServiceGrpc.newBlockingStub(channel)
//                .withDeadlineAfter(10, TimeUnit.SECONDS);
//
//
//        TestServiceGrpc.TestServiceBlockingStub stub = testStub;
//        Request request = Request.newBuilder().setInput(requestDTO.getInput()).setId(requestDTO.getId()).build();
//        Response response = stub.call(request);
//
//
//
//
//    }
//
//}