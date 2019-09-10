package com.stackroute.userloginservice.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String emailId;
    private String role;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "emailId='" + emailId + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}