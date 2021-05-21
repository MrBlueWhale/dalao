package com.ibegu.dalao.controller;

import com.ibegu.dalao.req.ParticipantReq;
import com.ibegu.dalao.resp.CommonResp;
import com.ibegu.dalao.resp.ParticipantResp;
import com.ibegu.dalao.resp.PageResp;
import com.ibegu.dalao.service.ParticipantService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController    //用来返回字符串（controll+responsebody）
// @Controller   //用来返回页面
@RequestMapping("/participant")
public class ParticipantController {
    @Resource
    private ParticipantService participantService;


    @GetMapping("/list")
    public CommonResp list(ParticipantReq req){
        CommonResp<PageResp<ParticipantResp>> resp = new CommonResp<>();
        PageResp<ParticipantResp> list = participantService.list(req);
        resp.setContent(list);


        return resp;

    }
    @GetMapping("/detail")
    public CommonResp getDetail(ParticipantReq req){
        CommonResp<ParticipantResp> resp = new CommonResp<>();
        ParticipantResp details = participantService.getDetail(req);
        resp.setContent(details);

        return resp;

    }


    @PostMapping("/save")
    //保存类与更新类都是post
    public CommonResp save(@RequestBody ParticipantReq req){
        CommonResp resp = new CommonResp<>();
        participantService.save(req);
        return resp;
    }
}
