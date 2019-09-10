package com.stackroute.recommendedqueryservice.repository;

import com.stackroute.recommendedqueryservice.domain.Domain;
import com.stackroute.recommendedqueryservice.domain.Idea;
import com.stackroute.recommendedqueryservice.domain.IdeaHamster;
import com.stackroute.recommendedqueryservice.domain.SubDomain;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IdeaRecommendationRepository extends Neo4jRepository<IdeaHamster,Long> {
    //    @Query("match (i:idea),(s:skill) where s.name={name} match (i:idea)-[n:needs]->(s:skill) return i.title as name")

    @Query("MATCH (n) WHERE n:Domain RETURN n")
    Collection<Domain> getDomaind();
    @Query("MATCH (n) WHERE n:SubDomain RETURN n")
    Collection<SubDomain> getsubDomaind();
    @Query("MATCH (n:Idea) RETURN n")
    Collection<Idea> getall();
    @Query("MATCH (n:IdeaHamster) RETURN n")
    Collection<IdeaHamster> getih();

//    @Query("MATCH(i:idea),(s:skills) where s.name={name} AND (i)-[:requires]->(s) return i")
////    List<Idea> findBySkill(@Param("name") String name);
//    @Query("match(i:idea)")

    //The above method gives all idea with the desired skill'
    @Query("match (i:Domain),(s:SubDomain) where i.domainName={domainName} match (i)-[has]->(s) return s")
    Collection<SubDomain> findByDomain(@Param("domainName") String name);
    @Query("match (i:idea),(r:role) where r.name=({name}) match (i:idea)-[n:requires]->(r:role) return i")
    List<Idea> findByRole(@Param("name") String name);

    //The above method gives all idea with the desired role
    @Query("match (s:serviceProvider{name:\"sp1\"})-[w:worked_on]->(i:idea),(i:idea)-" +
            "[r:requires]->(ro:role)<-[re:requires]-(rec:idea) where not exists ((s:serviceProvider)" +
            "-[w:worked_on]->(rec:idea)) return i")
    List<Idea> findByWorkedOnIdea(String ideaName);

    @Query("match (s:serviceProvider{name:\"sp1\"})-[w:applied_on]->(i:idea),(i:idea)-" +
            "[r:requires]->(ro:role)<-[re:requires]-(rec:idea) where not exists ((s:serviceProvider)" +
            "-[w:applied_on]->(rec:idea)) return i")
    List<Idea> findByAppliedOnIdea(String ideaName);

//    @Query("CREATE (f:skill{name:{name}}) return f.name")
//    String saveSkill(@Param("name") String name);
}
