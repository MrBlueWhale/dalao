package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.Contest;
import com.ibegu.dalao.domain.ContestExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContestMapper {
    long countByExample(ContestExample example);

    int deleteByExample(ContestExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Contest record);

    int insertSelective(Contest record);

    List<Contest> selectByExampleWithBLOBs(ContestExample example);

    List<Contest> selectByExample(ContestExample example);

    Contest selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByExampleWithBLOBs(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByExample(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByPrimaryKeySelective(Contest record);

    int updateByPrimaryKeyWithBLOBs(Contest record);

    int updateByPrimaryKey(Contest record);
}