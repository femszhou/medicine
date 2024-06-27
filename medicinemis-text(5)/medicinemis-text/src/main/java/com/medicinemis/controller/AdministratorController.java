package com.medicinemis.controller;

import com.medicinemis.sevice.AdministratorService;
import com.medicinemis.pojo.Buyer;
import com.medicinemis.pojo.Operator;
import com.medicinemis.pojo.PageBean;
import com.medicinemis.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
@Slf4j
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    /**
     * 查询全部采购人员
     * @return
     */
    /*@GetMapping("/buyer")
    public Result buyerList() {
        log.info("查找采购人员");
        List<Buyer> buyerList = administratorService.buyerList();
        return Result.success(buyerList);
    }*/

    /**
     * 查询全部经办人
     * @param
     * @return
     */

    /*@GetMapping("/operator")
    private Result operatorList() {
        log.info("查询经办人");
        List<Operator> operatorList = administratorService.operatorList();
        return Result.success(operatorList);
    }*/

    /**
     * 根据buyerNo删除buyer
     *
     * @param buyerNo
     * @return
     */

    /*@DeleteMapping("/buyer/{buyerNo}")
    public Result deleteBuyer(@PathVariable Integer buyerNo) {
        log.info("根据id:{}删除采购人员", buyerNo);
        administratorService.deleteBuyer(buyerNo);
        return Result.success();
    }*/

    /**
     * 根据operatorNo删除operator
     *
     * @param operatorNo
     * @return
     */
    /*@DeleteMapping("/operator/{operatorNo}")
    public Result deleteOperator(@PathVariable Integer operatorNo) {
        log.info("根据id:{}删除经办人", operatorNo);
        administratorService.deleteOperator(operatorNo);
        return Result.success();
    }*/

    /**
     * 新增采购人员buyer
     *
     * @param buyer
     * @return
     */
    @PostMapping("/buyer")
    public Result addBuyer(@RequestBody Buyer buyer) {
        log.info("新增采购人员信息:{}", buyer);
        administratorService.addBuyer(buyer);
        return Result.success();
    }

    /**
     * 新增采购人员operator
     *
     * @param operator
     * @return
     */
    @PostMapping("/operator")
    public Result addOperator(@RequestBody Operator operator) {
        log.info("新增采购人员信息:{}", operator);
        administratorService.addOperator(operator);
        return Result.success();
    }

    /**
     * 根据buyerNo查找buyer
     *
     * @param buyerNo
     * @return
     */
    @GetMapping("/buyer/{buyerNo}")
    public Result getByBuyerNo(@PathVariable Integer buyerNo) {
        log.info("根据buyerNo:{}查找", buyerNo);
        Buyer buyer = administratorService.getByBuyerNo(buyerNo);
        return Result.success(buyer);
    }

    /**
     * 修改buyer
     *
     * @param buyer
     * @return
     */
    @PutMapping("/buyer")
    public Result updateBuyer(@RequestBody Buyer buyer) {
        log.info("修改后buyer:{}", buyer);
        administratorService.updateBuyer(buyer);
        return Result.success();
    }

    /**
     * 根据operatorNo查找
     *
     * @param operatorNo
     * @return
     */
    @GetMapping("/operator/{operatorNo}")
    public Result getByOperatorNo(@PathVariable Integer operatorNo) {
        log.info("根据operatorNo:{}查找");
        Operator operator = administratorService.getByOperatorNo(operatorNo);
        return Result.success(operator);
    }

    /**
     * 修改operator
     *
     * @param operator
     * @return
     */
    @PutMapping("/operator")
    public Result updateOperator(@RequestBody Operator operator) {
        log.info("修改后operator:{}", operator);
        administratorService.updateOperator(operator);
        return Result.success();
    }

    /**
     * 分页查询buyer
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/buyer")
    public Result buyerPage(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            Integer buyerNo, String buyerName, Integer buyerSex, String buyerPhone) {
        log.info("分页查询,参数:{},{},{},{},{},{}", page, pageSize, buyerNo, buyerName, buyerSex, buyerPhone);
        PageBean pageBean = administratorService.buyerPage(page, pageSize, buyerNo, buyerName, buyerSex, buyerPhone);
        return Result.success(pageBean);
    }

    /**
     * 分页查询operator
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/operator")
    public Result operatorPage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               Integer operatorNo, String operatorName, Integer operatorSex, String operatorPhone) {
        log.info("分页查询,参数:{},{},{},{},{},{}", page, pageSize, operatorNo, operatorName, operatorSex, operatorPhone);
        PageBean pageBean = administratorService.operatorPage(page, pageSize, operatorNo, operatorName, operatorSex, operatorPhone);
        return Result.success(pageBean);
    }

    /**
     * 批量删除采购人员
     * @param buyerNos
     * @return
     */
    @DeleteMapping("/buyer/{buyerNos}")
    public Result delete(@PathVariable List<Integer> buyerNos){
        log.info("批量删除操作，buyerNos{}",buyerNos);
        administratorService.deleteBuyers(buyerNos);
        return Result.success();
    }

    /**
     * 批量删除经办人
     * @param operatorNos
     * @return
     */
    @DeleteMapping("/operator/{operatorNos}")
    public Result deleteOperator(@PathVariable List<Integer> operatorNos) {
        log.info("批量删除操作，operatorNos{}", operatorNos);
        administratorService.deleteOperators(operatorNos);
        return Result.success();
    }
}
