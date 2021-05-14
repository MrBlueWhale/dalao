package com.ibegu.dalao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContestExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andContestNameIsNull() {
            addCriterion("contest_name is null");
            return (Criteria) this;
        }

        public Criteria andContestNameIsNotNull() {
            addCriterion("contest_name is not null");
            return (Criteria) this;
        }

        public Criteria andContestNameEqualTo(String value) {
            addCriterion("contest_name =", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameNotEqualTo(String value) {
            addCriterion("contest_name <>", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameGreaterThan(String value) {
            addCriterion("contest_name >", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameGreaterThanOrEqualTo(String value) {
            addCriterion("contest_name >=", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameLessThan(String value) {
            addCriterion("contest_name <", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameLessThanOrEqualTo(String value) {
            addCriterion("contest_name <=", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameLike(String value) {
            addCriterion("contest_name like", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameNotLike(String value) {
            addCriterion("contest_name not like", value, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameIn(List<String> values) {
            addCriterion("contest_name in", values, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameNotIn(List<String> values) {
            addCriterion("contest_name not in", values, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameBetween(String value1, String value2) {
            addCriterion("contest_name between", value1, value2, "contestName");
            return (Criteria) this;
        }

        public Criteria andContestNameNotBetween(String value1, String value2) {
            addCriterion("contest_name not between", value1, value2, "contestName");
            return (Criteria) this;
        }

        public Criteria andSponsorIdIsNull() {
            addCriterion("sponsor_id is null");
            return (Criteria) this;
        }

        public Criteria andSponsorIdIsNotNull() {
            addCriterion("sponsor_id is not null");
            return (Criteria) this;
        }

        public Criteria andSponsorIdEqualTo(Integer value) {
            addCriterion("sponsor_id =", value, "sponsorId");
            return (Criteria) this;
        }

        public Criteria andSponsorIdNotEqualTo(Integer value) {
            addCriterion("sponsor_id <>", value, "sponsorId");
            return (Criteria) this;
        }

        public Criteria andSponsorIdGreaterThan(Integer value) {
            addCriterion("sponsor_id >", value, "sponsorId");
            return (Criteria) this;
        }

        public Criteria andSponsorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sponsor_id >=", value, "sponsorId");
            return (Criteria) this;
        }

        public Criteria andSponsorIdLessThan(Integer value) {
            addCriterion("sponsor_id <", value, "sponsorId");
            return (Criteria) this;
        }

        public Criteria andSponsorIdLessThanOrEqualTo(Integer value) {
            addCriterion("sponsor_id <=", value, "sponsorId");
            return (Criteria) this;
        }

        public Criteria andSponsorIdIn(List<Integer> values) {
            addCriterion("sponsor_id in", values, "sponsorId");
            return (Criteria) this;
        }

        public Criteria andSponsorIdNotIn(List<Integer> values) {
            addCriterion("sponsor_id not in", values, "sponsorId");
            return (Criteria) this;
        }

        public Criteria andSponsorIdBetween(Integer value1, Integer value2) {
            addCriterion("sponsor_id between", value1, value2, "sponsorId");
            return (Criteria) this;
        }

        public Criteria andSponsorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sponsor_id not between", value1, value2, "sponsorId");
            return (Criteria) this;
        }

        public Criteria andContestIntroIsNull() {
            addCriterion("contest_intro is null");
            return (Criteria) this;
        }

        public Criteria andContestIntroIsNotNull() {
            addCriterion("contest_intro is not null");
            return (Criteria) this;
        }

        public Criteria andContestIntroEqualTo(String value) {
            addCriterion("contest_intro =", value, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroNotEqualTo(String value) {
            addCriterion("contest_intro <>", value, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroGreaterThan(String value) {
            addCriterion("contest_intro >", value, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroGreaterThanOrEqualTo(String value) {
            addCriterion("contest_intro >=", value, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroLessThan(String value) {
            addCriterion("contest_intro <", value, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroLessThanOrEqualTo(String value) {
            addCriterion("contest_intro <=", value, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroLike(String value) {
            addCriterion("contest_intro like", value, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroNotLike(String value) {
            addCriterion("contest_intro not like", value, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroIn(List<String> values) {
            addCriterion("contest_intro in", values, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroNotIn(List<String> values) {
            addCriterion("contest_intro not in", values, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroBetween(String value1, String value2) {
            addCriterion("contest_intro between", value1, value2, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andContestIntroNotBetween(String value1, String value2) {
            addCriterion("contest_intro not between", value1, value2, "contestIntro");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeIsNull() {
            addCriterion("registration_start_time is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeIsNotNull() {
            addCriterion("registration_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeEqualTo(Date value) {
            addCriterion("registration_start_time =", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeNotEqualTo(Date value) {
            addCriterion("registration_start_time <>", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeGreaterThan(Date value) {
            addCriterion("registration_start_time >", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("registration_start_time >=", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeLessThan(Date value) {
            addCriterion("registration_start_time <", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("registration_start_time <=", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeIn(List<Date> values) {
            addCriterion("registration_start_time in", values, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeNotIn(List<Date> values) {
            addCriterion("registration_start_time not in", values, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeBetween(Date value1, Date value2) {
            addCriterion("registration_start_time between", value1, value2, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("registration_start_time not between", value1, value2, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeIsNull() {
            addCriterion("registration_end_time is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeIsNotNull() {
            addCriterion("registration_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeEqualTo(Date value) {
            addCriterion("registration_end_time =", value, "registrationEndTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeNotEqualTo(Date value) {
            addCriterion("registration_end_time <>", value, "registrationEndTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeGreaterThan(Date value) {
            addCriterion("registration_end_time >", value, "registrationEndTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("registration_end_time >=", value, "registrationEndTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeLessThan(Date value) {
            addCriterion("registration_end_time <", value, "registrationEndTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("registration_end_time <=", value, "registrationEndTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeIn(List<Date> values) {
            addCriterion("registration_end_time in", values, "registrationEndTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeNotIn(List<Date> values) {
            addCriterion("registration_end_time not in", values, "registrationEndTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeBetween(Date value1, Date value2) {
            addCriterion("registration_end_time between", value1, value2, "registrationEndTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("registration_end_time not between", value1, value2, "registrationEndTime");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeIsNull() {
            addCriterion("compete_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeIsNotNull() {
            addCriterion("compete_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeEqualTo(Date value) {
            addCriterion("compete_start_time =", value, "competeStartTime");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeNotEqualTo(Date value) {
            addCriterion("compete_start_time <>", value, "competeStartTime");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeGreaterThan(Date value) {
            addCriterion("compete_start_time >", value, "competeStartTime");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("compete_start_time >=", value, "competeStartTime");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeLessThan(Date value) {
            addCriterion("compete_start_time <", value, "competeStartTime");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("compete_start_time <=", value, "competeStartTime");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeIn(List<Date> values) {
            addCriterion("compete_start_time in", values, "competeStartTime");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeNotIn(List<Date> values) {
            addCriterion("compete_start_time not in", values, "competeStartTime");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeBetween(Date value1, Date value2) {
            addCriterion("compete_start_time between", value1, value2, "competeStartTime");
            return (Criteria) this;
        }

        public Criteria andCompeteStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("compete_start_time not between", value1, value2, "competeStartTime");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeIsNull() {
            addCriterion("compete_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeIsNotNull() {
            addCriterion("compete_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeEqualTo(Date value) {
            addCriterion("compete_end_time =", value, "competeEndTime");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeNotEqualTo(Date value) {
            addCriterion("compete_end_time <>", value, "competeEndTime");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeGreaterThan(Date value) {
            addCriterion("compete_end_time >", value, "competeEndTime");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("compete_end_time >=", value, "competeEndTime");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeLessThan(Date value) {
            addCriterion("compete_end_time <", value, "competeEndTime");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("compete_end_time <=", value, "competeEndTime");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeIn(List<Date> values) {
            addCriterion("compete_end_time in", values, "competeEndTime");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeNotIn(List<Date> values) {
            addCriterion("compete_end_time not in", values, "competeEndTime");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeBetween(Date value1, Date value2) {
            addCriterion("compete_end_time between", value1, value2, "competeEndTime");
            return (Criteria) this;
        }

        public Criteria andCompeteEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("compete_end_time not between", value1, value2, "competeEndTime");
            return (Criteria) this;
        }

        public Criteria andPageViewIsNull() {
            addCriterion("page_view is null");
            return (Criteria) this;
        }

        public Criteria andPageViewIsNotNull() {
            addCriterion("page_view is not null");
            return (Criteria) this;
        }

        public Criteria andPageViewEqualTo(Integer value) {
            addCriterion("page_view =", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewNotEqualTo(Integer value) {
            addCriterion("page_view <>", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewGreaterThan(Integer value) {
            addCriterion("page_view >", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_view >=", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewLessThan(Integer value) {
            addCriterion("page_view <", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewLessThanOrEqualTo(Integer value) {
            addCriterion("page_view <=", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewIn(List<Integer> values) {
            addCriterion("page_view in", values, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewNotIn(List<Integer> values) {
            addCriterion("page_view not in", values, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewBetween(Integer value1, Integer value2) {
            addCriterion("page_view between", value1, value2, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewNotBetween(Integer value1, Integer value2) {
            addCriterion("page_view not between", value1, value2, "pageView");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andEntryFeeIsNull() {
            addCriterion("entry_fee is null");
            return (Criteria) this;
        }

        public Criteria andEntryFeeIsNotNull() {
            addCriterion("entry_fee is not null");
            return (Criteria) this;
        }

        public Criteria andEntryFeeEqualTo(Integer value) {
            addCriterion("entry_fee =", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeNotEqualTo(Integer value) {
            addCriterion("entry_fee <>", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeGreaterThan(Integer value) {
            addCriterion("entry_fee >", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("entry_fee >=", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeLessThan(Integer value) {
            addCriterion("entry_fee <", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeLessThanOrEqualTo(Integer value) {
            addCriterion("entry_fee <=", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeIn(List<Integer> values) {
            addCriterion("entry_fee in", values, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeNotIn(List<Integer> values) {
            addCriterion("entry_fee not in", values, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeBetween(Integer value1, Integer value2) {
            addCriterion("entry_fee between", value1, value2, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("entry_fee not between", value1, value2, "entryFee");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("`rank` is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("`rank` is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(String value) {
            addCriterion("`rank` =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(String value) {
            addCriterion("`rank` <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(String value) {
            addCriterion("`rank` >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(String value) {
            addCriterion("`rank` >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(String value) {
            addCriterion("`rank` <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(String value) {
            addCriterion("`rank` <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLike(String value) {
            addCriterion("`rank` like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotLike(String value) {
            addCriterion("`rank` not like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<String> values) {
            addCriterion("`rank` in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<String> values) {
            addCriterion("`rank` not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(String value1, String value2) {
            addCriterion("`rank` between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(String value1, String value2) {
            addCriterion("`rank` not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andAudienceIsNull() {
            addCriterion("audience is null");
            return (Criteria) this;
        }

        public Criteria andAudienceIsNotNull() {
            addCriterion("audience is not null");
            return (Criteria) this;
        }

        public Criteria andAudienceEqualTo(String value) {
            addCriterion("audience =", value, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceNotEqualTo(String value) {
            addCriterion("audience <>", value, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceGreaterThan(String value) {
            addCriterion("audience >", value, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceGreaterThanOrEqualTo(String value) {
            addCriterion("audience >=", value, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceLessThan(String value) {
            addCriterion("audience <", value, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceLessThanOrEqualTo(String value) {
            addCriterion("audience <=", value, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceLike(String value) {
            addCriterion("audience like", value, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceNotLike(String value) {
            addCriterion("audience not like", value, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceIn(List<String> values) {
            addCriterion("audience in", values, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceNotIn(List<String> values) {
            addCriterion("audience not in", values, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceBetween(String value1, String value2) {
            addCriterion("audience between", value1, value2, "audience");
            return (Criteria) this;
        }

        public Criteria andAudienceNotBetween(String value1, String value2) {
            addCriterion("audience not between", value1, value2, "audience");
            return (Criteria) this;
        }

        public Criteria andContestStatusIsNull() {
            addCriterion("contest_status is null");
            return (Criteria) this;
        }

        public Criteria andContestStatusIsNotNull() {
            addCriterion("contest_status is not null");
            return (Criteria) this;
        }

        public Criteria andContestStatusEqualTo(Integer value) {
            addCriterion("contest_status =", value, "contestStatus");
            return (Criteria) this;
        }

        public Criteria andContestStatusNotEqualTo(Integer value) {
            addCriterion("contest_status <>", value, "contestStatus");
            return (Criteria) this;
        }

        public Criteria andContestStatusGreaterThan(Integer value) {
            addCriterion("contest_status >", value, "contestStatus");
            return (Criteria) this;
        }

        public Criteria andContestStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("contest_status >=", value, "contestStatus");
            return (Criteria) this;
        }

        public Criteria andContestStatusLessThan(Integer value) {
            addCriterion("contest_status <", value, "contestStatus");
            return (Criteria) this;
        }

        public Criteria andContestStatusLessThanOrEqualTo(Integer value) {
            addCriterion("contest_status <=", value, "contestStatus");
            return (Criteria) this;
        }

        public Criteria andContestStatusIn(List<Integer> values) {
            addCriterion("contest_status in", values, "contestStatus");
            return (Criteria) this;
        }

        public Criteria andContestStatusNotIn(List<Integer> values) {
            addCriterion("contest_status not in", values, "contestStatus");
            return (Criteria) this;
        }

        public Criteria andContestStatusBetween(Integer value1, Integer value2) {
            addCriterion("contest_status between", value1, value2, "contestStatus");
            return (Criteria) this;
        }

        public Criteria andContestStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("contest_status not between", value1, value2, "contestStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}