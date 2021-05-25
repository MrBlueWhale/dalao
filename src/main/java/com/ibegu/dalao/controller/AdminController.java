package com.ibegu.dalao.controller;

import com.ibegu.dalao.req.*;
import com.ibegu.dalao.resp.*;
import com.ibegu.dalao.service.AdminService;
import com.ibegu.dalao.service.ContestService;
import com.ibegu.dalao.service.ParticipantService;
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

    @Resource
    ContestService contestService;

    @Resource
    ParticipantService participantService;



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

    @GetMapping("/listContest")
    public CommonResp listContest(@Valid AdminContestQueryReq req){

        CommonResp<PageResp<AdminContestQueryResp>> resp = new CommonResp<>();
        PageResp<AdminContestQueryResp> list = adminService.listContest(req);
        resp.setContent(list);
        return resp;

    }

    @GetMapping("/listParticipant")
    public CommonResp listParticipant(@Valid AdminParticipantQueryReq req){

        CommonResp<PageResp<AdminParticipantQueryResp>> resp = new CommonResp<>();
        PageResp<AdminParticipantQueryResp> list = adminService.listParticipant(req);
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

    @GetMapping("/getParticipantDetail")
    public CommonResp getParticipantDetail(@Valid AdminParticipantQueryReq req){

        CommonResp<AdminParticipantDetailQueryResp> resp = new CommonResp<>();
        AdminParticipantDetailQueryResp  participantDetail = adminService.getParticipantDetail(req);
        resp.setContent(participantDetail);
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

    @PostMapping("/resetParticipantPassword")
    public CommonResp resetParticipantPassword( @Valid @RequestBody AdminParticipantResetPasswordReq req){

        // LOG.info("请求：{}", req);

        CommonResp resp = new CommonResp<>();
        adminService.resetParticipantPassword(req);
        // resp.setContent(participantDetail);
        return resp;

    }




    @PostMapping("/banAccount")
    public CommonResp banAccount( @RequestBody AdminBanAccountReq req){

        // LOG.info("请求：{}", req);

        CommonResp resp = new CommonResp<>();
        adminService.banAccount(req);
        // resp.setContent(sponsorDetail);
        return resp;

    }

    @GetMapping("/viewBannedAccount/{sid}")
    public CommonResp viewBannedAccount(@PathVariable Long sid ) {

        CommonResp<AdminViewBannedAccountResp> resp = new CommonResp<>();
        AdminViewBannedAccountResp content = adminService.viewBannedAccount(sid);
        resp.setContent(content);
        return resp;

    }

    @PostMapping("/releaseAccount")
    public CommonResp releaseAccount( @RequestBody AdminReleaseAccountReq req){

        // LOG.info("请求：{}", req);

        CommonResp resp = new CommonResp<>();
        adminService.releaseAccount(req);
        // resp.setContent(sponsorDetail);
        return resp;

    }

    @GetMapping("/getContestDetail/{cid}")
    public CommonResp getContestDetail(@PathVariable Long cid ){

        CommonResp<AdminContestDetailQueryResp> resp = new CommonResp<>();
        AdminContestDetailQueryResp content = adminService.getContestDetail(cid);
        resp.setContent(content);
        return resp;

    }

    @GetMapping("/failContestAudit/{cid}")
    public CommonResp failContestAudit(@PathVariable Long cid ){

        CommonResp resp = new CommonResp<>();
        adminService.failContestAudit(cid);
        // resp.setContent(content);
        return resp;

    }

    @GetMapping("/passContestAudit/{cid}")
    public CommonResp passContestAudit(@PathVariable Long cid ){

        CommonResp resp = new CommonResp<>();
        adminService.passContestAudit(cid);
        // resp.setContent(content);
        return resp;

    }








}
