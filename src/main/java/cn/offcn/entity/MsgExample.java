package cn.offcn.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MsgExample() {
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

        public Criteria andMsgidIsNull() {
            addCriterion("msgid is null");
            return (Criteria) this;
        }

        public Criteria andMsgidIsNotNull() {
            addCriterion("msgid is not null");
            return (Criteria) this;
        }

        public Criteria andMsgidEqualTo(Integer value) {
            addCriterion("msgid =", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotEqualTo(Integer value) {
            addCriterion("msgid <>", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidGreaterThan(Integer value) {
            addCriterion("msgid >", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("msgid >=", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidLessThan(Integer value) {
            addCriterion("msgid <", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidLessThanOrEqualTo(Integer value) {
            addCriterion("msgid <=", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidIn(List<Integer> values) {
            addCriterion("msgid in", values, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotIn(List<Integer> values) {
            addCriterion("msgid not in", values, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidBetween(Integer value1, Integer value2) {
            addCriterion("msgid between", value1, value2, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotBetween(Integer value1, Integer value2) {
            addCriterion("msgid not between", value1, value2, "msgid");
            return (Criteria) this;
        }

        public Criteria andSendpIsNull() {
            addCriterion("sendp is null");
            return (Criteria) this;
        }

        public Criteria andSendpIsNotNull() {
            addCriterion("sendp is not null");
            return (Criteria) this;
        }

        public Criteria andSendpEqualTo(Integer value) {
            addCriterion("sendp =", value, "sendp");
            return (Criteria) this;
        }

        public Criteria andSendpNotEqualTo(Integer value) {
            addCriterion("sendp <>", value, "sendp");
            return (Criteria) this;
        }

        public Criteria andSendpGreaterThan(Integer value) {
            addCriterion("sendp >", value, "sendp");
            return (Criteria) this;
        }

        public Criteria andSendpGreaterThanOrEqualTo(Integer value) {
            addCriterion("sendp >=", value, "sendp");
            return (Criteria) this;
        }

        public Criteria andSendpLessThan(Integer value) {
            addCriterion("sendp <", value, "sendp");
            return (Criteria) this;
        }

        public Criteria andSendpLessThanOrEqualTo(Integer value) {
            addCriterion("sendp <=", value, "sendp");
            return (Criteria) this;
        }

        public Criteria andSendpIn(List<Integer> values) {
            addCriterion("sendp in", values, "sendp");
            return (Criteria) this;
        }

        public Criteria andSendpNotIn(List<Integer> values) {
            addCriterion("sendp not in", values, "sendp");
            return (Criteria) this;
        }

        public Criteria andSendpBetween(Integer value1, Integer value2) {
            addCriterion("sendp between", value1, value2, "sendp");
            return (Criteria) this;
        }

        public Criteria andSendpNotBetween(Integer value1, Integer value2) {
            addCriterion("sendp not between", value1, value2, "sendp");
            return (Criteria) this;
        }

        public Criteria andRecvpIsNull() {
            addCriterion("recvp is null");
            return (Criteria) this;
        }

        public Criteria andRecvpIsNotNull() {
            addCriterion("recvp is not null");
            return (Criteria) this;
        }

        public Criteria andRecvpEqualTo(Integer value) {
            addCriterion("recvp =", value, "recvp");
            return (Criteria) this;
        }

        public Criteria andRecvpNotEqualTo(Integer value) {
            addCriterion("recvp <>", value, "recvp");
            return (Criteria) this;
        }

        public Criteria andRecvpGreaterThan(Integer value) {
            addCriterion("recvp >", value, "recvp");
            return (Criteria) this;
        }

        public Criteria andRecvpGreaterThanOrEqualTo(Integer value) {
            addCriterion("recvp >=", value, "recvp");
            return (Criteria) this;
        }

        public Criteria andRecvpLessThan(Integer value) {
            addCriterion("recvp <", value, "recvp");
            return (Criteria) this;
        }

        public Criteria andRecvpLessThanOrEqualTo(Integer value) {
            addCriterion("recvp <=", value, "recvp");
            return (Criteria) this;
        }

        public Criteria andRecvpIn(List<Integer> values) {
            addCriterion("recvp in", values, "recvp");
            return (Criteria) this;
        }

        public Criteria andRecvpNotIn(List<Integer> values) {
            addCriterion("recvp not in", values, "recvp");
            return (Criteria) this;
        }

        public Criteria andRecvpBetween(Integer value1, Integer value2) {
            addCriterion("recvp between", value1, value2, "recvp");
            return (Criteria) this;
        }

        public Criteria andRecvpNotBetween(Integer value1, Integer value2) {
            addCriterion("recvp not between", value1, value2, "recvp");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(Integer value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(Integer value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(Integer value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(Integer value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(Integer value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<Integer> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<Integer> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(Integer value1, Integer value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(Integer value1, Integer value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMsgcontentIsNull() {
            addCriterion("msgcontent is null");
            return (Criteria) this;
        }

        public Criteria andMsgcontentIsNotNull() {
            addCriterion("msgcontent is not null");
            return (Criteria) this;
        }

        public Criteria andMsgcontentEqualTo(String value) {
            addCriterion("msgcontent =", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotEqualTo(String value) {
            addCriterion("msgcontent <>", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentGreaterThan(String value) {
            addCriterion("msgcontent >", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentGreaterThanOrEqualTo(String value) {
            addCriterion("msgcontent >=", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentLessThan(String value) {
            addCriterion("msgcontent <", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentLessThanOrEqualTo(String value) {
            addCriterion("msgcontent <=", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentLike(String value) {
            addCriterion("msgcontent like", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotLike(String value) {
            addCriterion("msgcontent not like", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentIn(List<String> values) {
            addCriterion("msgcontent in", values, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotIn(List<String> values) {
            addCriterion("msgcontent not in", values, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentBetween(String value1, String value2) {
            addCriterion("msgcontent between", value1, value2, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotBetween(String value1, String value2) {
            addCriterion("msgcontent not between", value1, value2, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgtimeIsNull() {
            addCriterion("msgtime is null");
            return (Criteria) this;
        }

        public Criteria andMsgtimeIsNotNull() {
            addCriterion("msgtime is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtimeEqualTo(Date value) {
            addCriterion("msgtime =", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeNotEqualTo(Date value) {
            addCriterion("msgtime <>", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeGreaterThan(Date value) {
            addCriterion("msgtime >", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("msgtime >=", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeLessThan(Date value) {
            addCriterion("msgtime <", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeLessThanOrEqualTo(Date value) {
            addCriterion("msgtime <=", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeIn(List<Date> values) {
            addCriterion("msgtime in", values, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeNotIn(List<Date> values) {
            addCriterion("msgtime not in", values, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeBetween(Date value1, Date value2) {
            addCriterion("msgtime between", value1, value2, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeNotBetween(Date value1, Date value2) {
            addCriterion("msgtime not between", value1, value2, "msgtime");
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