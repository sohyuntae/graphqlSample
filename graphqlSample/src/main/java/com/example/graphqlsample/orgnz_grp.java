package com.example.graphqlsample;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orgnz_grp")
public class orgnz_grp {
    @Id
    @Column(name="OG_KEY")
    private Long ogKey;
    @Column(name="OG_NM")
    private String ogNm;
    @Column(name="OG_PRNT_KEY")
    private Long ogPrntKey;
}
