package com.medicinemis.sevice.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.medicinemis.mapper.AdministratorMapper;
import com.medicinemis.pojo.Administrator;
import com.medicinemis.sevice.AdministratorService;
import com.medicinemis.pojo.Buyer;
import com.medicinemis.pojo.Operator;
import com.medicinemis.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public List<Buyer> buyerList() {
        return administratorMapper.buyerList();
    }

    @Override
    public List<Operator> operatorList() {
        return administratorMapper.operatorList();
    }

    @Override
    public void deleteBuyer(Integer buyerNo) {
        administratorMapper.deleteBuyer(buyerNo);
    }

    @Override
    public void deleteOperator(Integer operatorNo) {
        administratorMapper.deleteOperator(operatorNo);
    }

    @Override
    public void addBuyer(Buyer buyer) {
        administratorMapper.addBuyer(buyer);
    }

    @Override
    public void addOperator(Operator operator) {
        administratorMapper.addOperator(operator);
    }

    @Override
    public Buyer getByBuyerNo(Integer buyerNo) {
        return administratorMapper.getByBuyerNo(buyerNo);
    }

    @Override
    public void updateBuyer(Buyer buyer) {
        administratorMapper.updateBuyer(buyer);
    }

    @Override
    public Operator getByOperatorNo(Integer operatorNo) {
        return administratorMapper.getByOperatorNo(operatorNo);
    }

    @Override
    public void updateOperator(Operator operator) {
        administratorMapper.updateOperator(operator);
    }

    /*@Override
    public PageBean buyerPage(Integer page, Integer pageSize) {
        //获取总记录数
        Long count = administratorMapper.count();
        //获取分页查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Buyer> buyerList = administratorMapper.buyerPage(start, pageSize);
        //封装
        PageBean pageBean = new PageBean(count,buyerList);
        return pageBean;
    }*/

    @Override
    public PageBean buyerPage(Integer page, Integer pageSize, Integer buyerNo, String buyerName, Integer buyerSex, String buyerPhone) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询
        List<Buyer> buyerList = administratorMapper.buyerPage(buyerNo, buyerName, buyerSex, buyerPhone);
        Page<Buyer> p = (Page<Buyer>) buyerList;
        //封装pageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    /*@Override
    public PageBean operatorPage(Integer page, Integer pageSize) {
        Long count = administratorMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Operator> operatorList = administratorMapper.operatorPage(start, pageSize);
        PageBean pageBean = new PageBean(count, operatorList);
        return pageBean;
    }*/
    @Override
    public PageBean operatorPage(Integer page, Integer pageSize, Integer operatorNo, String operatorName, Integer operatorSex, String operatorPhone) {
        PageHelper.startPage(page, pageSize);
        List<Operator> operatorList = administratorMapper.operatorPage(operatorNo, operatorName, operatorSex, operatorPhone);
        Page<Operator> p = (Page<Operator>) operatorList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void deleteBuyers(List<Integer> buyerNos) {
        administratorMapper.deleteBuyers(buyerNos);
    }

    @Override
    public void deleteOperators(List<Integer> operatorNos) {
        administratorMapper.deleteOperators(operatorNos);
    }

    @Override
    public Administrator administratorLogin(Administrator administrator) {
        return administratorMapper.administratorLogin(administrator);
    }
}
