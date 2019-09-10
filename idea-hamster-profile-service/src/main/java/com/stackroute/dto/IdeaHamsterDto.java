package com.stackroute.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class IdeaHamsterDto {
    private String userName;
    private String email;
    private String password;
    private String role;
}
