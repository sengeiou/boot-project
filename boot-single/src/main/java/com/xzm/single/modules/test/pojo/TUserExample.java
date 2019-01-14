package com.xzm.single.modules.test.pojo;
import java.util.ArrayList;
import java.util.List;

public class TUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TUserExample() {
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

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
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

        public Criteria andT_idIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andT_idIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andT_idEqualTo(Integer value) {
            addCriterion("t_id =", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idNotEqualTo(Integer value) {
            addCriterion("t_id <>", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idGreaterThan(Integer value) {
            addCriterion("t_id >", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_id >=", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idLessThan(Integer value) {
            addCriterion("t_id <", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idLessThanOrEqualTo(Integer value) {
            addCriterion("t_id <=", value, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idIn(List<Integer> values) {
            addCriterion("t_id in", values, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idNotIn(List<Integer> values) {
            addCriterion("t_id not in", values, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idBetween(Integer value1, Integer value2) {
            addCriterion("t_id between", value1, value2, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_idNotBetween(Integer value1, Integer value2) {
            addCriterion("t_id not between", value1, value2, "t_id");
            return (Criteria) this;
        }

        public Criteria andT_nameIsNull() {
            addCriterion("t_name is null");
            return (Criteria) this;
        }

        public Criteria andT_nameIsNotNull() {
            addCriterion("t_name is not null");
            return (Criteria) this;
        }

        public Criteria andT_nameEqualTo(String value) {
            addCriterion("t_name =", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameNotEqualTo(String value) {
            addCriterion("t_name <>", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameGreaterThan(String value) {
            addCriterion("t_name >", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameGreaterThanOrEqualTo(String value) {
            addCriterion("t_name >=", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameLessThan(String value) {
            addCriterion("t_name <", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameLessThanOrEqualTo(String value) {
            addCriterion("t_name <=", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameLike(String value) {
            addCriterion("t_name like", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameNotLike(String value) {
            addCriterion("t_name not like", value, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameIn(List<String> values) {
            addCriterion("t_name in", values, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameNotIn(List<String> values) {
            addCriterion("t_name not in", values, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameBetween(String value1, String value2) {
            addCriterion("t_name between", value1, value2, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_nameNotBetween(String value1, String value2) {
            addCriterion("t_name not between", value1, value2, "t_name");
            return (Criteria) this;
        }

        public Criteria andT_ageIsNull() {
            addCriterion("t_age is null");
            return (Criteria) this;
        }

        public Criteria andT_ageIsNotNull() {
            addCriterion("t_age is not null");
            return (Criteria) this;
        }

        public Criteria andT_ageEqualTo(Integer value) {
            addCriterion("t_age =", value, "t_age");
            return (Criteria) this;
        }

        public Criteria andT_ageNotEqualTo(Integer value) {
            addCriterion("t_age <>", value, "t_age");
            return (Criteria) this;
        }

        public Criteria andT_ageGreaterThan(Integer value) {
            addCriterion("t_age >", value, "t_age");
            return (Criteria) this;
        }

        public Criteria andT_ageGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_age >=", value, "t_age");
            return (Criteria) this;
        }

        public Criteria andT_ageLessThan(Integer value) {
            addCriterion("t_age <", value, "t_age");
            return (Criteria) this;
        }

        public Criteria andT_ageLessThanOrEqualTo(Integer value) {
            addCriterion("t_age <=", value, "t_age");
            return (Criteria) this;
        }

        public Criteria andT_ageIn(List<Integer> values) {
            addCriterion("t_age in", values, "t_age");
            return (Criteria) this;
        }

        public Criteria andT_ageNotIn(List<Integer> values) {
            addCriterion("t_age not in", values, "t_age");
            return (Criteria) this;
        }

        public Criteria andT_ageBetween(Integer value1, Integer value2) {
            addCriterion("t_age between", value1, value2, "t_age");
            return (Criteria) this;
        }

        public Criteria andT_ageNotBetween(Integer value1, Integer value2) {
            addCriterion("t_age not between", value1, value2, "t_age");
            return (Criteria) this;
        }

        public Criteria andT_addressIsNull() {
            addCriterion("t_address is null");
            return (Criteria) this;
        }

        public Criteria andT_addressIsNotNull() {
            addCriterion("t_address is not null");
            return (Criteria) this;
        }

        public Criteria andT_addressEqualTo(String value) {
            addCriterion("t_address =", value, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressNotEqualTo(String value) {
            addCriterion("t_address <>", value, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressGreaterThan(String value) {
            addCriterion("t_address >", value, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressGreaterThanOrEqualTo(String value) {
            addCriterion("t_address >=", value, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressLessThan(String value) {
            addCriterion("t_address <", value, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressLessThanOrEqualTo(String value) {
            addCriterion("t_address <=", value, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressLike(String value) {
            addCriterion("t_address like", value, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressNotLike(String value) {
            addCriterion("t_address not like", value, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressIn(List<String> values) {
            addCriterion("t_address in", values, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressNotIn(List<String> values) {
            addCriterion("t_address not in", values, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressBetween(String value1, String value2) {
            addCriterion("t_address between", value1, value2, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_addressNotBetween(String value1, String value2) {
            addCriterion("t_address not between", value1, value2, "t_address");
            return (Criteria) this;
        }

        public Criteria andT_pwdIsNull() {
            addCriterion("t_pwd is null");
            return (Criteria) this;
        }

        public Criteria andT_pwdIsNotNull() {
            addCriterion("t_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andT_pwdEqualTo(String value) {
            addCriterion("t_pwd =", value, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdNotEqualTo(String value) {
            addCriterion("t_pwd <>", value, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdGreaterThan(String value) {
            addCriterion("t_pwd >", value, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdGreaterThanOrEqualTo(String value) {
            addCriterion("t_pwd >=", value, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdLessThan(String value) {
            addCriterion("t_pwd <", value, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdLessThanOrEqualTo(String value) {
            addCriterion("t_pwd <=", value, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdLike(String value) {
            addCriterion("t_pwd like", value, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdNotLike(String value) {
            addCriterion("t_pwd not like", value, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdIn(List<String> values) {
            addCriterion("t_pwd in", values, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdNotIn(List<String> values) {
            addCriterion("t_pwd not in", values, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdBetween(String value1, String value2) {
            addCriterion("t_pwd between", value1, value2, "t_pwd");
            return (Criteria) this;
        }

        public Criteria andT_pwdNotBetween(String value1, String value2) {
            addCriterion("t_pwd not between", value1, value2, "t_pwd");
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