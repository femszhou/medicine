package com.medicinemis.controller;

import com.medicinemis.pojo.Administrator;
import com.medicinemis.pojo.Buyer;
import com.medicinemis.pojo.Operator;
import com.medicinemis.pojo.Result;
import com.medicinemis.sevice.AdministratorService;
import com.medicinemis.sevice.BuyerService;
import com.medicinemis.sevice.OperatorService;
import com.medicinemis.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
//@RequestMapping("/api")
@RestController
public class LoginController {
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private OperatorService operatorService;

    /**
     * 管理员登录
     * @param administrator
     * @return
     */
    @PostMapping("/administratorLogin")
    public Result administratorLogin(@RequestBody Administrator administrator) {
        log.info("登录administrator:{}", administrator);
        Administrator a = administratorService.administratorLogin(administrator);

        if (a != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("no", a.getAdministratorNo());
            claims.put("phone", a.getAdministratorPhone());
            claims.put("password", a.getAdministratorPassword());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

    /**
     * 采购人员登录
     * @param buyer
     * @return
     */
    @PostMapping("/buyerLogin")
    public Result buyerLogin(@RequestBody Buyer buyer) {
        log.info("登录buyer:{}", buyer);
        Buyer b = buyerService.buyerLogin(buyer);

        if (b != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("no", b.getBuyerNo());
            claims.put("phone", b.getBuyerPhone());
            claims.put("password", b.getBuyerPassword());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

    /**
     * 经办人登录
     * @param operator
     * @return
     */
    @PostMapping("/operatorLogin")
    public Result operatorLogin(@RequestBody Operator operator) {
        log.info("登录buyer:{}", operator);
        Operator o = operatorService.operatorLogin(operator);

        if (o != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("no", o.getOperatorNo());
            claims.put("phone", o.getOperatorPhone());
            claims.put("password", o.getOperatorPassword());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
