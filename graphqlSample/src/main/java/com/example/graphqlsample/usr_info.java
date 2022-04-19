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
@Table(name = "usr_info")
public class usr_info {
    @Id
    @Column(name="UI_KEY")
    private Long uiKey;
    @Column(name="UI_ID")
    private String uiId;
    @Column(name="UI_PW")
    private String uiPw;
    @Column(name="UI_NM")
    private String uiNm;
}
