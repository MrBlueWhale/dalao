package com.ibegu.dalao.controller;

import com.ibegu.dalao.req.AdminSponsorQueryReq;
import com.ibegu.dalao.resp.AdminSponsorQueryResp;
import com.ibegu.dalao.resp.CommonResp;
import com.ibegu.dalao.resp.PageResp;
import com.ibegu.dalao.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Description
 * @Author Angus Lan
 * @Date 2021/4/8 23:57
 **/

@RestController    //用来返回字符串（controll+responsebody）
// @Controller   //用来返回页面
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;



    @GetMapping("/listSponsor")
    //Controller层不出现domain实体类

    // public CommonResp list(){
    //
    //     CommonResp<List<Admin>> resp = new CommonResp<>();
    //     List<Admin> list = adminService.list();
    //     resp.setContent(list);
    //     return resp;
    //
    // }

    public CommonResp listSponsor(@Valid AdminSponsorQueryReq req){

        CommonResp<PageResp<AdminSponsorQueryResp>> resp = new CommonResp<>();
        PageResp<AdminSponsorQueryResp> list = adminService.listSponsor(req);
        resp.setContent(list);
        return resp;

    }

}
