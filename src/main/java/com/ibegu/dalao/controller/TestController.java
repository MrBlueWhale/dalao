package com.ibegu.dalao.controller;

import com.ibegu.dalao.domain.Test;
import com.ibegu.dalao.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Angus Lan
 * @Date 2021/4/8 23:57
 **/

@RestController    //用来返回字符串（controll+responsebody）
// @Controller   //用来返回页面
public class TestController {

    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private TestService testService;



    /**
     * @Description: GET POST PUT DELET (查询 新增 修改 删除)
     *
     * /user?id=1
     * /user/1 (restful 风格 )
     * @return java.lang.String
     */
    // @PostMapping
    // @GetMapping
    // @PutMapping
    // @DeleteMapping
    // @RequestMapping("/hello") //默认各种请求方式都能支持
    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello(){

        return "Hello World !" + testHello;

    }

    @PostMapping("/hello/post")
    // public String helloPost(Map<String, String> map){
    public String helloPost(String name){

        return "Hello World ! Post" + name;

    }


    @GetMapping("/test/list")
    public List<Test> list(){

        return testService.list();

    }

}
