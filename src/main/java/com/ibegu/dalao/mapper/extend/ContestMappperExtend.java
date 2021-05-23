package com.ibegu.dalao.mapper.extend;

import com.ibegu.dalao.domain.Contest;

import java.util.List;

public interface ContestMappperExtend {
    //根据用户id查询其参加的比赛
    List<Contest> selectPtcContestList(Long pid);
}
