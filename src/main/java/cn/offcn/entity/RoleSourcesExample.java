package cn.offcn.entity;

import java.util.ArrayList;
import java.util.List;

public class RoleSourcesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleSourcesExample() {
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

        public Criteria andRsidIsNull() {
            addCriterion("rsid is null");
            return (Criteria) this;
        }

        public Criteria andRsidIsNotNull() {
            addCriterion("rsid is not null");
            return (Criteria) this;
        }

        public Criteria andRsidEqualTo(Integer value) {
            addCriterion("rsid =", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidNotEqualTo(Integer value) {
            addCriterion("rsid <>", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidGreaterThan(Integer value) {
            addCriterion("rsid >", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rsid >=", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidLessThan(Integer value) {
            addCriterion("rsid <", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidLessThanOrEqualTo(Integer value) {
            addCriterion("rsid <=", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidIn(List<Integer> values) {
            addCriterion("rsid in", values, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidNotIn(List<Integer> values) {
            addCriterion("rsid not in", values, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidBetween(Integer value1, Integer value2) {
            addCriterion("rsid between", value1, value2, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidNotBetween(Integer value1, Integer value2) {
            addCriterion("rsid not between", value1, value2, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsdisIsNull() {
            addCriterion("rsdis is null");
            return (Criteria) this;
        }

        public Criteria andRsdisIsNotNull() {
            addCriterion("rsdis is not null");
            return (Criteria) this;
        }

        public Criteria andRsdisEqualTo(String value) {
            addCriterion("rsdis =", value, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisNotEqualTo(String value) {
            addCriterion("rsdis <>", value, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisGreaterThan(String value) {
            addCriterion("rsdis >", value, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisGreaterThanOrEqualTo(String value) {
            addCriterion("rsdis >=", value, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisLessThan(String value) {
            addCriterion("rsdis <", value, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisLessThanOrEqualTo(String value) {
            addCriterion("rsdis <=", value, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisLike(String value) {
            addCriterion("rsdis like", value, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisNotLike(String value) {
            addCriterion("rsdis not like", value, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisIn(List<String> values) {
            addCriterion("rsdis in", values, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisNotIn(List<String> values) {
            addCriterion("rsdis not in", values, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisBetween(String value1, String value2) {
            addCriterion("rsdis between", value1, value2, "rsdis");
            return (Criteria) this;
        }

        public Criteria andRsdisNotBetween(String value1, String value2) {
            addCriterion("rsdis not between", value1, value2, "rsdis");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Integer value) {
            addCriterion("roleid =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Integer value) {
            addCriterion("roleid <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Integer value) {
            addCriterion("roleid >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roleid >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Integer value) {
            addCriterion("roleid <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Integer value) {
            addCriterion("roleid <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Integer> values) {
            addCriterion("roleid in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Integer> values) {
            addCriterion("roleid not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Integer value1, Integer value2) {
            addCriterion("roleid between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Integer value1, Integer value2) {
            addCriterion("roleid not between", value1, value2, "roleid");
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