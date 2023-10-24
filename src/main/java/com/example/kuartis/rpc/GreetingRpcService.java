package com.example.kuartis.rpc;

import org.lognet.springboot.grpc.GRpcService;
import com.example.kuartis.service.GreetingService;

import io.grpc.stub.StreamObserver;
import proto.greet.GreetRequest;
import proto.greet.GreetResponse;
import proto.greet.GreetServiceGrpc;

@GRpcService
public class GreetingRpcService extends GreetServiceGrpc.GreetServiceImplBase {
    
    private final GreetingService greetingService;
    

    public GreetingRpcService(GreetingService greetingService){
        this.greetingService= greetingService;
      
    }
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        
        GreetResponse response = this.greetingService.greet(request);
        
        responseObserver.onNext(response);// send the response
        responseObserver.onCompleted();// complete the execution
    }
}