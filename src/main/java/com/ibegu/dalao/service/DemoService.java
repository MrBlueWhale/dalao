package com.ibegu.dalao.service;

import com.ibegu.dalao.domain.Demo;
import com.ibegu.dalao.domain.DemoExample;
import com.ibegu.dalao.mapper.DemoMapper;
import com.ibegu.dalao.req.DemoReq;
import com.ibegu.dalao.resp.DemoResp;
import com.ibegu.dalao.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
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

    public List<Demo> list() {


        return demoMapper.selectByExample(null);
        // return demoMapper.selectByExample(new DemoExample());
    }

    public List<DemoResp> list(DemoReq demoReq) {

        //创建查询条件 从数据库中返回
        DemoExample demoExample = new DemoExample();
        DemoExample.Criteria criteria = demoExample.createCriteria();
        //条件查询
        if (!ObjectUtils.isEmpty(demoReq.getName())) {
            criteria.andNameLike("%" + demoReq.getName() + "%");
        }
        List<Demo> demoList = demoMapper.selectByExample(demoExample);


        //将demo封装为demoresp

        //法一：单体+循环
        // List<DemoResp> demoRespList = new ArrayList<>();
        // for (Demo demo: demoList) {
        //
        //     // DemoResp demoResp = new DemoResp();
        //     // BeanUtils.copyProperties(demo, demoResp);
        //     // // demoResp.setId(123L);
        //
        //     //单体对象复制
        //     DemoResp demoResp = CopyUtil.copy(demo, DemoResp.class);
        //
        //     demoRespList.add(demoResp);
        // }

        //法二：列表复制
        List<DemoResp> demoRespList = CopyUtil.copyList(demoList, DemoResp.class);


        return demoRespList;

        // return demoMapper.selectByExample(new DemoExample());
    }


}
