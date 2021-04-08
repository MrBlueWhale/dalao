package com.ibegu.dalao.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author Angus Lan
 * @Date 2021/4/8 23:57
 **/

@RestController    //用来返回字符串（controll+responsebody）
// @Controller   //用来返回页面
public class TestController {


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

        return "Hello World !";

    }

}
