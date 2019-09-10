package com.stackroute.squad.repository;


import com.stackroute.squad.domain.ServiceProvider;
import com.stackroute.squad.domain.Skills;
import com.stackroute.squad.dto.IdeaDto;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/*@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval,
 search, update and delete operation on objects.*/
@Repository
public interface ServiceProviderRepository extends Neo4jRepository<ServiceProvider, Integer> {
  public ServiceProvider findById(int id);
  ServiceProvider findByEmail(String email);
  @Query("MATCH (sp:ServiceProvider),(i:Idea) WHERE sp.email={email} and i.title={title} CREATE (sp)-[w:worked_on]->(i) RETURN sp")
  public ServiceProvider createRelation(@Param("email")String email, @Param("title") String title);
 @Query("MATCH(sp:ServiceProvider),(r:Roles) WHERE sp.email={email} and r.roleName={roleName} CREATE (sp)<-[p:played_by]-(r) RETURN sp")
  public ServiceProvider findByRoles(@Param("email")String email, @Param("roleName")String roleName);
  @Query("MATCH(sp:ServiceProvider),(s:skills) WHERE sp.email={email} and s.name={name} CREATE (sp)-[hs:has_skills]->(s) RETURN sp")
  public ServiceProvider findBySkills(@Param("email")String email, @Param("name")String name);
}
