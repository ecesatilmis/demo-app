package com.example.kuartis.service;

import org.springframework.stereotype.Service;

import com.example.kuartis.model.GreetingEntity;
import com.example.kuartis.repository.GreetingRepository;

import javax.transaction.Transactional;
import proto.greet.GreetRequest;
import proto.greet.GreetResponse;
import proto.greet.Greeting;

@Service
@Transactional
public class GreetingService {

    private GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
      this.greetingRepository = greetingRepository;
    }
    
    public GreetResponse greet(GreetRequest request){
        
        System.out.println("You are in the greet method or the greet service");
        
        // we get the greeting object from the request (as defined in the proto file)
        Greeting greeting = request.getGreeting();
        GreetingEntity greetingEntity = new GreetingEntity();
        greetingEntity.setFirstName(greeting.getFirstName());
        greetingEntity.setLastName(greeting.getLastName()); 
        this.greetingRepository.save(greetingEntity);
        String result = "Hello " + greeting.getFirstName() + greeting.getLastName();
        
        // build our response where the type should be GreetResponse
        GreetResponse response =  GreetResponse.newBuilder()
                .setResult(result)
                .build();
        return response;
    }
    
}