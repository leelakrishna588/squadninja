package com.stackroute.recommendedqueryservice.domain;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
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
public class SubDomain {
    @Id @GeneratedValue
    private Long id;
    private String subDomainName;
    @Relationship(type = "has", direction = Relationship.INCOMING)
    private Domain domain;
}
