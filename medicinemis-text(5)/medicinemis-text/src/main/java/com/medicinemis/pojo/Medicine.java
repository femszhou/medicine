package com.medicinemis.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medicine {
    private Integer medicineNo;       //药品编号
    private String medicineName;      //药品名称
    private String medicineImage;     //图片
    private String medicineMode;      //服用方式（例如口服，外用等）
    private String medicineEfficacy;  //功效
    private Integer medicinePrice;    //价格
    private Integer medicineCount;    //剩余数量
}
