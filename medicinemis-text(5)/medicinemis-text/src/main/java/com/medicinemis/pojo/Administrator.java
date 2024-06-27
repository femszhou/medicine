package com.medicinemis.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Administrator {
    private Integer administratorNo;
    private String administratorName;
    private Integer administratorSex;
    private String administratorPassword;
    private String administratorPhone;
    private String administratorClass;
    private String administratorRemark;

}
