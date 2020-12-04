package cn.offcn.entity;

import java.util.ArrayList;
import java.util.List;

public class ComparisonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComparisonExample() {
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

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andTurnonverIsNull() {
            addCriterion("turnonver is null");
            return (Criteria) this;
        }

        public Criteria andTurnonverIsNotNull() {
            addCriterion("turnonver is not null");
            return (Criteria) this;
        }

        public Criteria andTurnonverEqualTo(Double value) {
            addCriterion("turnonver =", value, "turnonver");
            return (Criteria) this;
        }

        public Criteria andTurnonverNotEqualTo(Double value) {
            addCriterion("turnonver <>", value, "turnonver");
            return (Criteria) this;
        }

        public Criteria andTurnonverGreaterThan(Double value) {
            addCriterion("turnonver >", value, "turnonver");
            return (Criteria) this;
        }

        public Criteria andTurnonverGreaterThanOrEqualTo(Double value) {
            addCriterion("turnonver >=", value, "turnonver");
            return (Criteria) this;
        }

        public Criteria andTurnonverLessThan(Double value) {
            addCriterion("turnonver <", value, "turnonver");
            return (Criteria) this;
        }

        public Criteria andTurnonverLessThanOrEqualTo(Double value) {
            addCriterion("turnonver <=", value, "turnonver");
            return (Criteria) this;
        }

        public Criteria andTurnonverIn(List<Double> values) {
            addCriterion("turnonver in", values, "turnonver");
            return (Criteria) this;
        }

        public Criteria andTurnonverNotIn(List<Double> values) {
            addCriterion("turnonver not in", values, "turnonver");
            return (Criteria) this;
        }

        public Criteria andTurnonverBetween(Double value1, Double value2) {
            addCriterion("turnonver between", value1, value2, "turnonver");
            return (Criteria) this;
        }

        public Criteria andTurnonverNotBetween(Double value1, Double value2) {
            addCriterion("turnonver not between", value1, value2, "turnonver");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyIsNull() {
            addCriterion("targetmoney is null");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyIsNotNull() {
            addCriterion("targetmoney is not null");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyEqualTo(Double value) {
            addCriterion("targetmoney =", value, "targetmoney");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyNotEqualTo(Double value) {
            addCriterion("targetmoney <>", value, "targetmoney");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyGreaterThan(Double value) {
            addCriterion("targetmoney >", value, "targetmoney");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("targetmoney >=", value, "targetmoney");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyLessThan(Double value) {
            addCriterion("targetmoney <", value, "targetmoney");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyLessThanOrEqualTo(Double value) {
            addCriterion("targetmoney <=", value, "targetmoney");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyIn(List<Double> values) {
            addCriterion("targetmoney in", values, "targetmoney");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyNotIn(List<Double> values) {
            addCriterion("targetmoney not in", values, "targetmoney");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyBetween(Double value1, Double value2) {
            addCriterion("targetmoney between", value1, value2, "targetmoney");
            return (Criteria) this;
        }

        public Criteria andTargetmoneyNotBetween(Double value1, Double value2) {
            addCriterion("targetmoney not between", value1, value2, "targetmoney");
            return (Criteria) this;
        }

        public Criteria andPlanIsNull() {
            addCriterion("plan is null");
            return (Criteria) this;
        }

        public Criteria andPlanIsNotNull() {
            addCriterion("plan is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEqualTo(String value) {
            addCriterion("plan =", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanNotEqualTo(String value) {
            addCriterion("plan <>", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanGreaterThan(String value) {
            addCriterion("plan >", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanGreaterThanOrEqualTo(String value) {
            addCriterion("plan >=", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanLessThan(String value) {
            addCriterion("plan <", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanLessThanOrEqualTo(String value) {
            addCriterion("plan <=", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanLike(String value) {
            addCriterion("plan like", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanNotLike(String value) {
            addCriterion("plan not like", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanIn(List<String> values) {
            addCriterion("plan in", values, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanNotIn(List<String> values) {
            addCriterion("plan not in", values, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanBetween(String value1, String value2) {
            addCriterion("plan between", value1, value2, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanNotBetween(String value1, String value2) {
            addCriterion("plan not between", value1, value2, "plan");
            return (Criteria) this;
        }

        public Criteria andDisparityIsNull() {
            addCriterion("disparity is null");
            return (Criteria) this;
        }

        public Criteria andDisparityIsNotNull() {
            addCriterion("disparity is not null");
            return (Criteria) this;
        }

        public Criteria andDisparityEqualTo(String value) {
            addCriterion("disparity =", value, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityNotEqualTo(String value) {
            addCriterion("disparity <>", value, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityGreaterThan(String value) {
            addCriterion("disparity >", value, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityGreaterThanOrEqualTo(String value) {
            addCriterion("disparity >=", value, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityLessThan(String value) {
            addCriterion("disparity <", value, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityLessThanOrEqualTo(String value) {
            addCriterion("disparity <=", value, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityLike(String value) {
            addCriterion("disparity like", value, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityNotLike(String value) {
            addCriterion("disparity not like", value, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityIn(List<String> values) {
            addCriterion("disparity in", values, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityNotIn(List<String> values) {
            addCriterion("disparity not in", values, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityBetween(String value1, String value2) {
            addCriterion("disparity between", value1, value2, "disparity");
            return (Criteria) this;
        }

        public Criteria andDisparityNotBetween(String value1, String value2) {
            addCriterion("disparity not between", value1, value2, "disparity");
            return (Criteria) this;
        }

        public Criteria andEmpFkIsNull() {
            addCriterion("emp_fk is null");
            return (Criteria) this;
        }

        public Criteria andEmpFkIsNotNull() {
            addCriterion("emp_fk is not null");
            return (Criteria) this;
        }

        public Criteria andEmpFkEqualTo(Integer value) {
            addCriterion("emp_fk =", value, "empFk");
            return (Criteria) this;
        }

        public Criteria andEmpFkNotEqualTo(Integer value) {
            addCriterion("emp_fk <>", value, "empFk");
            return (Criteria) this;
        }

        public Criteria andEmpFkGreaterThan(Integer value) {
            addCriterion("emp_fk >", value, "empFk");
            return (Criteria) this;
        }

        public Criteria andEmpFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_fk >=", value, "empFk");
            return (Criteria) this;
        }

        public Criteria andEmpFkLessThan(Integer value) {
            addCriterion("emp_fk <", value, "empFk");
            return (Criteria) this;
        }

        public Criteria andEmpFkLessThanOrEqualTo(Integer value) {
            addCriterion("emp_fk <=", value, "empFk");
            return (Criteria) this;
        }

        public Criteria andEmpFkIn(List<Integer> values) {
            addCriterion("emp_fk in", values, "empFk");
            return (Criteria) this;
        }

        public Criteria andEmpFkNotIn(List<Integer> values) {
            addCriterion("emp_fk not in", values, "empFk");
            return (Criteria) this;
        }

        public Criteria andEmpFkBetween(Integer value1, Integer value2) {
            addCriterion("emp_fk between", value1, value2, "empFk");
            return (Criteria) this;
        }

        public Criteria andEmpFkNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_fk not between", value1, value2, "empFk");
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