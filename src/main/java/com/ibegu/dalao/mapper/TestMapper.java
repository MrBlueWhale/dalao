package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.Test;
import com.ibegu.dalao.domain.TestExample;
import com.ibegu.dalao.mapper.extend.TestMapperExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper extends TestMapperExtend {
    long countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    Test selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);



}