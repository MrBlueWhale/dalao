package com.ibegu.dalao.service;

import com.ibegu.dalao.domain.Test;
import com.ibegu.dalao.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Angus Lan
 * @Date 2021/4/10 3:14
 **/

@Service
public class TestService {

    // @Autowired
    @Resource
    private TestMapper testMapper;

    public List<Test> list(){

        return testMapper.list();
    }



}
