package com.stackroute.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

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
@Document(collection = "IdeaHamster")
public class IdeaHamster {

    @Id
    private String email;
    private String name;
    private long mobileNo;
    private List<Idea> postedIdea;
    private Date timestamp;

}
