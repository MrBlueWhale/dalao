package com.ibegu.dalao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ibegu.dalao.domain.*;
import com.ibegu.dalao.mapper.*;
import com.ibegu.dalao.req.*;
import com.ibegu.dalao.resp.*;
import com.ibegu.dalao.utils.CopyUtil;
import com.ibegu.dalao.utils.DateUtil;
import com.ibegu.dalao.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author Angus Lan
 * @Date 2021/4/10 3:14
 **/

@Service
public class SponsorService {

    private static final Logger LOG = LoggerFactory.getLogger(SponsorService.class);
    // private static final Logger LOGSponsor = LoggerFactory.getLogger(SponsorService.class);


    // @Autowired
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private SponsorMapper sponsorMapper;
    @Resource
    private BanAccountMapper banAccountMapper;
    @Resource
    private ContestMapper contestMapper;
    @Resource
    private ParticipantMapper participantMapper;

    @Resource
    private SnowFlake snowFlake;



    public AdminSponsorQueryResp getSponsorDetail(AdminSponsorQueryReq req) {
        Sponsor sponsorDetail = sponsorMapper.selectByPrimaryKey(req.getSid());

        AdminSponsorQueryResp sponsorDetailResp = CopyUtil.copy(sponsorDetail, AdminSponsorQueryResp.class);

        return sponsorDetailResp;

    }

    public void banAccount(AdminBanAccountReq req) {

        if(ObjectUtils.isEmpty(req.getUserType())){

            //如果没有用户类型参数 则默认为主办方 实则为0
            //更新被封禁账户的账户状态
            Long sponsorId = req.getUid();
            Sponsor sponsor = sponsorMapper.selectByPrimaryKey(sponsorId);
            sponsor.setAccountStatus(1);
            sponsorMapper.updateByPrimaryKey(sponsor);
        }else{
            //用户类型为1（参赛者）
            //更新被封禁账户的账户状态
            Long participantId = req.getUid();
            Participant participant = participantMapper.selectByPrimaryKey(participantId);
            participant.setAccountStatus(1);
            participantMapper.updateByPrimaryKey(participant);

        }

    //    更新封禁表

        BanAccount banAccount = CopyUtil.copy(req, BanAccount.class);

        banAccount.setBid(snowFlake.nextId());
        banAccount.setUid(req.getUid());
        banAccount.setBanType((req.getBanType()).toString());
        banAccount.setUserType(ObjectUtils.isEmpty(req.getUserType()) ? 1 : 0 );

        LOG.info("banAccount:{}", banAccount);

        banAccountMapper.insert(banAccount);


        // Ebook ebook = CopyUtil.copy(req, Ebook.class);
        // if (ObjectUtils.isEmpty(req.getId())) {
        //     // 新增
        //     ebook.setId(snowFlake.nextId());
        //     ebookMapper.insert(ebook);
        // } else {
        //     // 更新
        //     ebookMapper.updateByPrimaryKey(ebook);
        // }



    }


    public void releaseAccount(AdminReleaseAccountReq req) {

//更新被封禁账户的账户状态

        Integer userType = (ObjectUtils.isEmpty(req.getUserType())) ? 1 : 0;
        LOG.info("userType:{}-{}", userType, userType.getClass());
        BanAccount banAccount = banAccountMapper.findByUidAndUserType(req.getUid(), userType);


        LOG.info("banAccount:{}-{}", banAccount, banAccount.getClass());

        ArrayList<String> banTypesOld = new ArrayList<String>(Arrays.asList(banAccount.getBanType().replace("[","").replace("]","").split(", ")));
        LOG.info("banTypesOld:{}-{}", banTypesOld, banTypesOld.getClass());
        ArrayList<String> releaseBanTypes = req.getBanType();
        LOG.info("releaseBanTypes:{}-{}", releaseBanTypes, releaseBanTypes.getClass());
        banTypesOld.removeAll(releaseBanTypes);
        LOG.info("banTypesOld:{}-{}", banTypesOld, banTypesOld.getClass());
        String banTypesUpdate = banTypesOld.toString();
        LOG.info("banTypesUpdate:{}-{}-{}", banTypesUpdate, banTypesUpdate.getClass(),ObjectUtils.isEmpty(banTypesOld));



        // ArrayList<String> bantypes = req.getBanType();
        String bantypes = req.getBanType().toString();
        LOG.info("banType1Old:{}-{}", banAccount.getBanType(), banAccount.getBanType().getClass());

        LOG.info("banType2New:{}-{}", bantypes, bantypes.getClass());
        LOG.info("banType3:{}-{}", req.getBanType(), req.getBanType().getClass());

        if(ObjectUtils.isEmpty(banTypesOld)){
            if(userType == 1){
                //没有用户类型参数 默认为主办方---1

                Sponsor sponsor = sponsorMapper.selectByPrimaryKey(req.getUid());
                sponsor.setAccountStatus(0);
                sponsorMapper.updateByPrimaryKey(sponsor);

            }else{
                //    参赛者--用户类型为---0
                Participant participant = participantMapper.selectByPrimaryKey(req.getUid());
                participant.setAccountStatus(0);
                participantMapper.updateByPrimaryKey(participant);

            }

        }


        // BanAccount banAccount = banAccountMapper.findByUid(req.getUid());



        //    更新封禁表

        BanAccount banAccountUpdate = CopyUtil.copy(req, BanAccount.class);

        banAccountUpdate.setBid(snowFlake.nextId());
        banAccountUpdate.setReason(banAccount.getReason());
        banAccountUpdate.setBannedtime(banAccount.getBannedtime());
        // banAccountUpdate.setNote(req.getNote());
        banAccountUpdate.setUserType(userType);
        banAccountUpdate.setBanType(banTypesUpdate);
        // banAccount.setUserType(1);

        LOG.info("banAccountUpdate:{}", banAccountUpdate);

        banAccountMapper.insert(banAccountUpdate);



    }


