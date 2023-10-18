package com.example.grpc;

import java.util.List;
import java.util.stream.Collectors;

import com.test.example.GrpcContract;
import com.test.example.Request;
import com.test.example.Response;
import com.test.example.TestServiceGrpc;
import io.grpc.stub.StreamObserver;

//@GRpcService
public class GrpcServer extends TestServiceGrpc.TestServiceImplBase {


    @Override
    public void call(Request request, StreamObserver<Response> responseObserver) {
        List<GrpcContract> grpcContracts = getGrpcContracts(request.getId());
        responseObserver.onNext(Response.newBuilder().addAllGrpcContracts(grpcContracts).build());
        responseObserver.onCompleted();
    }

    private List<GrpcContract> getGrpcContracts(long index )
    {
        MyService myService= new MyService();

        return myService.get(index).stream().map( f-> GrpcContract.newBuilder().
                setId(f.getId())
                        .setName(f.getName())
                        .setName2(f.getName())
                        .setName3(f.getName())
                        .setName4(f.getName())
                        .setName5(f.getName())
                        .setName6(f.getName())
                        .setName7(f.getName())
                        .setName8(f.getName())
                        .setName9(f.getName())
                        .setName10(f.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
