package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.ParTeamCts;
import com.ibegu.dalao.domain.ParTeamCtsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParTeamCtsMapper {
    long countByExample(ParTeamCtsExample example);

    int deleteByExample(ParTeamCtsExample example);

    int deleteByPrimaryKey(@Param("pid") Long pid, @Param("tid") Long tid, @Param("cid") Long cid);

    int insert(ParTeamCts record);

    int insertSelective(ParTeamCts record);

    List<ParTeamCts> selectByExample(ParTeamCtsExample example);

    int updateByExampleSelective(@Param("record") ParTeamCts record, @Param("example") ParTeamCtsExample example);

    int updateByExample(@Param("record") ParTeamCts record, @Param("example") ParTeamCtsExample example);
}