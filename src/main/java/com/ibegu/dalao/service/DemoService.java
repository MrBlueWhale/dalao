package com.ibegu.dalao.service;

import com.ibegu.dalao.domain.Demo;
import com.ibegu.dalao.mapper.DemoMapper;
import org.springframework.stereotype.Service;

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

    public List<Demo> list(){


        return demoMapper.selectByExample(null);
        // return demoMapper.selectByExample(new DemoExample());
    }



}
