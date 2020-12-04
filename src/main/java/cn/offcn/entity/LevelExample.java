package cn.offcn.entity;

import java.util.ArrayList;
import java.util.List;

public class LevelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LevelExample() {
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

        public Criteria andJidIsNull() {
            addCriterion("jid is null");
            return (Criteria) this;
        }

        public Criteria andJidIsNotNull() {
            addCriterion("jid is not null");
            return (Criteria) this;
        }

        public Criteria andJidEqualTo(Integer value) {
            addCriterion("jid =", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotEqualTo(Integer value) {
            addCriterion("jid <>", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidGreaterThan(Integer value) {
            addCriterion("jid >", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidGreaterThanOrEqualTo(Integer value) {
            addCriterion("jid >=", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLessThan(Integer value) {
            addCriterion("jid <", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLessThanOrEqualTo(Integer value) {
            addCriterion("jid <=", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidIn(List<Integer> values) {
            addCriterion("jid in", values, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotIn(List<Integer> values) {
            addCriterion("jid not in", values, "jid");
            return (Criteria) this;
        }

        public Criteria andJidBetween(Integer value1, Integer value2) {
            addCriterion("jid between", value1, value2, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotBetween(Integer value1, Integer value2) {
            addCriterion("jid not between", value1, value2, "jid");
            return (Criteria) this;
        }

        public Criteria andJnameIsNull() {
            addCriterion("jname is null");
            return (Criteria) this;
        }

        public Criteria andJnameIsNotNull() {
            addCriterion("jname is not null");
            return (Criteria) this;
        }

        public Criteria andJnameEqualTo(String value) {
            addCriterion("jname =", value, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameNotEqualTo(String value) {
            addCriterion("jname <>", value, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameGreaterThan(String value) {
            addCriterion("jname >", value, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameGreaterThanOrEqualTo(String value) {
            addCriterion("jname >=", value, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameLessThan(String value) {
            addCriterion("jname <", value, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameLessThanOrEqualTo(String value) {
            addCriterion("jname <=", value, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameLike(String value) {
            addCriterion("jname like", value, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameNotLike(String value) {
            addCriterion("jname not like", value, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameIn(List<String> values) {
            addCriterion("jname in", values, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameNotIn(List<String> values) {
            addCriterion("jname not in", values, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameBetween(String value1, String value2) {
            addCriterion("jname between", value1, value2, "jname");
            return (Criteria) this;
        }

        public Criteria andJnameNotBetween(String value1, String value2) {
            addCriterion("jname not between", value1, value2, "jname");
            return (Criteria) this;
        }

        public Criteria andJdisIsNull() {
            addCriterion("jdis is null");
            return (Criteria) this;
        }

        public Criteria andJdisIsNotNull() {
            addCriterion("jdis is not null");
            return (Criteria) this;
        }

        public Criteria andJdisEqualTo(String value) {
            addCriterion("jdis =", value, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisNotEqualTo(String value) {
            addCriterion("jdis <>", value, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisGreaterThan(String value) {
            addCriterion("jdis >", value, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisGreaterThanOrEqualTo(String value) {
            addCriterion("jdis >=", value, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisLessThan(String value) {
            addCriterion("jdis <", value, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisLessThanOrEqualTo(String value) {
            addCriterion("jdis <=", value, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisLike(String value) {
            addCriterion("jdis like", value, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisNotLike(String value) {
            addCriterion("jdis not like", value, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisIn(List<String> values) {
            addCriterion("jdis in", values, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisNotIn(List<String> values) {
            addCriterion("jdis not in", values, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisBetween(String value1, String value2) {
            addCriterion("jdis between", value1, value2, "jdis");
            return (Criteria) this;
        }

        public Criteria andJdisNotBetween(String value1, String value2) {
            addCriterion("jdis not between", value1, value2, "jdis");
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