package com.stackroute.recommendedqueryservice.domain;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ServiceProvider {
    @Id
    private int id;
    private String name;
    private long mobileNo;
    private String email;
//    private String domain;
//    private String subDomain;
//    private String previousProject;
    private String chargePerHour;
//    private String currentLocation;
//    private List<String> preferredLocation;
    @Relationship(type = "has_skills", direction = Relationship.OUTGOING)
    private List<Skills> skills;
}
