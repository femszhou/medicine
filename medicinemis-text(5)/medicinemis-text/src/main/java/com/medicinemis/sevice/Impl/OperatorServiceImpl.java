package com.medicinemis.sevice.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.medicinemis.mapper.BuyerMapper;
import com.medicinemis.mapper.OperatorMapper;
import com.medicinemis.pojo.*;
import com.medicinemis.sevice.OperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorMapper operatorMapper;

    @Autowired
    private BuyerMapper buyerMapper;

    @Override
    public List<Orders> ordersList() {
        return operatorMapper.ordersList();
    }

    @Override
    public List<Client> clientList() {
        return operatorMapper.clientList();
    }

    @Override
    public Orders addOrders(Orders orders) {
        orders.setOrdersDate(LocalDateTime.now());
        operatorMapper.addOrders(orders);
        Integer ordersNo = orders.getOrdersNo();
        Orders orders1 = new Orders();
        orders1.setOrdersNo(ordersNo);
        return orders1;
    }

    @Transactional
    public void addShoppingCart(MedicineDTO medicineDTO) throws MyException {
        //Orders orders = new Orders();
        //orders.setOrdersDate(LocalDateTime.now());
        Medicine medicine = buyerMapper.getByMedicineNo(medicineDTO.getMedicineNo());
        List<MedicineDTO> medicineDTOList = operatorMapper.getMedicineList(medicineDTO);
        if (medicineDTOList != null && medicineDTOList.size() > 0) {
            MedicineDTO medicineDTO1 = medicineDTOList.get(0);

            if (medicine.getMedicineCount() - 1 >= 0) {
                medicine.setMedicineCount(medicine.getMedicineCount() - 1);
                buyerMapper.update(medicine);
                medicineDTO1.setMedicineNumber(medicineDTO1.getMedicineNumber() + 1);
                operatorMapper.updateMedicineNumber(medicineDTO1);
            } else {
                throw new MyException("药品数量不够");
            }
        } else {
            if (medicine.getMedicineCount() - 1 >= 0) {
                medicine.setMedicineCount(medicine.getMedicineCount() - 1);
                buyerMapper.update(medicine);
                medicineDTO.setMedicineNumber(1);
                operatorMapper.insertShoppingCart(medicineDTO);
            } else {
                throw new MyException("药品数量不够");
            }
        }
    }

    @Transactional
    public void subShoppingCart(MedicineDTO medicineDTO) {
        Integer ordersNo = medicineDTO.getOrdersNo();
        //设置查询条件，查询当前登录用户的购物车数据

        List<MedicineDTO> medicineDTOList = operatorMapper.getMedicineList(medicineDTO);

        if (medicineDTOList != null && medicineDTOList.size() > 0) {
            medicineDTO = medicineDTOList.get(0);
            Medicine medicine = buyerMapper.getByMedicineNo(medicineDTO.getMedicineNo());
            Integer number = medicineDTO.getMedicineNumber();
            if (number == 1) {
                //当前商品在购物车中的份数为1，直接删除当前记录
                medicine.setMedicineCount(medicine.getMedicineCount() + 1);
                buyerMapper.update(medicine);
                operatorMapper.deleteShoppongCart(medicineDTO);
            } else {
                //当前商品在购物车中的份数不为1，修改份数即可
                medicine.setMedicineCount(medicine.getMedicineCount() + 1);
                buyerMapper.update(medicine);
                medicineDTO.setMedicineNumber(medicineDTO.getMedicineNumber() - 1);
                operatorMapper.updateMedicineNumber(medicineDTO);
            }
        }
    }

    @Transactional
    public List<MedicineDTO> showShoppingCart(Integer ordersNo) {
        MedicineDTO medicineDTO = new MedicineDTO();
        medicineDTO.setOrdersNo(ordersNo);
        List<MedicineDTO> medicineDTOList = operatorMapper.getMedicineList(medicineDTO);
        medicineDTOList.forEach(medicineDTO1 -> {
            Medicine medicine = buyerMapper.getByMedicineNo(medicineDTO1.getMedicineNo());
            BeanUtils.copyProperties(medicine, medicineDTO1);
        });
        return medicineDTOList;
    }

    public void addClient(Client client) {
        client.setClientDate(LocalDateTime.now());
        operatorMapper.addClient(client);
    }

    @Transactional
    public Orders getByOrdersNo(Integer ordersNo) {
        Orders orders = operatorMapper.getByOrdersNO(ordersNo);
        List<MedicineDTO> medicineDTOList = operatorMapper.getOrdersByOrdersNO(ordersNo);
        Integer totalPrice = 0;
        for (MedicineDTO medicineDTO : medicineDTOList) {
            totalPrice += medicineDTO.getPrice() * medicineDTO.getMedicineNumber();
        }
        orders.setTotalPrice(totalPrice);
        orders.setMedicineList(medicineDTOList);
        return orders;
    }

    @Transactional
    public void updateOrders(Orders orders) throws MyException {
        operatorMapper.updateOrders(orders);
        /*List<MedicineDTO> medicineDTOList = orders.getMedicineList();
        MedicineDTO medicineDTO1 = new MedicineDTO();
        medicineDTO1.setOrdersNo(orders.getOrdersNo());
        operatorMapper.deleteShoppongCart(medicineDTO1);

        for (MedicineDTO medicineDTO : medicineDTOList) {
            Medicine medicine = buyerMapper.getByMedicineNo(medicineDTO.getMedicineNo());
            if (medicineDTO.getMedicineCount() - medicineDTO.getMedicineNumber() > 0) {
                medicine.setMedicineCount(medicineDTO.getMedicineCount() - medicineDTO.getMedicineNumber());
                buyerMapper.update(medicine);
            } else {
                throw new MyException("药品不足");
            }
            operatorMapper.addMedicineOrder(medicineDTO);
        }*/
    }

    @Override
    public Client getByClientNo(Integer clientNo) {
        return operatorMapper.getByClientNo(clientNo);
    }

    @Override
    public void updateClient(Client client) {
        operatorMapper.updateClient(client);
    }

    /*@Override
    public PageBean ordersPage(Integer page, Integer pageSize) {
        Long count = operatorMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Orders> ordersList = operatorMapper.ordersPage(start, pageSize);
        PageBean pageBean = new PageBean(count, ordersList);
        return pageBean;
    }*/

    @Transactional
    public PageBean ordersPage(Integer page, Integer pageSize, Integer ordersNo, Integer clientNo, Integer medicineNo, Integer operatorNo) {
        PageHelper.startPage(page, pageSize);
        List<Orders> ordersList = operatorMapper.ordersPage(ordersNo, clientNo, medicineNo, operatorNo);
        for (Orders orders : ordersList) {
            MedicineDTO medicineDTO = new MedicineDTO();
            medicineDTO.setOrdersNo(orders.getOrdersNo());
            List<MedicineDTO> medicineList = operatorMapper.getMedicineList(medicineDTO);
            Integer totalPrice = 0;
            for (MedicineDTO medicineDTO1 : medicineList) {
                totalPrice += medicineDTO1.getPrice() * medicineDTO1.getMedicineNumber();
            }
            Orders orders1 = operatorMapper.getByOrdersNO(orders.getOrdersNo());
            orders1.setTotalPrice(totalPrice);
            operatorMapper.updateOrders(orders1);
        }
        Page<Orders> p = (Page<Orders>) ordersList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    /*@Override
    public PageBean clientPage(Integer page, Integer pageSize) {
        Long count = operatorMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Client> clientList = operatorMapper.clientPage(start, pageSize);
        PageBean pageBean = new PageBean(count, clientList);
        return pageBean;
    }*/

    @Override
    public PageBean clientPage(Integer page, Integer pageSize, Integer clientNo, String clientName, Integer clientSex, Integer clientAge,
                               String clientAddress, String clientPhone, String clientSymptom) {
        PageHelper.startPage(page, pageSize);
        List<Client> clientList = operatorMapper.clientPage(clientNo, clientName, clientSex, clientAge, clientAddress, clientPhone, clientSymptom);
        Page<Client> p = (Page<Client>) clientList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public Operator operatorLogin(Operator operator) {
        return operatorMapper.operatorLogin(operator);
    }


}
