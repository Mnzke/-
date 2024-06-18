package cn.fighter3.controller;

import cn.fighter3.dto.LoginDTO;
import cn.fighter3.result.Result;
import cn.fighter3.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ***
 * @Description: TODO
 **/
@RestController()
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/api/login")
    public Result login(@RequestBody LoginDTO loginDTO){
        return loginService.login(loginDTO);
    }
}
