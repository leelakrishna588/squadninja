package com.stackroute.recommendedqueryservice.repository;

import com.stackroute.recommendedqueryservice.domain.ServiceProvider;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TeamRecommendationService extends Neo4jRepository<ServiceProvider, Long> {
    @Query("match(r:Roles)-[p:played_by]->(sp:ServiceProvider),(i:Idea)-[re:requires]->(r:Roles)-[h:have]->(s:Skills)" +
            " where sp.experience={experience} and i.title={title} and r.roleName={roleName} return sp")
    Collection<ServiceProvider> getTeam(@Param("title") String name,@Param("experience") String ex,@Param("roleName") String rname);
}
