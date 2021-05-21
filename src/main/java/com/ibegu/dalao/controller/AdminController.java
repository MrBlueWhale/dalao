package com.ibegu.dalao.controller;

import com.ibegu.dalao.req.AdminSponsorQueryReq;
import com.ibegu.dalao.req.AdminSponsorResetPasswordReq;
import com.ibegu.dalao.resp.AdminSponsorQueryResp;
import com.ibegu.dalao.resp.CommonResp;
import com.ibegu.dalao.resp.PageResp;
import com.ibegu.dalao.service.AdminService;
import org.springframework.web.bind.annotation.*;

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



    // @GetMapping("/listSponsor")
    //Controller层不出现domain实体类

    // public CommonResp list(){
    //
    //     CommonResp<List<Admin>> resp = new CommonResp<>();
    //     List<Admin> list = adminService.list();
    //     resp.setContent(list);
    //     return resp;
    //
    // }
    @GetMapping("/listSponsor")
    public CommonResp listSponsor(@Valid AdminSponsorQueryReq req){

        CommonResp<PageResp<AdminSponsorQueryResp>> resp = new CommonResp<>();
        PageResp<AdminSponsorQueryResp> list = adminService.listSponsor(req);
        resp.setContent(list);
        return resp;

    }

    @GetMapping("/getSponsorDetail")
    public CommonResp getSponsorDetail(@Valid AdminSponsorQueryReq req){

        CommonResp<AdminSponsorQueryResp> resp = new CommonResp<>();
        AdminSponsorQueryResp  sponsorDetail = adminService.getSponsorDetail(req);
        resp.setContent(sponsorDetail);
        return resp;

    }

    // @PutMapping("/resetSponsorPassword")

    @PostMapping("/resetSponsorPassword")
    public CommonResp resetSponsorPassword( @Valid @RequestBody AdminSponsorResetPasswordReq req){

        // LOG.info("请求：{}", req);

        CommonResp resp = new CommonResp<>();
        adminService.resetSponsorPassword(req);
        // resp.setContent(sponsorDetail);
        return resp;

    }


}
