package com.ibegu.dalao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotificationExample() {
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

        public Criteria andNidIsNull() {
            addCriterion("nid is null");
            return (Criteria) this;
        }

        public Criteria andNidIsNotNull() {
            addCriterion("nid is not null");
            return (Criteria) this;
        }

        public Criteria andNidEqualTo(Long value) {
            addCriterion("nid =", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotEqualTo(Long value) {
            addCriterion("nid <>", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidGreaterThan(Long value) {
            addCriterion("nid >", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidGreaterThanOrEqualTo(Long value) {
            addCriterion("nid >=", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLessThan(Long value) {
            addCriterion("nid <", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLessThanOrEqualTo(Long value) {
            addCriterion("nid <=", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidIn(List<Long> values) {
            addCriterion("nid in", values, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotIn(List<Long> values) {
            addCriterion("nid not in", values, "nid");
            return (Criteria) this;
        }

        public Criteria andNidBetween(Long value1, Long value2) {
            addCriterion("nid between", value1, value2, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotBetween(Long value1, Long value2) {
            addCriterion("nid not between", value1, value2, "nid");
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

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andNotifyContentIsNull() {
            addCriterion("notify_content is null");
            return (Criteria) this;
        }

        public Criteria andNotifyContentIsNotNull() {
            addCriterion("notify_content is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyContentEqualTo(String value) {
            addCriterion("notify_content =", value, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentNotEqualTo(String value) {
            addCriterion("notify_content <>", value, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentGreaterThan(String value) {
            addCriterion("notify_content >", value, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentGreaterThanOrEqualTo(String value) {
            addCriterion("notify_content >=", value, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentLessThan(String value) {
            addCriterion("notify_content <", value, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentLessThanOrEqualTo(String value) {
            addCriterion("notify_content <=", value, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentLike(String value) {
            addCriterion("notify_content like", value, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentNotLike(String value) {
            addCriterion("notify_content not like", value, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentIn(List<String> values) {
            addCriterion("notify_content in", values, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentNotIn(List<String> values) {
            addCriterion("notify_content not in", values, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentBetween(String value1, String value2) {
            addCriterion("notify_content between", value1, value2, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andNotifyContentNotBetween(String value1, String value2) {
            addCriterion("notify_content not between", value1, value2, "notifyContent");
            return (Criteria) this;
        }

        public Criteria andPromulgatorIsNull() {
            addCriterion("promulgator is null");
            return (Criteria) this;
        }

        public Criteria andPromulgatorIsNotNull() {
            addCriterion("promulgator is not null");
            return (Criteria) this;
        }

        public Criteria andPromulgatorEqualTo(String value) {
            addCriterion("promulgator =", value, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorNotEqualTo(String value) {
            addCriterion("promulgator <>", value, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorGreaterThan(String value) {
            addCriterion("promulgator >", value, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorGreaterThanOrEqualTo(String value) {
            addCriterion("promulgator >=", value, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorLessThan(String value) {
            addCriterion("promulgator <", value, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorLessThanOrEqualTo(String value) {
            addCriterion("promulgator <=", value, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorLike(String value) {
            addCriterion("promulgator like", value, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorNotLike(String value) {
            addCriterion("promulgator not like", value, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorIn(List<String> values) {
            addCriterion("promulgator in", values, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorNotIn(List<String> values) {
            addCriterion("promulgator not in", values, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorBetween(String value1, String value2) {
            addCriterion("promulgator between", value1, value2, "promulgator");
            return (Criteria) this;
        }

        public Criteria andPromulgatorNotBetween(String value1, String value2) {
            addCriterion("promulgator not between", value1, value2, "promulgator");
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