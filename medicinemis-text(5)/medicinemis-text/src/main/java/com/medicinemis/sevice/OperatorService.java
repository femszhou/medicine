package com.medicinemis.sevice;


import com.medicinemis.pojo.*;

import java.util.List;

public interface OperatorService {

    List<Orders> ordersList();

    List<Client> clientList();

    Orders addOrders(Orders orders);
    void addShoppingCart(MedicineDTO medicineDTO) throws MyException;
    void addClient(Client client);

    Orders getByOrdersNo(Integer ordersNo);

    void updateOrders(Orders orders) throws MyException;

    Client getByClientNo(Integer clientNo);

    void updateClient(Client client);

    PageBean ordersPage(Integer page, Integer pageSize, Integer ordersNo, Integer clientNo, Integer medicineNo, Integer operatorNo);

    PageBean clientPage(Integer page, Integer pageSize, Integer clientNo, String clientName, Integer clientSex, Integer clientAge,
                        String clientAddress, String clientPhone, String clientSymptom);

    Operator operatorLogin(Operator operator);


    /*Orders showShoppingCartByOrdersNo(Integer ordersNo);*/

    void subShoppingCart(MedicineDTO medicineDTO);

    List<MedicineDTO> showShoppingCart(Integer ordersNo);
}
