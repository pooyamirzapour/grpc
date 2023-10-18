package com.example.grpc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import io.grpc.ServerServiceDefinition;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(GrpcApplication.class, args);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        // Create and configure the gRPC server
        Server server = NettyServerBuilder.forAddress(new InetSocketAddress("127.0.0.1", 2000))
                .maxInboundMessageSize(10 * 1024 * 1024) // Set the maximum inbound message size to 10 MB
                .addService(ServerInterceptors.intercept(new GrpcServer()))
                .executor(executor)
                .build();

        // Start the server
        server.start();


        System.out.println(server);

        callServices(10);
        callServices(100);
        callServices(1000);
        callServices(10000);
        callServices(100000);
        callServices(1000000);
        callServices(2000000);
        callServices(4000000);
        server.awaitTermination();
    }

    private static void callServices(int x) {
        System.out.println("Rest Execution time for " + x + " records");
        ExecutionCalculator.restCall(x);
        ExecutionCalculator.callGrpc(x);
        System.out.println("-----------------");
    }

}
