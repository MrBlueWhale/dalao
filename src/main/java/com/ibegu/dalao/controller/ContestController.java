package com.ibegu.dalao.controller;

import com.ibegu.dalao.req.ContestReq;
import com.ibegu.dalao.req.ParTeamCtsReq;
import com.ibegu.dalao.resp.CommonResp;
import com.ibegu.dalao.resp.ContestResp;
import com.ibegu.dalao.resp.PageResp;
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
    public CommonResp list(ParTeamCtsReq req){
        CommonResp<PageResp<ContestResp>> resp = new CommonResp<>();
        PageResp<ContestResp> list = contestService.list(req);
        resp.setContent(list);


        return resp;

    }
    @GetMapping("/detail")
    public CommonResp getDetail(ContestReq req){
        CommonResp<ContestResp> resp = new CommonResp<>();
        ContestResp details = contestService.getDetail(req);
        resp.setContent(details);

        return resp;

    }

    @GetMapping("/contestList")
    public CommonResp getContestList(ParTeamCtsReq req){
        CommonResp<List<ContestResp>> resp= new CommonResp<>();
        List<ContestResp> list = contestService.getContestList(req);
        resp.setContent(list);

        return  resp;
    }
}
