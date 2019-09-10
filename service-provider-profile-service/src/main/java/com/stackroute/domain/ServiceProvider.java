package com.stackroute.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**With @Data, Lombok will generate getter and setter methods, toString methods, Equal & Hashcode methods*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder


/**
 * Document annotated class will have the ability to represent objects in the database
 */
@Document( collection = "ServiceProvider")
public class ServiceProvider {

    @Id
    private String email;
    private String name;
    private long mobileNo;
    private String domain;
    private String subDomain;
    private Role role;
    private List<Idea> workedIdeas;
    private String chargePerHour;
    private String currentLocation;
    private List<String> preferredLocation;
    private Date timestamp;

}
