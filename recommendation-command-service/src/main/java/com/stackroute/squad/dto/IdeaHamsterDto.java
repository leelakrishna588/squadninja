package com.stackroute.squad.dto;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

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
public class IdeaHamsterDto {
  @Id

  private String email;
  private String name;
  private long mobile;
  private List<IdeaDto> postedIdea;
  private Date timestamp;

}
