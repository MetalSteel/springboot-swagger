package com.ujeat.swagger.controller;

import com.ujeat.swagger.entity.User;
import com.ujeat.swagger.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/users")
@Api(value = "用户操作相关API")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 处理/users/的GET请求,获取用户列表集合
     * @return
     */
    @ApiOperation(value = "获取用户列表集合",response = User.class,responseContainer = "List", notes = "备注:该请求为GET请求",produces = "application/json")
    @GetMapping("/")
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    /**
     * 处理/users/的POST请求,添加一个User
     * @param user
     * @return
     */
    @ApiOperation(value = "添加一个用户",notes = "备注:该请求为POST请求",produces = "application/json")
    @ApiImplicitParam(name = "user",value = "要添加的用户对象",required = true,dataType = "User")
    @PostMapping("/")
    public User postUser(@RequestBody User user){
        return userRepository.save(user);
    }

    /**
     * 处理/users/{id}的GET请求,根据id来获取User信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id获取一个用户",notes = "备注:该请求为GET请求",produces = "application/json")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "path",required = true,dataType = "Long")
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userRepository.findOne(id);
    }

    /**
     * 处理/users/的PUT请求,根据id更新User信息
     * @param user
     * @return
     */
    @ApiOperation(value = "根据用户id更新用户信息",notes = "备注:该请求为PUT请求",produces = "application/json")
    @ApiImplicitParam(name = "user",value = "用户对象信息",required = true,dataType = "User")
    @PutMapping("/")
    public User putUser(@RequestBody User user){
        return userRepository.save(user);
    }

    /**
     * 处理/users/{id}的DELETE请求,根据id删除User
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除用户信息",notes = "备注:该请求为DELETE请求")
    @ApiImplicitParam(name = "id",value = "用户编号",paramType = "path",required = true,dataType = "Long")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userRepository.delete(id);
        return "SUCCESS";
    }

}
