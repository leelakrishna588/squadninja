package com.stackroute.teammanagementservice.dto;

import com.stackroute.teammanagementservice.domain.Role;
import com.stackroute.teammanagementservice.domain.ServiceProvider;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Document(collection="ideaDto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class IdeaDto {
    private int id;
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
