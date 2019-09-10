package com.stackroute.teammanagementservice.repository;

import com.stackroute.teammanagementservice.domain.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamManagementRepository extends MongoRepository<Idea,String> {
    Idea findByTitle(String title);
    String findByEmailId(String emailId);

}

