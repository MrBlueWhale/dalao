package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.Participant;
import com.ibegu.dalao.domain.ParticipantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParticipantMapper {
    long countByExample(ParticipantExample example);

    int deleteByExample(ParticipantExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Participant record);

    int insertSelective(Participant record);

    List<Participant> selectByExample(ParticipantExample example);

    Participant selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Participant record, @Param("example") ParticipantExample example);

    int updateByExample(@Param("record") Participant record, @Param("example") ParticipantExample example);

    int updateByPrimaryKeySelective(Participant record);

    int updateByPrimaryKey(Participant record);
}