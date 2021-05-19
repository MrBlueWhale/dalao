package com.ibegu.dalao.domain;

import java.util.ArrayList;
import java.util.List;

public class TeamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeamExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Long value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andContestIdIsNull() {
            addCriterion("contest_id is null");
            return (Criteria) this;
        }

        public Criteria andContestIdIsNotNull() {
            addCriterion("contest_id is not null");
            return (Criteria) this;
        }

        public Criteria andContestIdEqualTo(Long value) {
            addCriterion("contest_id =", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdNotEqualTo(Long value) {
            addCriterion("contest_id <>", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdGreaterThan(Long value) {
            addCriterion("contest_id >", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contest_id >=", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdLessThan(Long value) {
            addCriterion("contest_id <", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdLessThanOrEqualTo(Long value) {
            addCriterion("contest_id <=", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdIn(List<Long> values) {
            addCriterion("contest_id in", values, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdNotIn(List<Long> values) {
            addCriterion("contest_id not in", values, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdBetween(Long value1, Long value2) {
            addCriterion("contest_id between", value1, value2, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdNotBetween(Long value1, Long value2) {
            addCriterion("contest_id not between", value1, value2, "contestId");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNull() {
            addCriterion("team_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("team_name =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("team_name <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("team_name >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_name >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("team_name <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("team_name <=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLike(String value) {
            addCriterion("team_name like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("team_name not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List<String> values) {
            addCriterion("team_name in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List<String> values) {
            addCriterion("team_name not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("team_name between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("team_name not between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andUniNameIsNull() {
            addCriterion("uni_name is null");
            return (Criteria) this;
        }

        public Criteria andUniNameIsNotNull() {
            addCriterion("uni_name is not null");
            return (Criteria) this;
        }

        public Criteria andUniNameEqualTo(String value) {
            addCriterion("uni_name =", value, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameNotEqualTo(String value) {
            addCriterion("uni_name <>", value, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameGreaterThan(String value) {
            addCriterion("uni_name >", value, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameGreaterThanOrEqualTo(String value) {
            addCriterion("uni_name >=", value, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameLessThan(String value) {
            addCriterion("uni_name <", value, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameLessThanOrEqualTo(String value) {
            addCriterion("uni_name <=", value, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameLike(String value) {
            addCriterion("uni_name like", value, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameNotLike(String value) {
            addCriterion("uni_name not like", value, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameIn(List<String> values) {
            addCriterion("uni_name in", values, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameNotIn(List<String> values) {
            addCriterion("uni_name not in", values, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameBetween(String value1, String value2) {
            addCriterion("uni_name between", value1, value2, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniNameNotBetween(String value1, String value2) {
            addCriterion("uni_name not between", value1, value2, "uniName");
            return (Criteria) this;
        }

        public Criteria andUniAddrIsNull() {
            addCriterion("uni_addr is null");
            return (Criteria) this;
        }

        public Criteria andUniAddrIsNotNull() {
            addCriterion("uni_addr is not null");
            return (Criteria) this;
        }

        public Criteria andUniAddrEqualTo(String value) {
            addCriterion("uni_addr =", value, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrNotEqualTo(String value) {
            addCriterion("uni_addr <>", value, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrGreaterThan(String value) {
            addCriterion("uni_addr >", value, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrGreaterThanOrEqualTo(String value) {
            addCriterion("uni_addr >=", value, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrLessThan(String value) {
            addCriterion("uni_addr <", value, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrLessThanOrEqualTo(String value) {
            addCriterion("uni_addr <=", value, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrLike(String value) {
            addCriterion("uni_addr like", value, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrNotLike(String value) {
            addCriterion("uni_addr not like", value, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrIn(List<String> values) {
            addCriterion("uni_addr in", values, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrNotIn(List<String> values) {
            addCriterion("uni_addr not in", values, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrBetween(String value1, String value2) {
            addCriterion("uni_addr between", value1, value2, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andUniAddrNotBetween(String value1, String value2) {
            addCriterion("uni_addr not between", value1, value2, "uniAddr");
            return (Criteria) this;
        }

        public Criteria andZoneIsNull() {
            addCriterion("`zone` is null");
            return (Criteria) this;
        }

        public Criteria andZoneIsNotNull() {
            addCriterion("`zone` is not null");
            return (Criteria) this;
        }

        public Criteria andZoneEqualTo(String value) {
            addCriterion("`zone` =", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotEqualTo(String value) {
            addCriterion("`zone` <>", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneGreaterThan(String value) {
            addCriterion("`zone` >", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneGreaterThanOrEqualTo(String value) {
            addCriterion("`zone` >=", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLessThan(String value) {
            addCriterion("`zone` <", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLessThanOrEqualTo(String value) {
            addCriterion("`zone` <=", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLike(String value) {
            addCriterion("`zone` like", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotLike(String value) {
            addCriterion("`zone` not like", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneIn(List<String> values) {
            addCriterion("`zone` in", values, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotIn(List<String> values) {
            addCriterion("`zone` not in", values, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneBetween(String value1, String value2) {
            addCriterion("`zone` between", value1, value2, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotBetween(String value1, String value2) {
            addCriterion("`zone` not between", value1, value2, "zone");
            return (Criteria) this;
        }

        public Criteria andInstructorNameIsNull() {
            addCriterion("instructor_name is null");
            return (Criteria) this;
        }

        public Criteria andInstructorNameIsNotNull() {
            addCriterion("instructor_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstructorNameEqualTo(String value) {
            addCriterion("instructor_name =", value, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameNotEqualTo(String value) {
            addCriterion("instructor_name <>", value, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameGreaterThan(String value) {
            addCriterion("instructor_name >", value, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameGreaterThanOrEqualTo(String value) {
            addCriterion("instructor_name >=", value, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameLessThan(String value) {
            addCriterion("instructor_name <", value, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameLessThanOrEqualTo(String value) {
            addCriterion("instructor_name <=", value, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameLike(String value) {
            addCriterion("instructor_name like", value, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameNotLike(String value) {
            addCriterion("instructor_name not like", value, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameIn(List<String> values) {
            addCriterion("instructor_name in", values, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameNotIn(List<String> values) {
            addCriterion("instructor_name not in", values, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameBetween(String value1, String value2) {
            addCriterion("instructor_name between", value1, value2, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorNameNotBetween(String value1, String value2) {
            addCriterion("instructor_name not between", value1, value2, "instructorName");
            return (Criteria) this;
        }

        public Criteria andInstructorTelIsNull() {
            addCriterion("instructor_tel is null");
            return (Criteria) this;
        }

        public Criteria andInstructorTelIsNotNull() {
            addCriterion("instructor_tel is not null");
            return (Criteria) this;
        }

        public Criteria andInstructorTelEqualTo(String value) {
            addCriterion("instructor_tel =", value, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelNotEqualTo(String value) {
            addCriterion("instructor_tel <>", value, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelGreaterThan(String value) {
            addCriterion("instructor_tel >", value, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelGreaterThanOrEqualTo(String value) {
            addCriterion("instructor_tel >=", value, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelLessThan(String value) {
            addCriterion("instructor_tel <", value, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelLessThanOrEqualTo(String value) {
            addCriterion("instructor_tel <=", value, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelLike(String value) {
            addCriterion("instructor_tel like", value, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelNotLike(String value) {
            addCriterion("instructor_tel not like", value, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelIn(List<String> values) {
            addCriterion("instructor_tel in", values, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelNotIn(List<String> values) {
            addCriterion("instructor_tel not in", values, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelBetween(String value1, String value2) {
            addCriterion("instructor_tel between", value1, value2, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorTelNotBetween(String value1, String value2) {
            addCriterion("instructor_tel not between", value1, value2, "instructorTel");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailIsNull() {
            addCriterion("instructor_email is null");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailIsNotNull() {
            addCriterion("instructor_email is not null");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailEqualTo(String value) {
            addCriterion("instructor_email =", value, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailNotEqualTo(String value) {
            addCriterion("instructor_email <>", value, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailGreaterThan(String value) {
            addCriterion("instructor_email >", value, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailGreaterThanOrEqualTo(String value) {
            addCriterion("instructor_email >=", value, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailLessThan(String value) {
            addCriterion("instructor_email <", value, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailLessThanOrEqualTo(String value) {
            addCriterion("instructor_email <=", value, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailLike(String value) {
            addCriterion("instructor_email like", value, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailNotLike(String value) {
            addCriterion("instructor_email not like", value, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailIn(List<String> values) {
            addCriterion("instructor_email in", values, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailNotIn(List<String> values) {
            addCriterion("instructor_email not in", values, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailBetween(String value1, String value2) {
            addCriterion("instructor_email between", value1, value2, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorEmailNotBetween(String value1, String value2) {
            addCriterion("instructor_email not between", value1, value2, "instructorEmail");
            return (Criteria) this;
        }

        public Criteria andInstructorProfIsNull() {
            addCriterion("instructor_prof is null");
            return (Criteria) this;
        }

        public Criteria andInstructorProfIsNotNull() {
            addCriterion("instructor_prof is not null");
            return (Criteria) this;
        }

        public Criteria andInstructorProfEqualTo(String value) {
            addCriterion("instructor_prof =", value, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfNotEqualTo(String value) {
            addCriterion("instructor_prof <>", value, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfGreaterThan(String value) {
            addCriterion("instructor_prof >", value, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfGreaterThanOrEqualTo(String value) {
            addCriterion("instructor_prof >=", value, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfLessThan(String value) {
            addCriterion("instructor_prof <", value, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfLessThanOrEqualTo(String value) {
            addCriterion("instructor_prof <=", value, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfLike(String value) {
            addCriterion("instructor_prof like", value, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfNotLike(String value) {
            addCriterion("instructor_prof not like", value, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfIn(List<String> values) {
            addCriterion("instructor_prof in", values, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfNotIn(List<String> values) {
            addCriterion("instructor_prof not in", values, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfBetween(String value1, String value2) {
            addCriterion("instructor_prof between", value1, value2, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andInstructorProfNotBetween(String value1, String value2) {
            addCriterion("instructor_prof not between", value1, value2, "instructorProf");
            return (Criteria) this;
        }

        public Criteria andLeaderTelIsNull() {
            addCriterion("leader_tel is null");
            return (Criteria) this;
        }

        public Criteria andLeaderTelIsNotNull() {
            addCriterion("leader_tel is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderTelEqualTo(String value) {
            addCriterion("leader_tel =", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelNotEqualTo(String value) {
            addCriterion("leader_tel <>", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelGreaterThan(String value) {
            addCriterion("leader_tel >", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelGreaterThanOrEqualTo(String value) {
            addCriterion("leader_tel >=", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelLessThan(String value) {
            addCriterion("leader_tel <", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelLessThanOrEqualTo(String value) {
            addCriterion("leader_tel <=", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelLike(String value) {
            addCriterion("leader_tel like", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelNotLike(String value) {
            addCriterion("leader_tel not like", value, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelIn(List<String> values) {
            addCriterion("leader_tel in", values, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelNotIn(List<String> values) {
            addCriterion("leader_tel not in", values, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelBetween(String value1, String value2) {
            addCriterion("leader_tel between", value1, value2, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andLeaderTelNotBetween(String value1, String value2) {
            addCriterion("leader_tel not between", value1, value2, "leaderTel");
            return (Criteria) this;
        }

        public Criteria andMember1TelIsNull() {
            addCriterion("member1_tel is null");
            return (Criteria) this;
        }

        public Criteria andMember1TelIsNotNull() {
            addCriterion("member1_tel is not null");
            return (Criteria) this;
        }

        public Criteria andMember1TelEqualTo(String value) {
            addCriterion("member1_tel =", value, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelNotEqualTo(String value) {
            addCriterion("member1_tel <>", value, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelGreaterThan(String value) {
            addCriterion("member1_tel >", value, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelGreaterThanOrEqualTo(String value) {
            addCriterion("member1_tel >=", value, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelLessThan(String value) {
            addCriterion("member1_tel <", value, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelLessThanOrEqualTo(String value) {
            addCriterion("member1_tel <=", value, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelLike(String value) {
            addCriterion("member1_tel like", value, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelNotLike(String value) {
            addCriterion("member1_tel not like", value, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelIn(List<String> values) {
            addCriterion("member1_tel in", values, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelNotIn(List<String> values) {
            addCriterion("member1_tel not in", values, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelBetween(String value1, String value2) {
            addCriterion("member1_tel between", value1, value2, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember1TelNotBetween(String value1, String value2) {
            addCriterion("member1_tel not between", value1, value2, "member1Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelIsNull() {
            addCriterion("member2_tel is null");
            return (Criteria) this;
        }

        public Criteria andMember2TelIsNotNull() {
            addCriterion("member2_tel is not null");
            return (Criteria) this;
        }

        public Criteria andMember2TelEqualTo(String value) {
            addCriterion("member2_tel =", value, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelNotEqualTo(String value) {
            addCriterion("member2_tel <>", value, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelGreaterThan(String value) {
            addCriterion("member2_tel >", value, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelGreaterThanOrEqualTo(String value) {
            addCriterion("member2_tel >=", value, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelLessThan(String value) {
            addCriterion("member2_tel <", value, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelLessThanOrEqualTo(String value) {
            addCriterion("member2_tel <=", value, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelLike(String value) {
            addCriterion("member2_tel like", value, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelNotLike(String value) {
            addCriterion("member2_tel not like", value, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelIn(List<String> values) {
            addCriterion("member2_tel in", values, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelNotIn(List<String> values) {
            addCriterion("member2_tel not in", values, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelBetween(String value1, String value2) {
            addCriterion("member2_tel between", value1, value2, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember2TelNotBetween(String value1, String value2) {
            addCriterion("member2_tel not between", value1, value2, "member2Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelIsNull() {
            addCriterion("member3_tel is null");
            return (Criteria) this;
        }

        public Criteria andMember3TelIsNotNull() {
            addCriterion("member3_tel is not null");
            return (Criteria) this;
        }

        public Criteria andMember3TelEqualTo(String value) {
            addCriterion("member3_tel =", value, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelNotEqualTo(String value) {
            addCriterion("member3_tel <>", value, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelGreaterThan(String value) {
            addCriterion("member3_tel >", value, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelGreaterThanOrEqualTo(String value) {
            addCriterion("member3_tel >=", value, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelLessThan(String value) {
            addCriterion("member3_tel <", value, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelLessThanOrEqualTo(String value) {
            addCriterion("member3_tel <=", value, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelLike(String value) {
            addCriterion("member3_tel like", value, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelNotLike(String value) {
            addCriterion("member3_tel not like", value, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelIn(List<String> values) {
            addCriterion("member3_tel in", values, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelNotIn(List<String> values) {
            addCriterion("member3_tel not in", values, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelBetween(String value1, String value2) {
            addCriterion("member3_tel between", value1, value2, "member3Tel");
            return (Criteria) this;
        }

        public Criteria andMember3TelNotBetween(String value1, String value2) {
            addCriterion("member3_tel not between", value1, value2, "member3Tel");
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