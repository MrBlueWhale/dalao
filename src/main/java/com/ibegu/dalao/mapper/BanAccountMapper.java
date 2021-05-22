package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.BanAccount;
import com.ibegu.dalao.domain.BanAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BanAccountMapper {
    long countByExample(BanAccountExample example);

    int deleteByExample(BanAccountExample example);

    int deleteByPrimaryKey(Long bid);

    int insert(BanAccount record);

    int insertSelective(BanAccount record);

    List<BanAccount> selectByExample(BanAccountExample example);

    BanAccount selectByPrimaryKey(Long bid);

    int updateByExampleSelective(@Param("record") BanAccount record, @Param("example") BanAccountExample example);

    int updateByExample(@Param("record") BanAccount record, @Param("example") BanAccountExample example);

    int updateByPrimaryKeySelective(BanAccount record);

    int updateByPrimaryKey(BanAccount record);
}