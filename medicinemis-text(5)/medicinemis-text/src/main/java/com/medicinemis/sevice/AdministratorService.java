package com.medicinemis.sevice;


import com.medicinemis.pojo.Administrator;
import com.medicinemis.pojo.Buyer;
import com.medicinemis.pojo.Operator;
import com.medicinemis.pojo.PageBean;

import java.util.List;

public interface AdministratorService {

    List<Buyer> buyerList();

    List<Operator> operatorList();

    void deleteBuyer(Integer buyerNo);

    void deleteOperator(Integer operatorNo);

    void addBuyer(Buyer buyer);

    void addOperator(Operator operator);

    Buyer getByBuyerNo(Integer buyerNo);

    void updateBuyer(Buyer buyer);

    Operator getByOperatorNo(Integer operatorNo);

    void updateOperator(Operator operator);

    /*PageBean buyerPage(Integer page, Integer page1);*/

    PageBean buyerPage(Integer page, Integer pageSize, Integer buyerNo, String buyerName, Integer buyerSex, String buyerPhone);

    PageBean operatorPage(Integer page, Integer pageSize, Integer operatorNo, String operatorName, Integer operatorSex, String operatorPhone);

    void deleteBuyers(List<Integer> buyerNos);

    void deleteOperators(List<Integer> operatorNos);

    Administrator administratorLogin(Administrator administrator);
}
