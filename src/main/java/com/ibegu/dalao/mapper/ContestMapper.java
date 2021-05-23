package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.Contest;
import com.ibegu.dalao.domain.ContestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContestMapper {
    long countByExample(ContestExample example);

    int deleteByExample(ContestExample example);

    int deleteByPrimaryKey(Long cid);

    int insert(Contest record);

    int insertSelective(Contest record);

    List<Contest> selectByExample(ContestExample example);

    Contest selectByPrimaryKey(Long cid);

    int updateByExampleSelective(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByExample(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByPrimaryKeySelective(Contest record);

    int updateByPrimaryKey(Contest record);
}