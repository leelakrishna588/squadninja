package com.stackroute.ideahamsterpostingidea.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Document(collection = "idea")

@Data

// It generates constructor with no parameters
@NoArgsConstructor

// It generates a constructor with 1 parameter for each field
@AllArgsConstructor

/*  It produces complex builder APIs for class
    It automatically produce the code required to have your class be instantiable with code
 */
@Builder
@Component
public class Idea {
  @Id
  private String id;
  private String title;
  private String description;
  private String duration;
  private String domain;
  private String subDomain;
  private double cost;
  private List<Role> role;
  private String status;
  private Date postedOn;
  private String postedBy;
  private String location;
}
