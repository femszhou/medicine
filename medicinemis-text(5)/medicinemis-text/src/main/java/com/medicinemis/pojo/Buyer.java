package com.medicinemis.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Buyer {
    private Integer buyerNo;       //编号
    private String buyerName;      //姓名
    private Integer buyerSex;      //性别
    private String buyerPassword;  //密码
    private String buyerPhone;     //电话号码
    private String buyerClass;     //用户类型
    private String buyerRemark;    //备注
}
