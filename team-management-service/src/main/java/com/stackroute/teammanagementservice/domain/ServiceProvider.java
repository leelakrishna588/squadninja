package com.stackroute.teammanagementservice.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@Document(collection = "serviceprovider")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ServiceProvider {
private String name;
private int mobileNumber;
private String emailId;
private List<String> skills;
private double chargePerHour;
}
