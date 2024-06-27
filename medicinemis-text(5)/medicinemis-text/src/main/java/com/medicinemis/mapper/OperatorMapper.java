package com.medicinemis.mapper;


import com.medicinemis.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OperatorMapper {

    @Select("select * from orders")
    List<Orders> ordersList();

    @Select("select * from client")
    List<Client> clientList();


    void addOrders(Orders orders);

    @Insert("insert into medicine_orders(medicine_no, orders_no, medicine_number, price)" +
            "values (#{medicineNo},#{ordersNo},#{medicineNumber},#{price})")
    void addMedicineOrder(MedicineDTO medicineDTO);

    @Insert("insert into client(client_name, client_sex, client_age, client_address, client_phone, client_symptom, client_date, client_remark)" +
            "values (#{clientName},#{clientSex},#{clientAge},#{clientAddress},#{clientPhone},#{clientSymptom},#{clientDate},#{clientRemark})")
    void addClient(Client client);

    @Select("select * from orders where orders_no = #{ordersNo}")
    Orders getByOrdersNO(Integer ordersNo);

    /*@Update("update orders set client_no = #{clientNo}, medicine_no = #{medicineNo}," +
            " operator_no = #{operatorNo}, medicine_num = #{medicineNum} where orders_no = #{ordersNo}")*/
    void updateOrders(Orders orders);

    @Select("select * from client where client_no = #{clientNo}")
    Client getByClientNo(Integer clientNo);

    /*@Update("update client set client_name = #{clientName}, client_sex = #{clientSex}, client_age = #{clientAge}" +
            ", client_address = #{clientAddress}, client_phone = #{clientPhone}, client_symptom = #{clientSymptom}" +
            ", client_remark = #{clientRemark} where client_no = #{clientNo}")*/
    void updateClient(Client client);

    /*@Select("select count(*) from orders")
    Long count();

    @Select("select * from  orders limit #{start}, #{pageSize}")
    List<Orders> ordersPage(Integer start, Integer pageSize);*/

    //@Select("select * from orders")
    List<Orders> ordersPage(Integer ordersNo, Integer clientNo, Integer medicineNo, Integer operatorNo);

    /*@Select("select count(*) from client")
    Long count();

    @Select("select * from client limit #{start},#{pageSize}")
    List<Client> clientPage(Integer start, Integer pageSize);*/
    //@Select("select * from client")
    List<Client> clientPage(Integer clientNo, String clientName, Integer clientSex, Integer clientAge,
                            String clientAddress, String clientPhone, String clientSymptom);

    @Select("select * from operator where operator_phone = #{operatorPhone} and operator_password = #{operatorPassword}")
    Operator operatorLogin(Operator operator);

    //@Select("select * from medicine_orders mo,medicine m where mo.medicine_no = m.medicine_no")

    //@Select("select * from medicine m left join medicine_orders mo on m.medicine_no = mo.medicine_no")
    @Select("select * from medicine_orders mo,medicine m,orders o where mo.orders_no = o.orders_no and m.medicine_no = mo.medicine_no")
    List<MedicineDTO> getOrdersByOrdersNO(Integer ordersNo);

    void deleteShoppongCart(MedicineDTO medicineDTO);

    List<MedicineDTO> getMedicineList(MedicineDTO medicineDTO);

    @Update("update medicine_orders set medicine_number = #{medicineNumber} where medicine_orders_no = #{medicineOrdersNo}")
    void updateMedicineNumber(MedicineDTO medicineDTO1);

    @Insert("insert into medicine_orders(medicine_no, orders_no, medicine_number, price)" +
            "values (#{medicineNo},#{ordersNo},#{medicineNumber},#{price})")
    void insertShoppingCart(MedicineDTO medicineDTO);

}
