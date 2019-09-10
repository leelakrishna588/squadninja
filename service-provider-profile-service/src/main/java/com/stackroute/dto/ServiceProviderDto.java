package com.stackroute.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ServiceProviderDto {
    private String userName;
    private String email;
    private String password;
    private String role;
}
