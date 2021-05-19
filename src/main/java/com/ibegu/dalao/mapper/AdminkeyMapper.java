package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.Adminkey;
import com.ibegu.dalao.domain.AdminkeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminkeyMapper {
    long countByExample(AdminkeyExample example);

    int deleteByExample(AdminkeyExample example);

    int deleteByPrimaryKey(Long akid);

    int insert(Adminkey record);

    int insertSelective(Adminkey record);

    List<Adminkey> selectByExample(AdminkeyExample example);

    Adminkey selectByPrimaryKey(Long akid);

    int updateByExampleSelective(@Param("record") Adminkey record, @Param("example") AdminkeyExample example);

    int updateByExample(@Param("record") Adminkey record, @Param("example") AdminkeyExample example);

    int updateByPrimaryKeySelective(Adminkey record);

    int updateByPrimaryKey(Adminkey record);
}