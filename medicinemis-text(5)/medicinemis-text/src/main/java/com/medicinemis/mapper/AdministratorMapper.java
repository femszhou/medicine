package com.medicinemis.mapper;

import com.medicinemis.pojo.Administrator;
import com.medicinemis.pojo.Buyer;
import com.medicinemis.pojo.Operator;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdministratorMapper {

    @Select("select * from buyer")
    List<Buyer> buyerList();

    @Select("select * from operator")
    List<Operator> operatorList();

    @Delete("delete from buyer where buyer_no = #{buyerNo}")
    void deleteBuyer(Integer buyerNo);

    @Delete("delete from operator where operator_no = #{operatorNo}")
    void deleteOperator(Integer operatorNo);

    @Insert("insert into buyer(buyer_name, buyer_sex, buyer_password, buyer_phone, buyer_class, buyer_remark)" +
            "values (#{buyerName},#{buyerSex},#{buyerPassword},#{buyerPhone},#{buyerClass},#{buyerRemark})")
    void addBuyer(Buyer buyer);

    @Insert("insert into operator(operator_name, operator_sex, operator_password, operator_phone, operator_class, operator_remark) " +
            "values (#{operatorName},#{operatorSex},#{operatorPassword},#{operatorPhone},#{operatorClass},#{operatorRemark})")
    void addOperator(Operator operator);

    @Select("select * from buyer where buyer_no = #{buyerNo}")
    Buyer getByBuyerNo(Integer buyerNo);


    /*@Update("update buyer set buyer_name = #{buyerName}, buyer_sex = #{buyerSex}, buyer_password = #{buyerPassword}," +
            " buyer_phone = #{buyerPhone}, buyer_class = #{buyerClass}, buyer_remark = #{buyerRemark} where buyer_no = #{buyerNo}")*/
    void updateBuyer(Buyer buyer);

    @Select("select * from operator where operator_no = #{operatorNo}")
    Operator getByOperatorNo(Integer operatorNo);

    /*@Update("update operator set operator_name = #{operatorName}, operator_sex = #{operatorSex}, operator_password = #{operatorPassword}," +
            " operator_phone = #{operatorPhone}, operator_class = #{operatorClass}, operator_remark = #{operatorRemark} where operator_no = #{operatorNo}")*/
    void updateOperator(Operator operator);

    /*@Select("select count(*) from buyer")
    Long count();

    @Select("select * from buyer limit #{start},#{pageSize}")
    List<Buyer> buyerPage(Integer start, Integer pageSize);*/

    //@Select("select * from buyer")
    List<Buyer> buyerPage(Integer buyerNo, String buyerName, Integer buyerSex, String buyerPhone);

    /*@Select("select count(*) from operator")
    Long count();

    @Select("select * from operator limit #{start},#{pageSize}")
    List<Operator> operatorPage(Integer start,Integer pageSize);*/

    List<Operator> operatorPage(Integer operatorNo, String operatorName, Integer operatorSex, String operatorPhone);
    void deleteBuyers(List<Integer> buyerNos);

    void deleteOperators(List<Integer> operatorNos);

    @Select("select * from administrator where administrator_phone = #{administratorPhone} and administrator_password = #{administratorPassword}")
    Administrator administratorLogin(Administrator administrator);
}
