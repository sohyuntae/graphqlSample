package com.example.graphqlsample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class stm_real_use_hstry_id implements Serializable
{
    private Long siKey;
    private LocalDateTime strtDt;
}
