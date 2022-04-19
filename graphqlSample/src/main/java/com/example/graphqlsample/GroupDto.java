package com.example.graphqlsample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private Long groupKey;
    private Long parentGroupKey;
    private String groupName;
}
