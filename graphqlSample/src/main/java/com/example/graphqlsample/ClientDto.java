package com.example.graphqlsample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private SystemDto systemDto;
    private UserDto userDto;
    private GroupDto groupDto;
}
