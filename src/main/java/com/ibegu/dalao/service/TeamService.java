package com.ibegu.dalao.service;

import com.ibegu.dalao.domain.*;
import com.ibegu.dalao.mapper.DemoMapper;
import com.ibegu.dalao.mapper.ParTeamCtsMapper;
import com.ibegu.dalao.mapper.ParticipantMapper;
import com.ibegu.dalao.mapper.TeamMapper;
import com.ibegu.dalao.req.DemoReq;
import com.ibegu.dalao.req.TeamReq;
import com.ibegu.dalao.resp.DemoResp;
import com.ibegu.dalao.utils.CopyUtil;
import com.ibegu.dalao.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Angus Lan
 * @Date 2021/4/10 3:14
 **/

@Service
public class TeamService {

    // @Autowired
    @Resource
    private TeamMapper teamMapper;
    @Resource
    private ParticipantMapper participantMapper;
    @Resource
    private ParTeamCtsMapper parTeamCtsMapper;

    @Resource
    private SnowFlake snowFlake;

    private static final Logger LOG = LoggerFactory.getLogger(TeamService.class);


    //保存前端传来的数据
    public String save(TeamReq req) {
        String str = null;
        Team team = CopyUtil.copy(req, Team.class);
        //如果已经参加该比赛，则不能再次参加
        TeamExample teamExample = new TeamExample();
        TeamExample.Criteria teamExampleCriteria = teamExample.createCriteria();
        teamExampleCriteria.andLeaderTelEqualTo(req.getLeaderTel());
        List<Team> teamList = teamMapper.selectByExample(teamExample);
        if(!teamList.isEmpty()){
            for(int i=0; i < teamList.size(); i++){
                if((req.getContestId()).equals(teamList.get(i).getContestId())){
                    str = "该队伍已参加该比赛，不能重复参加！";
                    return str;
                }
            }

        }

        //把队长参加比赛加入表ParTeamCts中
        ParticipantExample example = new ParticipantExample();
        ParticipantExample.Criteria criteria = example.createCriteria();
        criteria.andTelNumEqualTo(req.getLeaderTel());
        List<Participant> participantList = participantMapper.selectByExample(example);
        if(participantList.isEmpty()){
            str = "队长账户不存在!";
            return str;
        }
        ParTeamCts parTeamCts = new ParTeamCts();
        parTeamCts.setCid(req.getContestId());
        parTeamCts.setPid(participantList.get(0).getPid());
        LOG.info("队长{}", participantList.get(0).getPid());


        //把组员1参加比赛加入表ParTeamCts中
        ParticipantExample example1 = new ParticipantExample();
        ParticipantExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andTelNumEqualTo(req.getMember1Tel());
        participantList = participantMapper.selectByExample(example1);
        if(participantList.isEmpty()){
            str = "组员一账户不存在!";
            return str;
        }
        ParTeamCts parTeamCts1 = new ParTeamCts();
        parTeamCts1.setCid(req.getContestId());
        parTeamCts1.setPid(participantList.get(0).getPid());
        LOG.info("队员{}", participantList.get(0).getPid());


        //把组员2参加比赛加入表ParTeamCts中
        ParticipantExample example2 = new ParticipantExample();
        ParticipantExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andTelNumEqualTo(req.getMember2Tel());
        participantList = participantMapper.selectByExample(example2);
        if(participantList.isEmpty()){
            str = "组员二账户不存在!";
            return str;
        }
        ParTeamCts parTeamCts2 = new ParTeamCts();
        parTeamCts2.setCid(req.getContestId());
        parTeamCts2.setPid(participantList.get(0).getPid());


        //把组员3参加比赛加入表ParTeamCts中
        ParticipantExample example3 = new ParticipantExample();
        ParticipantExample.Criteria criteria3 = example3.createCriteria();
        criteria3.andTelNumEqualTo(req.getMember3Tel());
        participantList = participantMapper.selectByExample(example3);
        if(participantList.isEmpty()){
            str = "组员三账户不存在!";
            return str;
        }
        ParTeamCts parTeamCts3 = new ParTeamCts();
        parTeamCts3.setCid(req.getContestId());
        parTeamCts3.setPid(participantList.get(0).getPid());


        if (ObjectUtils.isEmpty(req.getTid())) {
            // 新增
            team.setTid(snowFlake.nextId());
            teamMapper.insert(team);
            LOG.info("new-teamId{}", team.getTid());

        } else {
            // 更新
            teamMapper.updateByPrimaryKey(team);
            LOG.info("update-teamId{}", team.getTid());
        }

        parTeamCts.setTid(team.getTid());
        parTeamCts1.setTid(team.getTid());
        parTeamCts2.setTid(team.getTid());
        parTeamCts3.setTid(team.getTid());
        parTeamCtsMapper.insert(parTeamCts);
        parTeamCtsMapper.insert(parTeamCts1);
        parTeamCtsMapper.insert(parTeamCts2);
        parTeamCtsMapper.insert(parTeamCts3);

        return null;
    }

}
