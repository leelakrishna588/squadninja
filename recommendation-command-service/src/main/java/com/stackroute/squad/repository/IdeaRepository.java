package com.stackroute.squad.repository;

import com.stackroute.squad.domain.Idea;
import com.stackroute.squad.domain.Roles;
import com.stackroute.squad.domain.ServiceProvider;
import com.stackroute.squad.domain.SubDomain;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/*@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval,
 search, update and delete operation on objects.*/
@Repository
public interface IdeaRepository extends Neo4jRepository<Idea, Integer> {
  public Idea findById(int id);
  public Idea deleteByTitle(String title);
 /* @Query("MATCH(i:Idea),(r:Roles) where  (i)-[:requires]->(r) return i")
  List<Roles> setRelation(@Param("roleName") String roleName);
*/
  /*@Query("CREATE(i:Idea)-[:posted by {date:{date}]<-(ih:IdeaHamster)")
  Idea setRelation(@Param("posted by") Date date);

  @Query("MATCH (i:Idea)->[b:belongs_to]-(s:subDomain) RETURN i,b,s")
  List<SubDomain> setSubDomain();

  *//* @Query("MATCH(i:Idea)->[rq:requires]-(r:Roles) RETURN i,rq,r")
   List<String> roles(@Param("name") String name);*//*
  @Query("CREATE(i:Idea)-[is:needs {experience:{experience}]->(s: Skills) RETURN i,n,is")
  Idea setRelation(@Param("needs") String experience);

  @Query("MATCH (i:Idea)<-[w:worked_on]-(sp:serviceProvider) RETURN i,w,sp")
  List<ServiceProvider> setServiceProvider();*/
 /* @Query("CREATE(i:Idea)-[:requires {name: {name}]->(r:roles)")
  List<Idea> setRelation(@Param("name") String name);*/
  /*@Query("MATCH (i:Idea)<-[r:requires]-(a:Roles) RETURN i,r,a NAME {name}")
  List<Roles> graph(@Param("name") String name);*/
 @Query("MATCH (x:Idea),(y:Roles) WHERE x.title={title} and y.roleName={roleName} CREATE (x)-[r:requires]->(y) RETURN x")
 public Idea setRequiresRelation(@Param("title")String title, @Param("roleName")String roleName);


 @Query("MATCH (i:Idea),(s:subdomain) WHERE i.title={title} and s.name={name} CREATE (i)-[b:belongs_to]->(s) RETURN i")
  public Idea setBelongsToRelation(@Param("title")String title, @Param("name")String name);

  @Query("MATCH (i:Idea),(sk:skills) WHERE i.title={title} and sk.name={name} CREATE (i)-[h:need]->(sk) RETURN i")
  public Idea setNeedsRelation(@Param("title")String title, @Param("name") String name);


}
