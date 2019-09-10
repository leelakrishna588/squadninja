package com.stackroute.teammanagementservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Document(collection="idea")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
    private List<ServiceProvider> appliedTeam;
    private List<ServiceProvider> invitedTeam;
    private List<ServiceProvider> selectedTeam;
    private String status;
    private Date postedOn;
    private String postedBy;
    private String location;

}
