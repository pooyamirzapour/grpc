package com.example.grpc;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GlobalExceptionHandler {

    @GrpcExceptionHandler
    public StatusException handleInvalidArgument(Exception e) {
        Status status = Status.NOT_FOUND.withDescription("Your description").withCause(e);
        Metadata metadata = new Metadata();
        return status.asException(metadata);
    }

}
