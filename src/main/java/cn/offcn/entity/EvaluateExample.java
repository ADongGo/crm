package cn.offcn.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluateExample() {
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

        public Criteria andEvaidIsNull() {
            addCriterion("evaid is null");
            return (Criteria) this;
        }

        public Criteria andEvaidIsNotNull() {
            addCriterion("evaid is not null");
            return (Criteria) this;
        }

        public Criteria andEvaidEqualTo(Integer value) {
            addCriterion("evaid =", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidNotEqualTo(Integer value) {
            addCriterion("evaid <>", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidGreaterThan(Integer value) {
            addCriterion("evaid >", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaid >=", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidLessThan(Integer value) {
            addCriterion("evaid <", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidLessThanOrEqualTo(Integer value) {
            addCriterion("evaid <=", value, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidIn(List<Integer> values) {
            addCriterion("evaid in", values, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidNotIn(List<Integer> values) {
            addCriterion("evaid not in", values, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidBetween(Integer value1, Integer value2) {
            addCriterion("evaid between", value1, value2, "evaid");
            return (Criteria) this;
        }

        public Criteria andEvaidNotBetween(Integer value1, Integer value2) {
            addCriterion("evaid not between", value1, value2, "evaid");
            return (Criteria) this;
        }

        public Criteria andForumfkIsNull() {
            addCriterion("forumFk is null");
            return (Criteria) this;
        }

        public Criteria andForumfkIsNotNull() {
            addCriterion("forumFk is not null");
            return (Criteria) this;
        }

        public Criteria andForumfkEqualTo(Integer value) {
            addCriterion("forumFk =", value, "forumfk");
            return (Criteria) this;
        }

        public Criteria andForumfkNotEqualTo(Integer value) {
            addCriterion("forumFk <>", value, "forumfk");
            return (Criteria) this;
        }

        public Criteria andForumfkGreaterThan(Integer value) {
            addCriterion("forumFk >", value, "forumfk");
            return (Criteria) this;
        }

        public Criteria andForumfkGreaterThanOrEqualTo(Integer value) {
            addCriterion("forumFk >=", value, "forumfk");
            return (Criteria) this;
        }

        public Criteria andForumfkLessThan(Integer value) {
            addCriterion("forumFk <", value, "forumfk");
            return (Criteria) this;
        }

        public Criteria andForumfkLessThanOrEqualTo(Integer value) {
            addCriterion("forumFk <=", value, "forumfk");
            return (Criteria) this;
        }

        public Criteria andForumfkIn(List<Integer> values) {
            addCriterion("forumFk in", values, "forumfk");
            return (Criteria) this;
        }

        public Criteria andForumfkNotIn(List<Integer> values) {
            addCriterion("forumFk not in", values, "forumfk");
            return (Criteria) this;
        }

        public Criteria andForumfkBetween(Integer value1, Integer value2) {
            addCriterion("forumFk between", value1, value2, "forumfk");
            return (Criteria) this;
        }

        public Criteria andForumfkNotBetween(Integer value1, Integer value2) {
            addCriterion("forumFk not between", value1, value2, "forumfk");
            return (Criteria) this;
        }

        public Criteria andEmpfkIsNull() {
            addCriterion("empFk is null");
            return (Criteria) this;
        }

        public Criteria andEmpfkIsNotNull() {
            addCriterion("empFk is not null");
            return (Criteria) this;
        }

        public Criteria andEmpfkEqualTo(Integer value) {
            addCriterion("empFk =", value, "empfk");
            return (Criteria) this;
        }

        public Criteria andEmpfkNotEqualTo(Integer value) {
            addCriterion("empFk <>", value, "empfk");
            return (Criteria) this;
        }

        public Criteria andEmpfkGreaterThan(Integer value) {
            addCriterion("empFk >", value, "empfk");
            return (Criteria) this;
        }

        public Criteria andEmpfkGreaterThanOrEqualTo(Integer value) {
            addCriterion("empFk >=", value, "empfk");
            return (Criteria) this;
        }

        public Criteria andEmpfkLessThan(Integer value) {
            addCriterion("empFk <", value, "empfk");
            return (Criteria) this;
        }

        public Criteria andEmpfkLessThanOrEqualTo(Integer value) {
            addCriterion("empFk <=", value, "empfk");
            return (Criteria) this;
        }

        public Criteria andEmpfkIn(List<Integer> values) {
            addCriterion("empFk in", values, "empfk");
            return (Criteria) this;
        }

        public Criteria andEmpfkNotIn(List<Integer> values) {
            addCriterion("empFk not in", values, "empfk");
            return (Criteria) this;
        }

        public Criteria andEmpfkBetween(Integer value1, Integer value2) {
            addCriterion("empFk between", value1, value2, "empfk");
            return (Criteria) this;
        }

        public Criteria andEmpfkNotBetween(Integer value1, Integer value2) {
            addCriterion("empFk not between", value1, value2, "empfk");
            return (Criteria) this;
        }

        public Criteria andEvaidfkIsNull() {
            addCriterion("evaidFk is null");
            return (Criteria) this;
        }

        public Criteria andEvaidfkIsNotNull() {
            addCriterion("evaidFk is not null");
            return (Criteria) this;
        }

        public Criteria andEvaidfkEqualTo(Integer value) {
            addCriterion("evaidFk =", value, "evaidfk");
            return (Criteria) this;
        }

        public Criteria andEvaidfkNotEqualTo(Integer value) {
            addCriterion("evaidFk <>", value, "evaidfk");
            return (Criteria) this;
        }

        public Criteria andEvaidfkGreaterThan(Integer value) {
            addCriterion("evaidFk >", value, "evaidfk");
            return (Criteria) this;
        }

        public Criteria andEvaidfkGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaidFk >=", value, "evaidfk");
            return (Criteria) this;
        }

        public Criteria andEvaidfkLessThan(Integer value) {
            addCriterion("evaidFk <", value, "evaidfk");
            return (Criteria) this;
        }

        public Criteria andEvaidfkLessThanOrEqualTo(Integer value) {
            addCriterion("evaidFk <=", value, "evaidfk");
            return (Criteria) this;
        }

        public Criteria andEvaidfkIn(List<Integer> values) {
            addCriterion("evaidFk in", values, "evaidfk");
            return (Criteria) this;
        }

        public Criteria andEvaidfkNotIn(List<Integer> values) {
            addCriterion("evaidFk not in", values, "evaidfk");
            return (Criteria) this;
        }

        public Criteria andEvaidfkBetween(Integer value1, Integer value2) {
            addCriterion("evaidFk between", value1, value2, "evaidfk");
            return (Criteria) this;
        }

        public Criteria andEvaidfkNotBetween(Integer value1, Integer value2) {
            addCriterion("evaidFk not between", value1, value2, "evaidfk");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andEvatimeIsNull() {
            addCriterion("evatime is null");
            return (Criteria) this;
        }

        public Criteria andEvatimeIsNotNull() {
            addCriterion("evatime is not null");
            return (Criteria) this;
        }

        public Criteria andEvatimeEqualTo(Date value) {
            addCriterion("evatime =", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeNotEqualTo(Date value) {
            addCriterion("evatime <>", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeGreaterThan(Date value) {
            addCriterion("evatime >", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("evatime >=", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeLessThan(Date value) {
            addCriterion("evatime <", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeLessThanOrEqualTo(Date value) {
            addCriterion("evatime <=", value, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeIn(List<Date> values) {
            addCriterion("evatime in", values, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeNotIn(List<Date> values) {
            addCriterion("evatime not in", values, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeBetween(Date value1, Date value2) {
            addCriterion("evatime between", value1, value2, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvatimeNotBetween(Date value1, Date value2) {
            addCriterion("evatime not between", value1, value2, "evatime");
            return (Criteria) this;
        }

        public Criteria andEvastatusIsNull() {
            addCriterion("evastatus is null");
            return (Criteria) this;
        }

        public Criteria andEvastatusIsNotNull() {
            addCriterion("evastatus is not null");
            return (Criteria) this;
        }

        public Criteria andEvastatusEqualTo(Integer value) {
            addCriterion("evastatus =", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusNotEqualTo(Integer value) {
            addCriterion("evastatus <>", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusGreaterThan(Integer value) {
            addCriterion("evastatus >", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("evastatus >=", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusLessThan(Integer value) {
            addCriterion("evastatus <", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusLessThanOrEqualTo(Integer value) {
            addCriterion("evastatus <=", value, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusIn(List<Integer> values) {
            addCriterion("evastatus in", values, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusNotIn(List<Integer> values) {
            addCriterion("evastatus not in", values, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusBetween(Integer value1, Integer value2) {
            addCriterion("evastatus between", value1, value2, "evastatus");
            return (Criteria) this;
        }

        public Criteria andEvastatusNotBetween(Integer value1, Integer value2) {
            addCriterion("evastatus not between", value1, value2, "evastatus");
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