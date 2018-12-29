package com.hik.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Idiom {
    private String id;
    private String auswer;
    private String pic;
    private String tips;
    private Integer hits;       //命中次数
    private Integer display;    //显示次数
    private String createTime;
    private String createBy;


}