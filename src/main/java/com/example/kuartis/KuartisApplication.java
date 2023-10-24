package com.example.kuartis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KuartisApplication {

	public static void main(String[] args) {
	  // final int PORT = 9090;
        
    //     // Create a new server to listen on port 9090
    //     Server server = ServerBuilder.forPort(PORT)
    //             .addService(new GreetingRpcService())
    //             .build();

    //     // Start the server
    //     server.start();

    //     // Server threads are running in the background.
    //     System.out.println("Server started...");
    //     // Don't exit the main thread. Wait until server is terminated.
    //     server.awaitTermination();

		SpringApplication.run(KuartisApplication.class, args);

    
	}

}
