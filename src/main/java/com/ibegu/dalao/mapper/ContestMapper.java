package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.Contest;
import com.ibegu.dalao.domain.ContestExample;
import java.util.List;

import com.ibegu.dalao.mapper.extend.ContestMappperExtend;
import org.apache.ibatis.annotations.Param;

public interface ContestMapper extends ContestMappperExtend {
    long countByExample(ContestExample example);

    int deleteByExample(ContestExample example);

    int deleteByPrimaryKey(Long cid);

    int insert(Contest record);

    int insertSelective(Contest record);

    List<Contest> selectByExampleWithBLOBs(ContestExample example);

    List<Contest> selectByExample(ContestExample example);

    Contest selectByPrimaryKey(Long cid);

    int updateByExampleSelective(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByExampleWithBLOBs(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByExample(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByPrimaryKeySelective(Contest record);

    int updateByPrimaryKeyWithBLOBs(Contest record);

    int updateByPrimaryKey(Contest record);
}