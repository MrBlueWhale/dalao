package com.ibegu.dalao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ibegu.dalao.domain.*;
import com.ibegu.dalao.mapper.AdminMapper;
import com.ibegu.dalao.mapper.BanAccountMapper;
import com.ibegu.dalao.mapper.SponsorMapper;
import com.ibegu.dalao.req.AdminBanAccountReq;
import com.ibegu.dalao.req.AdminSponsorQueryReq;
import com.ibegu.dalao.req.AdminSponsorResetPasswordReq;
import com.ibegu.dalao.resp.AdminSponsorQueryResp;
import com.ibegu.dalao.resp.AdminViewBannedAccountResp;
import com.ibegu.dalao.resp.PageResp;
import com.ibegu.dalao.utils.CopyUtil;
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
public class AdminService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminService.class);
    // private static final Logger LOGSponsor = LoggerFactory.getLogger(SponsorService.class);


    // @Autowired
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private SponsorMapper sponsorMapper;
    @Resource
    private BanAccountMapper banAccountMapper;

    @Resource
    private SnowFlake snowFlake;

    public List<Admin> list() {


        return adminMapper.selectByExample(null);
        // return adminMapper.selectByExample(new AdminExample());
    }

    public PageResp<AdminSponsorQueryResp> listSponsor(AdminSponsorQueryReq req) {

        //创建查询条件 从数据库中返回
        SponsorExample sponsorExample = new SponsorExample();
        SponsorExample.Criteria criteria = sponsorExample.createCriteria();
        //动态条件查询
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }

        if (!ObjectUtils.isEmpty(req.getIdentityStatus())) {
            criteria.andIdentityStatusEqualTo(req.getIdentityStatus());
        }

        //只对遇到的第一句sql起作用 最好放在一起
        //查第几页 多少条
        PageHelper.startPage(req.getPage(), req.getSize());

        List<Sponsor> sponsorList = sponsorMapper.selectByExample(sponsorExample);

        PageInfo<Sponsor> pageInfo = new PageInfo<>(sponsorList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        //法二：列表复制
        List<AdminSponsorQueryResp> adminRespList = CopyUtil.copyList(sponsorList, AdminSponsorQueryResp.class);

        //往这里面添加参数再返回即可
        PageResp<AdminSponsorQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(adminRespList);


        return pageResp;

        // return adminMapper.selectByExample(new AdminExample());
    }


    public AdminSponsorQueryResp getSponsorDetail(AdminSponsorQueryReq req) {
        Sponsor sponsorDetail = sponsorMapper.selectByPrimaryKey(req.getSid());

        AdminSponsorQueryResp sponsorDetailResp = CopyUtil.copy(sponsorDetail, AdminSponsorQueryResp.class);

        return sponsorDetailResp;

    }

    public void resetSponsorPassword(AdminSponsorResetPasswordReq req) {

        LOG.info("修改密码传入的请求参数：{}", req);

        Sponsor sponsor = CopyUtil.copy(req, Sponsor.class);
        // sponsor.setSid(req.getSid());
        sponsor.setPassword(req.getPassword());

        sponsorMapper.updateByPrimaryKeySelective(sponsor);
    }

    public void banAccount(AdminBanAccountReq req) {

        //更新被封禁账户的账户状态
        Long sponsorId = req.getUid();
        Sponsor sponsor = sponsorMapper.selectByPrimaryKey(sponsorId);
        sponsor.setAccountStatus(1);
        sponsorMapper.updateByPrimaryKey(sponsor);

    //    更新封禁表

        BanAccount banAccount = CopyUtil.copy(req, BanAccount.class);

        banAccount.setBid(snowFlake.nextId());
        banAccount.setUid(req.getUid());
        banAccount.setBanType((req.getBanType()).toString());
        banAccount.setUserType(1);

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

    public AdminViewBannedAccountResp viewBannedAccount(Long sid) {

        BanAccountExample banAccountExample = new BanAccountExample();
        BanAccountExample.Criteria criteria = banAccountExample.createCriteria();

        LOG.info("content:{}", (ObjectUtils.isEmpty(sid)));

        // if (!ObjectUtils.isEmpty(sid)) {
        //     criteria.andUidEqualTo(sid);
        //     criteria.andBannedtimeGreaterThanOrEqualTo(banAccountMapper.findByMaxBannedTime());
        // }

        BanAccount banAccount = banAccountMapper.findByMaxBannedTime(sid);
        AdminViewBannedAccountResp content = CopyUtil.copy(banAccount, AdminViewBannedAccountResp.class);

        LOG.info("banAccount:{}", banAccount);
        LOG.info("banType1:{}", banAccount.getBanType());
        String banType = banAccount.getBanType().replace("[","").replace("]","");
        LOG.info("banType2:{}", banType.split(","));
        LOG.info("banType3:{}", new ArrayList<String>(Arrays.asList(banType.split(","))));

        content.setBanType(new ArrayList<String>(Arrays.asList(banType.split(", "))));

        LOG.info("content:{}", content);


        return content;
        // return null;
    }
}
