package com.ibegu.dalao.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.ibegu.dalao.domain.Contest;
import com.ibegu.dalao.domain.ContestExample;
import com.ibegu.dalao.mapper.ContestMapper;
import com.ibegu.dalao.req.ContestReq;
import com.ibegu.dalao.resp.ContestResp;
import com.ibegu.dalao.utils.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
        if(!ObjectUtils.isEmpty(req.getContestName())){
            criteria.andContestNameLike("%"+req.getContestName()+"%");
        }

        List<Contest> contestList = contestMapper.selectByExample(contestExample);

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
        List<ContestResp> list = CopyUtil.copyList(contestList, ContestResp.class);
        return list;
    }


}
