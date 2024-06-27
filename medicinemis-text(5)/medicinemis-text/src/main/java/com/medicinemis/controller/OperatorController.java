package com.medicinemis.controller;


import com.medicinemis.pojo.*;
import com.medicinemis.sevice.OperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
@Slf4j
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    /**
     * 查找所有订单
     * @return
     */
    /*@GetMapping("/orders")
    public Result ordersList() {
        log.info("查找所有订单");
        List<Orders> ordersList = operatorService.ordersList();
        return Result.success(ordersList);
    }*/

    /**
     * 查找所有顾客
     * @return
     */
    /*@GetMapping("/client")
    public Result clientList() {
        log.info("查找所有顾客");
        List<Client> clientList = operatorService.clientList();
        return Result.success(clientList);
    }*/

    /**
     * 增加订单
     * @param //orders
     * @return
     * @throws MyException
     */
    /*@PostMapping("/orders")
    public Result addOrders(@RequestBody Orders orders) throws MyException {
        log.info("增加订单:{}", orders);
        operatorService.addOrders(orders);
        return Result.success();
    }*/

    /**
     * 购物车增加药物
     *
     * @param medicineDTO
     * @return
     */
    @PostMapping("/shoppingCart/add")
    public Result addShoppingCart(@RequestBody MedicineDTO medicineDTO) throws MyException {
        log.info("订单增加药物:{}", medicineDTO);
        operatorService.addShoppingCart(medicineDTO);
        return Result.success();
    }

    /**
     * 购物车减少药物
     *
     * @param medicineDTO
     * @return
     */
    @DeleteMapping("/shoppingCart/sub")
    public Result subShoppingCart(@RequestBody MedicineDTO medicineDTO) {
        log.info("订单减少药物:{}", medicineDTO);
        operatorService.subShoppingCart(medicineDTO);
        return Result.success();
    }


    /**
     * 查询购物车
     *
     * @param ordersNo
     * @return
     */
    @GetMapping("/shoppingCart/list")
    public Result showShoppingCart(Integer ordersNo) {
        log.info("查询购物车：{}", ordersNo);
        List<MedicineDTO> medicineDTOList = operatorService.showShoppingCart(ordersNo);
        return Result.success(medicineDTOList);
    }

    /**
     * 查询订单
     * @param ordersNo
     * @return
     */
    /*@GetMapping("/orders")
    public Result showOrdersNo(Integer ordersNo){
        log.info("查询订单:{}",ordersNo);
        Orders orders = operatorService.showShoppingCartByOrdersNo(ordersNo);
        return Result.success(orders);
    }*/
    /**
    * 增加订单
    * @param //orders
    * @return
    * @throws MyException
    */
    @PostMapping("/orders")
    public Result addOrders(@RequestBody Orders orders){
        log.info("增加订单:{}", orders);
        Orders orders1 = operatorService.addOrders(orders);
        return Result.success(orders1);
    }

    /**
     * 根据ordersNo查找orders
     *
     * @param ordersNo
     * @return
     */
    @GetMapping("/orders/{ordersNo}")
    public Result getByOrdersNo(@PathVariable Integer ordersNo) {
        log.info("根据ordersNo:{}查找", ordersNo);
        Orders orders = operatorService.getByOrdersNo(ordersNo);
        return Result.success(orders);
    }

    /**
     * 修改订单信息
     *
     * @param orders
     * @return
     */
    @PutMapping("/orders")
    public Result updateOrders(@RequestBody Orders orders) throws MyException {
        log.info("修改订单:{}", orders);
        operatorService.updateOrders(orders);
        return Result.success();
    }

    @GetMapping("/orders")
    public Result ordersPage(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Integer ordersNo, Integer clientNo, Integer medicineNo, Integer operatorNo) {
        log.info("分页查询,参数:{},{},{},{},{},{}", page, pageSize, ordersNo, clientNo, medicineNo, operatorNo);
        PageBean pageBean = operatorService.ordersPage(page, pageSize, ordersNo, clientNo, medicineNo, operatorNo);
        return Result.success(pageBean);
    }

    /**
     * 增加顾客信息
     *
     * @param client
     * @return
     */
    @PostMapping("/client")
    public Result addClient(@RequestBody Client client) {
        log.info("增加顾客:{}", client);
        operatorService.addClient(client);
        return Result.success();
    }

    /**
     * 根据clientNo查找client
     *
     * @param clientNo
     * @return
     */
    @GetMapping("/client/{clientNo}")
    public Result getByClientNo(@PathVariable Integer clientNo) {
        log.info("根据clientNo:{}查找", clientNo);
        Client client = operatorService.getByClientNo(clientNo);
        return Result.success(client);
    }

    /**
     * 修改顾客信息
     *
     * @param client
     * @return
     */
    @PutMapping("/client")
    public Result updateClient(@RequestBody Client client) {
        log.info("修改顾客信息:{}", client);
        operatorService.updateClient(client);
        return Result.success();
    }

    @GetMapping("/client")
    public Result clientPage(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Integer clientNo, String clientName, Integer clientSex, Integer clientAge,
                             String clientAddress, String clientPhone, String clientSymptom) {
        log.info("分页查询,参数:{},{},{},{},{},{},{},{},{}", page, pageSize, clientNo, clientName, clientSex, clientAge, clientAddress, clientPhone, clientSymptom);
        PageBean pageBean = operatorService.clientPage(page, pageSize, clientNo, clientName, clientSex, clientAge, clientAddress, clientPhone, clientSymptom);
        return Result.success(pageBean);
    }
}
