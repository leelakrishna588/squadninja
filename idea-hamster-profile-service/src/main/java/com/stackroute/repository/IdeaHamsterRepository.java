package com.stackroute.repository;

import com.stackroute.domain.IdeaHamster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaHamsterRepository extends MongoRepository<IdeaHamster,Integer> {

    public IdeaHamster findByEmail(String email);



}
