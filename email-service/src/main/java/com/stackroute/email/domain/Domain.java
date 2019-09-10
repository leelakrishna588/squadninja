package com.stackroute.email.domain;
import lombok.*;

/*
lombok performed.
* */
@Data
//Default constructor
@NoArgsConstructor
//parameterized constructor
@AllArgsConstructor
//toString()
@ToString
@Getter
/*
getter and setter methods
*/
@Setter
public class Domain {
//    private String firstName;
//    private String lastName;
    private String email;
}
