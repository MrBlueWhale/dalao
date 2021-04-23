package com.ibegu.dalao.controller;

import com.ibegu.dalao.req.DemoReq;
import com.ibegu.dalao.resp.CommonResp;
import com.ibegu.dalao.resp.DemoResp;
import com.ibegu.dalao.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/demo")
public class DemoController {
    @Resource
    DemoService demoService;



    @GetMapping("/list")
    //Controller层不出现domain实体类

    // public CommonResp list(){
    //
    //     CommonResp<List<Demo>> resp = new CommonResp<>();
    //     List<Demo> list = demoService.list();
    //     resp.setContent(list);
    //     return resp;
    //
    // }

    public CommonResp list(DemoReq demoReq){

        CommonResp<List<DemoResp>> resp = new CommonResp<>();
        List<DemoResp> list = demoService.list(demoReq);
        resp.setContent(list);
        return resp;

    }

}
