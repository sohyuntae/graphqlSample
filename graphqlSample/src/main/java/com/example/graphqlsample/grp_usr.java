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
@Table(name = "grp_usr")
public class grp_usr {
    @Id
    @Column(name="GU_KEY")
    private Long guKey;
    @Column(name="OG_KEY")
    private Long ogKey;
    @Column(name="UI_KEY")
    private Long uiKey;
}
