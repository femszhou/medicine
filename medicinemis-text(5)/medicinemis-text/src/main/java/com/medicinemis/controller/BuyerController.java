package com.medicinemis.controller;


import com.medicinemis.sevice.BuyerService;
import com.medicinemis.pojo.Medicine;
import com.medicinemis.pojo.PageBean;
import com.medicinemis.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
@Slf4j
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    /**
     * 查找所有药物
     * @return
     */
    /*@GetMapping("/medicine")
    public Result list() {
        log.info("查找所有药物");
        List<Medicine> medicineList = buyerService.list();
        return Result.success(medicineList);
    }*/

    /**
     * 根据medicineNO查找
     *
     * @param medicineNo
     * @return
     */
    /*@DeleteMapping("/medicine/{medicineNo}")
    public Result delete(@PathVariable Integer medicineNo) {
        log.info("根据medicineNo:{}查找药物信息", medicineNo);
        buyerService.delete(medicineNo);
        return Result.success();
    }*/

    /**
     * 增加药物信息
     *
     * @param medicine
     * @return
     */
    @PostMapping("/medicine")
    public Result add(@RequestBody Medicine medicine) {
        log.info("增加药物信息:{}", medicine);
        buyerService.add(medicine);
        return Result.success();
    }

    /**
     * 根据medicineNo查询
     *
     * @param medicineNo
     * @return
     */
    @GetMapping("/medicine/{medicineNo}")
    public Result getByMedicineNo(@PathVariable Integer medicineNo) {
        log.info("根据medicineNo:{}查询", medicineNo);
        Medicine medicine = buyerService.getByMedicineNo(medicineNo);
        return Result.success(medicine);
    }

    /**
     * 修改医药信息
     *
     * @param medicine
     * @return
     */
    @PutMapping("/medicine")
    public Result update(@RequestBody Medicine medicine) {
        log.info("修改医药信息{}", medicine);
        buyerService.update(medicine);
        return Result.success();
    }

    /**
     * 药物信息分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/medicine")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Integer medicineNo, String medicineName, String medicineMode, String medicineEfficacy) {
        log.info("分页查询,参数:{},{},{},{},{},{}", page, pageSize, medicineNo, medicineName, medicineMode, medicineEfficacy);
        PageBean pageBean = buyerService.page(page, pageSize, medicineNo, medicineName, medicineMode, medicineEfficacy);
        return Result.success(pageBean);
    }

    /**
     * 批量删除
     * @param medicineNos
     * @return
     */
    @DeleteMapping("/medicine/{medicineNos}")
    public Result delete(@PathVariable List<Integer> medicineNos) {
        log.info("根据medicineNo:{}查找药物信息", medicineNos);
        buyerService.delete(medicineNos);
        return Result.success();
    }
}
