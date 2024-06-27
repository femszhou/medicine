package com.medicinemis.sevice.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.medicinemis.mapper.BuyerMapper;
import com.medicinemis.pojo.Buyer;
import com.medicinemis.sevice.BuyerService;
import com.medicinemis.pojo.Medicine;
import com.medicinemis.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerMapper buyerMapper;

    @Override
    public List<Medicine> list() {
        return buyerMapper.list();
    }

    /*@Override
    public void delete(Integer medicineNo) {
        buyerMapper.delete(medicineNo);
    }*/

    @Override
    public void add(Medicine medicine) {
        buyerMapper.add(medicine);
    }

    @Override
    public Medicine getByMedicineNo(Integer medicineNo) {
        return buyerMapper.getByMedicineNo(medicineNo);
    }

    @Override
    public void update(Medicine medicine) {
        buyerMapper.update(medicine);
    }

    @Override
    /*public PageBean page(Integer page, Integer pageSize) {
        Long count = buyerMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Medicine> medicineList = buyerMapper.page(start,pageSize);
        PageBean pageBean = new PageBean(count,medicineList);
        return pageBean;
    }*/

    public PageBean page(Integer page, Integer pageSize, Integer medicineNo, String medicineName, String medicineMode, String medicineEfficacy) {
        PageHelper.startPage(page, pageSize);
        List<Medicine> medicineList = buyerMapper.page(medicineNo, medicineName, medicineMode, medicineEfficacy);
        Page<Medicine> p = (Page<Medicine>) medicineList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> medicineNos) {
        buyerMapper.delete(medicineNos);
    }

    @Override
    public Buyer buyerLogin(Buyer buyer) {
        return buyerMapper.buyerLogin(buyer);
    }
}