    public AdminContestDetailQueryResp getContestDetail(Long cid) {

        Contest contest = contestMapper.selectByPrimaryKey(cid);

        AdminContestDetailQueryResp content = CopyUtil.copy(contest, AdminContestDetailQueryResp.class);

        Long sponsorId = contest.getSponsorId();

        Sponsor sponsor = sponsorMapper.selectByPrimaryKey(sponsorId);

        content.setSponsorName(sponsor.getName());
        content.setSponsorAvatar(sponsor.getAvatar());

        // 格式化时间
        content.setRegistrationStartTime(DateUtil.formatDateTime(contest.getRegistrationStartTime()));
        content.setRegistrationEndTime(DateUtil.formatDateTime(contest.getRegistrationEndTime()));
        content.setCompeteStartTime(DateUtil.formatDateTime(contest.getCompeteStartTime()));
        content.setCompeteEndTime(DateUtil.formatDateTime(contest.getCompeteEndTime()));


        return content;
    }

    public void failContestAudit(Long cid) {
        Contest contest = contestMapper.selectByPrimaryKey(cid);
        contest.setContestStatus(9);
        contestMapper.updateByPrimaryKey(contest);
    }

    public void passContestAudit(Long cid) {
        Contest contest = contestMapper.selectByPrimaryKey(cid);
        contest.setContestStatus(1);
        contestMapper.updateByPrimaryKey(contest);
    }


    public void createContest(SponsorCreateContestReq req) {

        // Contest contest = new Contest();
        Contest contest = CopyUtil.copy(req,Contest.class);
        LOG.info("new contest: {}", contest);

        contest.setCid(snowFlake.nextId());
        contest.setPageView(0);

        contestMapper.insert(contest);

    }

    public PageResp<SponsorContestQueryResp> listContest(SponsorContestQueryReq req) {
        //创建查询条件 从数据库中返回
        ContestExample contestExample = new ContestExample();
        ContestExample.Criteria criteria = contestExample.createCriteria();
        //动态条件查询
        if (!ObjectUtils.isEmpty(req.getContestName())) {
            criteria.andContestNameLike("%" + req.getContestName() + "%");
        }
        if (!ObjectUtils.isEmpty(req.getRegistrationStartTime())) {
            criteria.andRegistrationStartTimeGreaterThanOrEqualTo(req.getRegistrationStartTime());
        }
        if (!ObjectUtils.isEmpty(req.getRegistrationEndTime())) {
            criteria.andRegistrationEndTimeLessThanOrEqualTo(req.getRegistrationEndTime());
        }

        if (!ObjectUtils.isEmpty(req.getType())) {
            criteria.andTypeEqualTo(req.getType());
        }

        if (!ObjectUtils.isEmpty(req.getCategory())) {
            criteria.andCategoryEqualTo(req.getCategory());
        }

        if (!ObjectUtils.isEmpty(req.getRank())) {
            criteria.andRankEqualTo(req.getRank());
        }
        if (!ObjectUtils.isEmpty(req.getContestStatus())) {
            criteria.andContestStatusEqualTo(req.getContestStatus());
        }if (!ObjectUtils.isEmpty(req.getSponsorId())){
            criteria.andSponsorIdEqualTo(req.getSponsorId());
        }



        //只对遇到的第一句sql起作用 最好放在一起
        //查第几页 多少条
        PageHelper.startPage(req.getPage(), req.getSize());

        List<Contest> contestList = contestMapper.selectByExample(contestExample);

        PageInfo<Contest> pageInfo = new PageInfo<>(contestList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        //法二：列表复制
        List<SponsorContestQueryResp> adminRespList = CopyUtil.copyList(contestList, SponsorContestQueryResp.class);

        //往这里面添加参数再返回即可
        PageResp<SponsorContestQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(adminRespList);


        return pageResp;

    }

    public void modifyContest(SponsorModifyContestReq req) {

        // Contest contest = new Contest();
        Contest contest = CopyUtil.copy(req,Contest.class);
        LOG.info("new contest: {}", contest);

        contest.setContestStatus(0);

        // contest.setCid(snowFlake.nextId());
        contest.setPageView(0);

        contestMapper.updateByPrimaryKey(contest);

    }
}
