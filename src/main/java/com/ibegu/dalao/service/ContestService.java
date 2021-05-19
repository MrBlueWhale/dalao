package com.ibegu.dalao.service;

import com.ibegu.dalao.domain.Contest;
import com.ibegu.dalao.domain.ContestExample;
import com.ibegu.dalao.mapper.ContestMapper;
//import com.ibegu.dalao.req.ContestReq;
//import com.ibegu.dalao.resp.ContestResp;
import com.ibegu.dalao.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ContestService {

    // @Autowired
    @Resource
    private ContestMapper contestMapper;

    public List<Contest> list() {


        return contestMapper.selectByExample(null);
        // return contestMapper.selectByExample(new ContestExample());
    }




}
