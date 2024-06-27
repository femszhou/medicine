package com.medicinemis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    private Integer ordersNo;            //订单编号
    private Integer clientNo;            //顾客编号
    private LocalDateTime ordersDate;    //订单日期
    //private Integer medicineNo;          //药品编号
    private Integer operatorNo;          //经办人编号
    private Integer totalPrice;          //总价钱
    private List<MedicineDTO> medicineList = new ArrayList<>(); //购买的药品
}
