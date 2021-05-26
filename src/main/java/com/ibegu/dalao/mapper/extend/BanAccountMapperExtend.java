package com.ibegu.dalao.mapper.extend;

import com.ibegu.dalao.domain.BanAccount;
import org.apache.ibatis.annotations.Param;

public interface BanAccountMapperExtend {

    public BanAccount findByMaxBannedTime(@Param("sid") Long sid);

    public BanAccount findByUid(@Param("uid") Long uid);
    public BanAccount findByUidAndUserType(@Param("uid") Long uid, @Param("user_type") Integer userType);

    public BanAccount findParticipantByMaxBannedTime(@Param("uid")Long uid);
}