package com.ibegu.dalao.controller;

import com.ibegu.dalao.domain.Team;
import com.ibegu.dalao.req.DemoReq;
import com.ibegu.dalao.req.TeamReq;
import com.ibegu.dalao.resp.CommonResp;
import com.ibegu.dalao.resp.DemoResp;
import com.ibegu.dalao.service.DemoService;
import com.ibegu.dalao.service.TeamService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Angus Lan
 * @Date 2021/4/8 23:57
 **/

@RestController    //用来返回字符串（controll+responsebody）
// @Controller   //用来返回页面
@RequestMapping("/team")
public class TeamController {
    @Resource
    TeamService teamService;


    @PostMapping("/save")

    public CommonResp save(@RequestBody TeamReq req){

       CommonResp resp = new CommonResp<>();
       if(teamService.save(req)!=null){
           resp.setSuccess(false);
           resp.setMessage(teamService.save(req));
       }
       teamService.save(req);
        return resp;

    }

}
