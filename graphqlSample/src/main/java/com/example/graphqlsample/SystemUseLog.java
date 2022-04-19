package com.example.graphqlsample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemUseLog {
    private Long systemKey;
    private Long groupUserKey;
    private Long groupKey;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
