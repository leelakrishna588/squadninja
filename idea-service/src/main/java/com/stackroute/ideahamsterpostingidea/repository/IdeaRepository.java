package com.stackroute.ideahamsterpostingidea.repository;

import com.stackroute.ideahamsterpostingidea.domain.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/*@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval,
 search, update and delete operation on objects.*/
@Repository
public interface IdeaRepository extends MongoRepository<Idea, String> {

  public Idea findByTitle(String title);

  public Idea findByLocation(String location);


}
