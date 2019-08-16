package com.xmm.biz.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminPowerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public AdminPowerExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMenuidIsNull() {
            addCriterion("menuId is null");
            return (Criteria) this;
        }

        public Criteria andMenuidIsNotNull() {
            addCriterion("menuId is not null");
            return (Criteria) this;
        }

        public Criteria andMenuidEqualTo(Long value) {
            addCriterion("menuId =", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotEqualTo(Long value) {
            addCriterion("menuId <>", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidGreaterThan(Long value) {
            addCriterion("menuId >", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidGreaterThanOrEqualTo(Long value) {
            addCriterion("menuId >=", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidLessThan(Long value) {
            addCriterion("menuId <", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidLessThanOrEqualTo(Long value) {
            addCriterion("menuId <=", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidIn(List<Long> values) {
            addCriterion("menuId in", values, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotIn(List<Long> values) {
            addCriterion("menuId not in", values, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidBetween(Long value1, Long value2) {
            addCriterion("menuId between", value1, value2, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotBetween(Long value1, Long value2) {
            addCriterion("menuId not between", value1, value2, "menuid");
            return (Criteria) this;
        }

        public Criteria andPowernameIsNull() {
            addCriterion("powerName is null");
            return (Criteria) this;
        }

        public Criteria andPowernameIsNotNull() {
            addCriterion("powerName is not null");
            return (Criteria) this;
        }

        public Criteria andPowernameEqualTo(String value) {
            addCriterion("powerName =", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotEqualTo(String value) {
            addCriterion("powerName <>", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameGreaterThan(String value) {
            addCriterion("powerName >", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameGreaterThanOrEqualTo(String value) {
            addCriterion("powerName >=", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameLessThan(String value) {
            addCriterion("powerName <", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameLessThanOrEqualTo(String value) {
            addCriterion("powerName <=", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameLike(String value) {
            addCriterion("powerName like", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotLike(String value) {
            addCriterion("powerName not like", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameIn(List<String> values) {
            addCriterion("powerName in", values, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotIn(List<String> values) {
            addCriterion("powerName not in", values, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameBetween(String value1, String value2) {
            addCriterion("powerName between", value1, value2, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotBetween(String value1, String value2) {
            addCriterion("powerName not between", value1, value2, "powername");
            return (Criteria) this;
        }

        public Criteria andPowerenumIsNull() {
            addCriterion("powerEnum is null");
            return (Criteria) this;
        }

        public Criteria andPowerenumIsNotNull() {
            addCriterion("powerEnum is not null");
            return (Criteria) this;
        }

        public Criteria andPowerenumEqualTo(String value) {
            addCriterion("powerEnum =", value, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumNotEqualTo(String value) {
            addCriterion("powerEnum <>", value, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumGreaterThan(String value) {
            addCriterion("powerEnum >", value, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumGreaterThanOrEqualTo(String value) {
            addCriterion("powerEnum >=", value, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumLessThan(String value) {
            addCriterion("powerEnum <", value, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumLessThanOrEqualTo(String value) {
            addCriterion("powerEnum <=", value, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumLike(String value) {
            addCriterion("powerEnum like", value, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumNotLike(String value) {
            addCriterion("powerEnum not like", value, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumIn(List<String> values) {
            addCriterion("powerEnum in", values, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumNotIn(List<String> values) {
            addCriterion("powerEnum not in", values, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumBetween(String value1, String value2) {
            addCriterion("powerEnum between", value1, value2, "powerenum");
            return (Criteria) this;
        }

        public Criteria andPowerenumNotBetween(String value1, String value2) {
            addCriterion("powerEnum not between", value1, value2, "powerenum");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Boolean value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Boolean value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Boolean value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Boolean value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Boolean value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Boolean> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Boolean> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Boolean value1, Boolean value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNull() {
            addCriterion("updator is null");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNotNull() {
            addCriterion("updator is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatorEqualTo(String value) {
            addCriterion("updator =", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotEqualTo(String value) {
            addCriterion("updator <>", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThan(String value) {
            addCriterion("updator >", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("updator >=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThan(String value) {
            addCriterion("updator <", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThanOrEqualTo(String value) {
            addCriterion("updator <=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLike(String value) {
            addCriterion("updator like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotLike(String value) {
            addCriterion("updator not like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIn(List<String> values) {
            addCriterion("updator in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotIn(List<String> values) {
            addCriterion("updator not in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorBetween(String value1, String value2) {
            addCriterion("updator between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotBetween(String value1, String value2) {
            addCriterion("updator not between", value1, value2, "updator");
            return (Criteria) this;
        }
    }

    /**
     */
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