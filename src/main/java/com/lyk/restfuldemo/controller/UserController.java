package com.lyk.restfuldemo.controller;

import com.lyk.restfuldemo.bean.User;
import com.lyk.restfuldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class UserController {

//    @autowired 和 @resouce 前者是按照类型装配，就是加入一个类有两个实现类，就无法查找具体的实现类。
//    但是后者是按名称装配。  @autowired 和 @qualifier搭配使用可以和@resource一样。
//    而且前者是spring注解 而@resource是 jdk1.6后才有的注解

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String  index( User user) {
        System.out.println("hah");
        return "welcome";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean addUser( User user) {
        System.out.println("开始新增...");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean updateUser( User user) {
        System.out.println("开始更新...");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "id", required = true) int id) {
        System.out.println("开始删除...");
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/userName", method = RequestMethod.GET)
    public User findByUserName(@RequestParam(value = "userName", required = true) String userName) {
        System.out.println("开始查询...");
        return userService.findUserByName(userName);
    }

    @RequestMapping(value = "/userId", method = RequestMethod.GET)
    public User findByUserId(@RequestParam(value = "id", required = true) int id) {
        System.out.println("开始查询...");
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/userAge", method = RequestMethod.GET)
    public User findByUserAge(@RequestParam(value = "userAge", required = true) int userAge) {
        System.out.println("开始查询...");
        return userService.findUserByAge(userAge);
    }

}
