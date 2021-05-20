package com.ibegu.dalao.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ibegu.dalao.domain.Contest;
import com.ibegu.dalao.domain.ContestExample;
import com.ibegu.dalao.mapper.ContestMapper;
import com.ibegu.dalao.req.ContestReq;
import com.ibegu.dalao.resp.ContestResp;
import com.ibegu.dalao.utils.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ContestService {

    //日志

    private static final Logger LOG = LoggerFactory.getLogger(ContestService.class);
    // @Autowired
    @Resource
    private ContestMapper contestMapper;

    public List<ContestResp> list(ContestReq req) {

        ContestExample contestExample = new ContestExample();
        ContestExample.Criteria criteria = contestExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getContestName())){
            criteria.andContestNameLike("%"+req.getContestName()+"%");
        }

        PageHelper.startPage(2,3);
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

        PageInfo<Contest> pageInfo = new PageInfo<>(contestList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数:{}", pageInfo.getPages());
        return list;
    }


}
