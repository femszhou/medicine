package com.medicinemis.mapper;

import com.medicinemis.pojo.Buyer;
import com.medicinemis.pojo.Medicine;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BuyerMapper {


    @Select("select * from medicine")
    List<Medicine> list();

    /*@Delete("delete from medicine where medicine_no = #{medicineNo}")
    void delete(Integer medicineNo);*/

    @Insert("insert into medicine(medicine_name, medicine_image, medicine_mode, medicine_efficacy, medicine_price, medicine_count)" +
            "values (#{medicineName}, #{medicineImage}, #{medicineMode},#{medicineEfficacy},#{medicinePrice},#{medicineCount})")
    void add(Medicine medicine);

    @Select("select * from medicine where medicine_no = #{medicineNo}")
    Medicine getByMedicineNo(Integer medicineNo);

    /*@Update("update medicine set medicine_name = #{medicineName}, medicine_mode = #{medicineMode}, medicine_efficacy = #{medicineEfficacy}," +
            " medicine_price = #{medicinePrice}, medicine_count = #{medicineCount} where medicine_no = #{medicineNo}")*/
    void update(Medicine medicine);

    /*@Select("select count(*) from medicine")
    Long count();

    @Select("select * from medicine limit #{start},#{pageSize}")
    List<Medicine> page(Integer start, Integer pageSize);*/

    List<Medicine> page(Integer medicineNo, String medicineName, String medicineMode, String medicineEfficacy);

    void delete(List<Integer> medicineNos);

    @Select("select * from buyer where buyer_phone = #{buyerPhone} and buyer_password = #{buyerPassword}")
    Buyer buyerLogin(Buyer buyer);
}
