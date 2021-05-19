package com.ibegu.dalao.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.ibegu.dalao.domain.Contest;
import com.ibegu.dalao.domain.ContestExample;
import com.ibegu.dalao.mapper.ContestMapper;
import com.ibegu.dalao.req.ContestReq;
import com.ibegu.dalao.resp.ContestResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class ContestService {

    // @Autowired
    @Resource
    private ContestMapper contestMapper;

    public List<ContestResp> list(ContestReq req) {
        ContestExample contestExample = new ContestExample();
        ContestExample.Criteria criteria = contestExample.createCriteria();
        criteria.andContestNameLike("%"+req.getContestName()+"%");
        List<Contest> contestList = contestMapper.selectByExample(contestExample);

        //使用for循环将contest中的值赋给contestResp
        List<ContestResp> respList = new ArrayList<>();
        for (Contest contest : contestList) {
            ContestResp contestResp = new ContestResp();
            BeanUtils.copyProperties(contest,contestResp);
            //contestResp.setType("个人赛");
            respList.add(contestResp);

        }
        return respList;
    }


}
