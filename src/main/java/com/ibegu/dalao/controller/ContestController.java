package com.ibegu.dalao.controller;

import com.ibegu.dalao.domain.Contest;
import com.ibegu.dalao.service.ContestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController    //用来返回字符串（controll+responsebody）
// @Controller   //用来返回页面
@RequestMapping("/contest")
public class ContestController {
    @Resource
    private ContestService contestService;


    @GetMapping("/list")
    public List<Contest> list(){

        return contestService.list();

    }

}
