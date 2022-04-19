package com.example.graphqlsample;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "stm_real_use_hstry")
@IdClass(stm_real_use_hstry_id.class)
public class stm_real_use_hstry {
    @Id
    @Column(name="SI_KEY")
    private Long siKey;
    @Id
    @Column(name="STRT_DT")
    private LocalDateTime strtDt;
    @Column(name="END_DT")
    private LocalDateTime endDt;
    @Column(name="REAL_USG_SCND")
    private Long realUsgScnd;
    @Column(name="AST_NMBR")
    private String astNmbr;
    @Column(name="PRDCT_NMBR")
    private String prdctNmbr;
    @Column(name="STRT_DY")
    private LocalDateTime strtDy;
    @Column(name="END_DY")
    private LocalDateTime endDy;
    @Column(name="STCS_DT")
    private LocalDateTime stcsDt;
    @Column(name="STCS_END_DY")
    private LocalDateTime stcsEndDy;
    @Column(name="REG_DT")
    private LocalDateTime regDt;
    @Column(name="CMPNY_NM")
    private String cmpnyNm;
    @Column(name="OG_NMS")
    private String ogNms;
    @Column(name="UI_ID")
    private String uiId;
    @Column(name="UI_NM")
    private String uiNm;
    @Column(name="USR_TYPE_NM")
    private String usrTypeNm;
    @Column(name="SI_IP")
    private String siIp;
    @Column(name="MAC_ADRS")
    private String macAdrs;
    @Column(name="SI_NM")
    private String siNm;
    @Column(name="WRK_GRP_NM")
    private String wrkGrpNm;
    @Column(name="ASGN_TYPE_NM")
    private String asgnTypeNm;
    @Column(name="AST_INOT_NM")
    private String astInotNm;
    @Column(name="OG_KEY")
    private Long ogKey;
    @Column(name="GU_KEY")
    private Long guKey;
    @Column(name="UI_KEY")
    private Long uiKey;
}
