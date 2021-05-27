package com.ibegu.dalao.controller;

import com.ibegu.dalao.req.SponsorContestQueryReq;
import com.ibegu.dalao.req.SponsorCreateContestReq;
import com.ibegu.dalao.req.SponsorModifyContestReq;
import com.ibegu.dalao.resp.CommonResp;
import com.ibegu.dalao.resp.PageResp;
import com.ibegu.dalao.resp.SponsorContestQueryResp;
import com.ibegu.dalao.service.ContestService;
import com.ibegu.dalao.service.SponsorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Description
 * @Author Angus Lan
 * @Date 2021/5/27 18:22
 **/

@RestController    //用来返回字符串（controll+responsebody）
// @Controller   //用来返回页面
@RequestMapping("/sponsor")
public class SponsorController {

    @Resource
    SponsorService sponsorService;

    @Resource
    ContestService contestService;

    // SponsorContestQueryReq

    @GetMapping("/listContest")
    public CommonResp listContest(@Valid SponsorContestQueryReq req){

        CommonResp<PageResp<SponsorContestQueryResp>> resp = new CommonResp<>();
        PageResp<SponsorContestQueryResp> list = sponsorService.listContest(req);
        resp.setContent(list);
        return resp;

    }


    // createContest
    @PostMapping("/createContest")
    public CommonResp createContest(@Valid @RequestBody SponsorCreateContestReq req){

        CommonResp resp = new CommonResp<>();
        sponsorService.createContest(req);
        // resp.setContent(list);
        return resp;

    }

    // createContest
    @PostMapping("/modifyContest")
    public CommonResp modifyContest(@Valid @RequestBody SponsorModifyContestReq req){

        CommonResp resp = new CommonResp<>();
        sponsorService.modifyContest(req);
        // resp.setContent(list);
        return resp;

    }


}
