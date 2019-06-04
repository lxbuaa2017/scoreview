package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity

public class Comment implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    //Comment关联外键score，为了测试导入excel功能需要暂时注释
    //@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER,targetEntity = Score.class)
    //@JoinColumn(referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_sco_comment"))
    //private Score score;

    private String comment_details;
    private Integer teacher_id;
    private LocalDateTime localDateTime;
    @ManyToOne(fetch=FetchType.LAZY,targetEntity=Score.class)
    @JoinColumn(name="score",referencedColumnName = "id",
            foreignKey = @ForeignKey(name ="FK_Cmo_Score"))

    private Score score;
}
