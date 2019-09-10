package com.stackroute.squad.dto;

import lombok.*;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;
/*@NodeEntity will be represented as nodes in the graph.*/
@NodeEntity
/*it can generate getters and setters for those object automatically by using Lombok annotations. The easiest way is to use the @Data annotation.*/
@Data
/*It generates constructor with no parameters*/
@NoArgsConstructor
/*It generates a constructor with 1 parameter for each field*/
@AllArgsConstructor
@Getter
@Setter
@ToString
public class IdeaDto {
  @Id
  private int id;
  private String title;
  private String description;
  private String duration;
  private String domain;
  private String subDomainName;
  private double cost;
  private List<RolesDto> role;
  private String status;
  private Date postedOn;
  private String postedBy;
  private String location;
}

