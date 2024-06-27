package com.medicinemis.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Operator {
    private Integer operatorNo;          //编号
    private String operatorName;         //姓名
    private Integer operatorSex;         //性别
    private String operatorPassword;     //密码
    private String operatorPhone;        //电话
    private String operatorClass;        //用户类型
    private String operatorRemark;       //备注
}
