package com.medicinemis.sevice;


import com.medicinemis.pojo.Buyer;
import com.medicinemis.pojo.Medicine;
import com.medicinemis.pojo.PageBean;

import java.util.List;

public interface BuyerService {


    List<Medicine> list();

    /*void delete(Integer medicineNo);*/

    void add(Medicine medicine);

    Medicine getByMedicineNo(Integer medicineNo);

    void update(Medicine medicine);

    PageBean page(Integer page, Integer pageSize, Integer medicineNo, String medicineName, String medicineMode, String medicineEfficacy);

    void delete(List<Integer> medicineNos);

    Buyer buyerLogin(Buyer buyer);
}
