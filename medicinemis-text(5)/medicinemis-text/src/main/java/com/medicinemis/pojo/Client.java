package com.medicinemis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    private Integer clientNo;         //编号
    private String clientName;        //姓名
    private Integer clientSex;        //性别
    private Integer clientAge;        //年龄
    private String clientAddress;     //住址
    private String clientPhone;       //手机号码
    private String clientSymptom;     //症状
    private LocalDateTime clientDate; //注册日期
    private String clientRemark;      //备注
}
