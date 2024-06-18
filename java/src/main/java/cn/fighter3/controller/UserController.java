package cn.fighter3.controller;


import cn.fighter3.dto.QueryDTO;
import cn.fighter3.entity.User;
import cn.fighter3.result.Result;
import cn.fighter3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ***
 * @Description 用户管理
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @RequestMapping("/api/userst")
    public Result userList(@RequestBody QueryDTO queryDTO){
        return new Result(200,"",userService.selectUserPage(queryDTO));
    }

    /**
     * 查询当前用户信息
     * @param id
     * @return
     */
    @RequestMapping("/api/user/info")
    public Result userList(Integer id){
        return new Result(200,"",userService.selectUserInfo(id));
    }

    /**
     * 添加
     * @param user
     * @return
     */
    @RequestMapping("/api/user/add")
    public Result addUser(@RequestBody User user){
        return new Result(200,"",userService.addUser(user));
    }

    /**
     * 更新
     * @param user
     * @return
     */
    @RequestMapping("/api/user/update")
    public Result updateUser(@RequestBody User user){
        return new Result(200,"",userService.updateUser(user));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/api/user/delete")
    public Result deleteUser(Integer id){
        return new Result(200,"",userService.deleteUser(id));
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/api/user/delete/batch")
    public Result batchDeleteUser(@RequestBody List<Integer> ids){
        userService.batchDelete(ids);
        return new Result(200,"","");
    }
}