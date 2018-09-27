package com.lyk.restfuldemo.controller;

import com.lyk.restfuldemo.bean.User;
import com.lyk.restfuldemo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
    @RestController这个注解的作用：声明这是一个Controller类，返回json。其实就是@ResponseBody和@Controller的结合体。
     */
/*
@Api 该注解属于swagger2,该注解是将一个Class标注为一个swagger资源（API）。
在默认情况下，Swagger-Core只会扫描解析具有@Api注解的类。
 */

@Api(value = "/api",tags = "用户接口模块")
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

    @ApiOperation(value = "新增用户信息",notes = "新增用户信息",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="id",value = "ID",dataType = "Integer"),
            @ApiImplicitParam(name = "age",value = "年龄",dataType = "Integer"),
            @ApiImplicitParam(name = "name",value = "姓名",dataType = "String")
    })
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean addUser( User user) {
        System.out.println("开始新增...");
        return userService.addUser(user);
    }


    @ApiOperation(value = "更新用户信息",notes = "更新用户信息",httpMethod ="PUT" )
    @ApiImplicitParam(name = "user",value = "用户",required = true,dataType = "User")
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean updateUser( @RequestBody User user) {
        /**
         * 对于 @RequestBody  该注解的意思就是。前端传过来的只能是json字符串
         * 如果不加该注解，前端可以通过  http://localhost:8080/api/user？id=x&name=xx&age=X  这种方式进行传参
         * ajax 异步json
         */
        System.out.println("开始更新...");
        return userService.updateUser(user);
    }

    @ApiOperation(value = "删除用户信息",notes = "删除用户信息")
    @ApiImplicitParam(name = "user",value = "User",required = true,dataType = "int")
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "id", required = true) int id) {
        System.out.println("开始删除...");
        return userService.deleteUser(id);
    }

    @ApiOperation(value = "根据用户名查询用户信息",notes = "根据用户名查询用户信息")
    @RequestMapping(value = "/userName", method = RequestMethod.GET)
    public User findByUserName(@RequestParam(value = "userName", required = true) String userName) {
        System.out.println("开始查询...");
        return userService.findUserByName(userName);
    }

    @ApiOperation(value = "根据id查询用户信息",notes = "根据id查询用户信息")
    @RequestMapping(value = "/userId", method = RequestMethod.GET)
    public User findByUserId(@RequestParam(value = "id", required = true) int id) {
        System.out.println("开始查询...");
        return userService.findUserById(id);
    }

    @ApiOperation(value = "根据年龄查询用户信息",notes = "根据年龄查询用户信息")
    @RequestMapping(value = "/userAge", method = RequestMethod.GET)
    public User findByUserAge(@RequestParam(value = "userAge", required = true) int userAge) {
        System.out.println("开始查询...");
        return userService.findUserByAge(userAge);
    }

}
