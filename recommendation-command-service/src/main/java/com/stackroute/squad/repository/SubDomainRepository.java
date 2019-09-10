package com.stackroute.squad.repository;

import com.stackroute.squad.domain.Domain;
import com.stackroute.squad.domain.SubDomain;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
/*@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval,
 search, update and delete operation on objects.*/
@Repository
public interface SubDomainRepository extends Neo4jRepository<SubDomain, Integer> {
  public SubDomain findById(int id);
  @Query("MATCH (sd:SubDomain)<-[h:has]-(d:domain) RETURN sd,h,d")
  public Domain domain();

}
