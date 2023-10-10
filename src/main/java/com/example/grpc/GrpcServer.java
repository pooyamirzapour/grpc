package com.example.grpc;

import com.test.example.Request;
import com.test.example.Response;
import com.test.example.TestServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GrpcServer extends TestServiceGrpc.TestServiceImplBase {

    @Override
    public void call(Request request, StreamObserver<Response> responseObserver) {
        responseObserver.onNext(Response.newBuilder().setOutput("Hi I am gRPC Response!!").build());
        responseObserver.onCompleted();
    }
}
