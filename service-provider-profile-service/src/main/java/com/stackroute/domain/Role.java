package com.stackroute.domain;

import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Role {
    private String roleName;
    private List<String> skills;
    private String experience;
}
