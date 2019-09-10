package com.stackroute.recommendedqueryservice.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Idea {
    @Id @GeneratedValue
    private long id;
    private String title;
    private String description;
    private String duration;
    private String cost;
    private String status;
    private String postedBy;
    private String postedOn;
    @Relationship(type = "belongs_to", direction = Relationship.OUTGOING)
    private SubDomain subDomain;
    @Relationship(type = "requires", direction = Relationship.OUTGOING)
    private List<Roles> roles;
    @Relationship(type = "requires", direction = Relationship.OUTGOING)//experience
    private List<Skills> skills;
    @Relationship(type = "worked_on", direction = Relationship.INCOMING)
    private List<ServiceProvider> serviceProvider;
    @Relationship(type = "posted_by", direction = Relationship.INCOMING)
    private  IdeaHamster ideaHamster;
}
