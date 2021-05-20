package com.ibegu.dalao.domain;

import java.util.ArrayList;
import java.util.List;

public class AdminkeyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminkeyExample() {
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

        public Criteria andAkidIsNull() {
            addCriterion("akid is null");
            return (Criteria) this;
        }

        public Criteria andAkidIsNotNull() {
            addCriterion("akid is not null");
            return (Criteria) this;
        }

        public Criteria andAkidEqualTo(Long value) {
            addCriterion("akid =", value, "akid");
            return (Criteria) this;
        }

        public Criteria andAkidNotEqualTo(Long value) {
            addCriterion("akid <>", value, "akid");
            return (Criteria) this;
        }

        public Criteria andAkidGreaterThan(Long value) {
            addCriterion("akid >", value, "akid");
            return (Criteria) this;
        }

        public Criteria andAkidGreaterThanOrEqualTo(Long value) {
            addCriterion("akid >=", value, "akid");
            return (Criteria) this;
        }

        public Criteria andAkidLessThan(Long value) {
            addCriterion("akid <", value, "akid");
            return (Criteria) this;
        }

        public Criteria andAkidLessThanOrEqualTo(Long value) {
            addCriterion("akid <=", value, "akid");
            return (Criteria) this;
        }

        public Criteria andAkidIn(List<Long> values) {
            addCriterion("akid in", values, "akid");
            return (Criteria) this;
        }

        public Criteria andAkidNotIn(List<Long> values) {
            addCriterion("akid not in", values, "akid");
            return (Criteria) this;
        }

        public Criteria andAkidBetween(Long value1, Long value2) {
            addCriterion("akid between", value1, value2, "akid");
            return (Criteria) this;
        }

        public Criteria andAkidNotBetween(Long value1, Long value2) {
            addCriterion("akid not between", value1, value2, "akid");
            return (Criteria) this;
        }

        public Criteria andAdminKeyIsNull() {
            addCriterion("admin_key is null");
            return (Criteria) this;
        }

        public Criteria andAdminKeyIsNotNull() {
            addCriterion("admin_key is not null");
            return (Criteria) this;
        }

        public Criteria andAdminKeyEqualTo(String value) {
            addCriterion("admin_key =", value, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyNotEqualTo(String value) {
            addCriterion("admin_key <>", value, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyGreaterThan(String value) {
            addCriterion("admin_key >", value, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyGreaterThanOrEqualTo(String value) {
            addCriterion("admin_key >=", value, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyLessThan(String value) {
            addCriterion("admin_key <", value, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyLessThanOrEqualTo(String value) {
            addCriterion("admin_key <=", value, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyLike(String value) {
            addCriterion("admin_key like", value, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyNotLike(String value) {
            addCriterion("admin_key not like", value, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyIn(List<String> values) {
            addCriterion("admin_key in", values, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyNotIn(List<String> values) {
            addCriterion("admin_key not in", values, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyBetween(String value1, String value2) {
            addCriterion("admin_key between", value1, value2, "adminKey");
            return (Criteria) this;
        }

        public Criteria andAdminKeyNotBetween(String value1, String value2) {
            addCriterion("admin_key not between", value1, value2, "adminKey");
            return (Criteria) this;
        }

        public Criteria andIfUsedIsNull() {
            addCriterion("if_used is null");
            return (Criteria) this;
        }

        public Criteria andIfUsedIsNotNull() {
            addCriterion("if_used is not null");
            return (Criteria) this;
        }

        public Criteria andIfUsedEqualTo(Integer value) {
            addCriterion("if_used =", value, "ifUsed");
            return (Criteria) this;
        }

        public Criteria andIfUsedNotEqualTo(Integer value) {
            addCriterion("if_used <>", value, "ifUsed");
            return (Criteria) this;
        }

        public Criteria andIfUsedGreaterThan(Integer value) {
            addCriterion("if_used >", value, "ifUsed");
            return (Criteria) this;
        }

        public Criteria andIfUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("if_used >=", value, "ifUsed");
            return (Criteria) this;
        }

        public Criteria andIfUsedLessThan(Integer value) {
            addCriterion("if_used <", value, "ifUsed");
            return (Criteria) this;
        }

        public Criteria andIfUsedLessThanOrEqualTo(Integer value) {
            addCriterion("if_used <=", value, "ifUsed");
            return (Criteria) this;
        }

        public Criteria andIfUsedIn(List<Integer> values) {
            addCriterion("if_used in", values, "ifUsed");
            return (Criteria) this;
        }

        public Criteria andIfUsedNotIn(List<Integer> values) {
            addCriterion("if_used not in", values, "ifUsed");
            return (Criteria) this;
        }

        public Criteria andIfUsedBetween(Integer value1, Integer value2) {
            addCriterion("if_used between", value1, value2, "ifUsed");
            return (Criteria) this;
        }

        public Criteria andIfUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("if_used not between", value1, value2, "ifUsed");
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