package com.stackroute.teammanagementservice.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
//@Document(collection="role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Role {
    private String experience;
    private String noOfPeople;
    private List<String> skills;
    private String roleName;
}
