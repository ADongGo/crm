package cn.offcn.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmailExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendtime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendtime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendtime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendtime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendtime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendtime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendtime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendtime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendtime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendtime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendtime not between", value1, value2, "sendtime");
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

        public Criteria andEmpFk2IsNull() {
            addCriterion("emp_fk2 is null");
            return (Criteria) this;
        }

        public Criteria andEmpFk2IsNotNull() {
            addCriterion("emp_fk2 is not null");
            return (Criteria) this;
        }

        public Criteria andEmpFk2EqualTo(Integer value) {
            addCriterion("emp_fk2 =", value, "empFk2");
            return (Criteria) this;
        }

        public Criteria andEmpFk2NotEqualTo(Integer value) {
            addCriterion("emp_fk2 <>", value, "empFk2");
            return (Criteria) this;
        }

        public Criteria andEmpFk2GreaterThan(Integer value) {
            addCriterion("emp_fk2 >", value, "empFk2");
            return (Criteria) this;
        }

        public Criteria andEmpFk2GreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_fk2 >=", value, "empFk2");
            return (Criteria) this;
        }

        public Criteria andEmpFk2LessThan(Integer value) {
            addCriterion("emp_fk2 <", value, "empFk2");
            return (Criteria) this;
        }

        public Criteria andEmpFk2LessThanOrEqualTo(Integer value) {
            addCriterion("emp_fk2 <=", value, "empFk2");
            return (Criteria) this;
        }

        public Criteria andEmpFk2In(List<Integer> values) {
            addCriterion("emp_fk2 in", values, "empFk2");
            return (Criteria) this;
        }

        public Criteria andEmpFk2NotIn(List<Integer> values) {
            addCriterion("emp_fk2 not in", values, "empFk2");
            return (Criteria) this;
        }

        public Criteria andEmpFk2Between(Integer value1, Integer value2) {
            addCriterion("emp_fk2 between", value1, value2, "empFk2");
            return (Criteria) this;
        }

        public Criteria andEmpFk2NotBetween(Integer value1, Integer value2) {
            addCriterion("emp_fk2 not between", value1, value2, "empFk2");
            return (Criteria) this;
        }

        public Criteria andEmailcontentIsNull() {
            addCriterion("emailcontent is null");
            return (Criteria) this;
        }

        public Criteria andEmailcontentIsNotNull() {
            addCriterion("emailcontent is not null");
            return (Criteria) this;
        }

        public Criteria andEmailcontentEqualTo(String value) {
            addCriterion("emailcontent =", value, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentNotEqualTo(String value) {
            addCriterion("emailcontent <>", value, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentGreaterThan(String value) {
            addCriterion("emailcontent >", value, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentGreaterThanOrEqualTo(String value) {
            addCriterion("emailcontent >=", value, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentLessThan(String value) {
            addCriterion("emailcontent <", value, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentLessThanOrEqualTo(String value) {
            addCriterion("emailcontent <=", value, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentLike(String value) {
            addCriterion("emailcontent like", value, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentNotLike(String value) {
            addCriterion("emailcontent not like", value, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentIn(List<String> values) {
            addCriterion("emailcontent in", values, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentNotIn(List<String> values) {
            addCriterion("emailcontent not in", values, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentBetween(String value1, String value2) {
            addCriterion("emailcontent between", value1, value2, "emailcontent");
            return (Criteria) this;
        }

        public Criteria andEmailcontentNotBetween(String value1, String value2) {
            addCriterion("emailcontent not between", value1, value2, "emailcontent");
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