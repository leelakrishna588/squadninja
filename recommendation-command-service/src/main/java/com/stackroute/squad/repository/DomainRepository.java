package com.stackroute.squad.repository;

import com.stackroute.squad.domain.Domain;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
/*@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval,
 search, update and delete operation on objects.*/
@Repository
public interface DomainRepository extends Neo4jRepository<Domain, Integer> {
  public Domain findById(int id);

}
