package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.Sponsor;
import com.ibegu.dalao.domain.SponsorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SponsorMapper {
    long countByExample(SponsorExample example);

    int deleteByExample(SponsorExample example);

    int deleteByPrimaryKey(Long sid);

    int insert(Sponsor record);

    int insertSelective(Sponsor record);

    List<Sponsor> selectByExample(SponsorExample example);

    Sponsor selectByPrimaryKey(Long sid);

    int updateByExampleSelective(@Param("record") Sponsor record, @Param("example") SponsorExample example);

    int updateByExample(@Param("record") Sponsor record, @Param("example") SponsorExample example);

    int updateByPrimaryKeySelective(Sponsor record);

    int updateByPrimaryKey(Sponsor record);
}