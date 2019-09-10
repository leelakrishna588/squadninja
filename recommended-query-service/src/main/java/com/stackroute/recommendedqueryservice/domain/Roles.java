package com.stackroute.recommendedqueryservice.domain;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Roles {
    @Id
    private int id;
    private String roleName;
    //private int noOfPeople;
    private String experience;
    @Relationship(type = "have", direction = Relationship.OUTGOING)
    private Skills skills;
    @Relationship(type="played_by", direction = Relationship.OUTGOING)
    private ServiceProvider serviceProvider;
}
