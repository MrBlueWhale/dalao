package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.Reply;
import com.ibegu.dalao.domain.ReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyMapper {
    long countByExample(ReplyExample example);

    int deleteByExample(ReplyExample example);

    int deleteByPrimaryKey(Long rpid);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Long rpid);

    int updateByExampleSelective(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByExample(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}