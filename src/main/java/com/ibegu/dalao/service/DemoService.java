package com.ibegu.dalao.service;

import com.ibegu.dalao.domain.Demo;
import com.ibegu.dalao.domain.DemoExample;
import com.ibegu.dalao.mapper.DemoMapper;
import com.ibegu.dalao.req.DemoReq;
import com.ibegu.dalao.resp.DemoResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Angus Lan
 * @Date 2021/4/10 3:14
 **/

@Service
public class DemoService {

    // @Autowired
    @Resource
    private DemoMapper demoMapper;

    public List<Demo> list(){


        return demoMapper.selectByExample(null);
        // return demoMapper.selectByExample(new DemoExample());
    }

    public List<DemoResp> list(DemoReq demoReq){

        //创建查询条件 从数据库中返回
        DemoExample demoExample = new DemoExample();
        DemoExample.Criteria criteria = demoExample.createCriteria();
        criteria.andNameLike("%" + demoReq.getName() + "%");

        List<Demo> demoList = demoMapper.selectByExample(demoExample);


        //利用循环将demo封装为demoresp
        List<DemoResp> demoRespList = new ArrayList<>();
        for (Demo demo: demoList) {

            DemoResp demoResp = new DemoResp();
            BeanUtils.copyProperties(demo, demoResp);
            // demoResp.setId(123L);

            demoRespList.add(demoResp);
        }

        return demoRespList;

        // return demoMapper.selectByExample(new DemoExample());
    }



}
