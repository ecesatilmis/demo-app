package com.example.kuartis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kuartis.model.GreetingEntity;

public interface GreetingRepository extends JpaRepository<GreetingEntity, String> {

	//Optional<GreetingEntity> findByName(String first_name);
}
