package com.example.graphqlsample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long groupKey;
    private Long groupUserKey;
    private Long userKey;
    private String userName;
}
