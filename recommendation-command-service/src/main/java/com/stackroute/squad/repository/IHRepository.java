package com.stackroute.squad.repository;

import com.stackroute.squad.domain.Idea;
import com.stackroute.squad.domain.IdeaHamster;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
/*@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval,
 search, update and delete operation on objects.*/
@Repository
public interface IHRepository extends Neo4jRepository<IdeaHamster, Integer> {
  public IdeaHamster findById(int id);

}
