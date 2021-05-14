package com.ibegu.dalao.mapper;

import com.ibegu.dalao.domain.Notification;
import com.ibegu.dalao.domain.NotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotificationMapper {
    long countByExample(NotificationExample example);

    int deleteByExample(NotificationExample example);

    int deleteByPrimaryKey(Integer nid);

    int insert(Notification record);

    int insertSelective(Notification record);

    List<Notification> selectByExample(NotificationExample example);

    Notification selectByPrimaryKey(Integer nid);

    int updateByExampleSelective(@Param("record") Notification record, @Param("example") NotificationExample example);

    int updateByExample(@Param("record") Notification record, @Param("example") NotificationExample example);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);
}