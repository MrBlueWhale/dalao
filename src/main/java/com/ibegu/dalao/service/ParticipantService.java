package com.ibegu.dalao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ibegu.dalao.domain.Participant;
import com.ibegu.dalao.domain.ParticipantExample;
import com.ibegu.dalao.mapper.ParticipantMapper;
import com.ibegu.dalao.req.ParticipantReq;
import com.ibegu.dalao.resp.ParticipantResp;
import com.ibegu.dalao.resp.PageResp;
import com.ibegu.dalao.utils.CopyUtil;
import com.ibegu.dalao.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibegu.dalao.domain.Contest;
import com.ibegu.dalao.domain.ContestExample;
import com.ibegu.dalao.domain.Participant;
import com.ibegu.dalao.mapper.ContestMapper;
import com.ibegu.dalao.mapper.ParticipantMapper;
import com.ibegu.dalao.req.ContestReq;
import com.ibegu.dalao.req.ParticipantReq;
import com.ibegu.dalao.resp.ContestResp;
import com.ibegu.dalao.resp.PageResp;
import com.ibegu.dalao.resp.ParticipantResp;
import com.ibegu.dalao.utils.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ParticipantService {

    //日志
    private SnowFlake snowFlake;

    private static final Logger LOG = LoggerFactory.getLogger(ParticipantService.class);
    // @Autowired
    @Resource
    private ParticipantMapper participantMapper;

    public PageResp<ParticipantResp> list(ParticipantReq req) {

        ParticipantExample participantExample = new ParticipantExample();
        ParticipantExample.Criteria criteria = participantExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getNickname())){
            criteria.andNicknameLike("%"+req.getNickname()+"%");
        }
        //进行分页，通过前端获得的数据来确定请求的每页行数和第几页
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Participant> contestList = participantMapper.selectByExample(participantExample);
        //打印总行数和总页数
        PageInfo<Participant> pageInfo = new PageInfo<>(contestList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数:{}", pageInfo.getPages());
        //使用for循环将contest中的值赋给contestResp
//        List<ContestResp> respList = new ArrayList<>();
//        for (Contest contest : contestList) {
////            ContestResp contestResp = new ContestResp();
////            BeanUtils.copyProperties(contest,contestResp);
            //对象复制
//            ContestResp contestResp = CopyUtil.copy(contest, ContestResp.class);
//            respList.add(contestResp);
//
//        }

        //与上方被注释掉的代码等价
        List<ParticipantResp> list = CopyUtil.copyList(contestList, ParticipantResp.class);

        PageResp<ParticipantResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);



        return pageResp;
    }


    public ParticipantResp getDetail(ParticipantReq req) {

        Participant participant = participantMapper.selectByPrimaryKey(req.getPid());

        ParticipantResp participantResp = CopyUtil.copy(participant, ParticipantResp.class);

        return participantResp;
    }
    //保存
    public void save(ParticipantReq req){
        Participant participant = CopyUtil.copy(req, Participant.class);
        if(ObjectUtils.isEmpty(req.getPid())) {
            //新增
            participant.setPid(snowFlake.nextId());
            participantMapper.insert(participant);
        }else{
            //更新
            participantMapper.updateByPrimaryKey(participant);
            System.out.println("A");
        }

//    public ParticipantResp getDetail(ParticipantReq req) {
//
//       Participant participant = participantMapper.selectByPrimaryKey(req.getPid());
//
//
//        return CopyUtil.copy(participant, ParticipantResp.class);
//    }
}
}
