package com.medicinemis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicineDTO {
    private Integer medicineOrdersNo; //药品订单关联主键
     private Integer medicineNo;       //药品编号1
     private String medicineName;      //药品名称1
     private String medicineImage;     //图片1
     private String medicineMode;      //服用方式（例如口服，外用等）1
     private String medicineEfficacy;  //功效1
     private Integer ordersNo;         //订单编号
     private Integer medicineNumber;   //购买数量（加）
    private Integer price;    //单个价格1
    private Integer medicineCount;    //剩余数量1
}
