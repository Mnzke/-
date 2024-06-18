package cn.fighter3.service;

import cn.fighter3.dto.LoginDTO;
import cn.fighter3.result.Result;

/**
 * @Author: ***
 * @Description:
 **/

public interface LoginService {
    public Result login(LoginDTO loginDTO);
}