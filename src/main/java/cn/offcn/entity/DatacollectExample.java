package cn.offcn.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DatacollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatacollectExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDaidIsNull() {
            addCriterion("daid is null");
            return (Criteria) this;
        }

        public Criteria andDaidIsNotNull() {
            addCriterion("daid is not null");
            return (Criteria) this;
        }

        public Criteria andDaidEqualTo(Integer value) {
            addCriterion("daid =", value, "daid");
            return (Criteria) this;
        }

        public Criteria andDaidNotEqualTo(Integer value) {
            addCriterion("daid <>", value, "daid");
            return (Criteria) this;
        }

        public Criteria andDaidGreaterThan(Integer value) {
            addCriterion("daid >", value, "daid");
            return (Criteria) this;
        }

        public Criteria andDaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("daid >=", value, "daid");
            return (Criteria) this;
        }

        public Criteria andDaidLessThan(Integer value) {
            addCriterion("daid <", value, "daid");
            return (Criteria) this;
        }

        public Criteria andDaidLessThanOrEqualTo(Integer value) {
            addCriterion("daid <=", value, "daid");
            return (Criteria) this;
        }

        public Criteria andDaidIn(List<Integer> values) {
            addCriterion("daid in", values, "daid");
            return (Criteria) this;
        }

        public Criteria andDaidNotIn(List<Integer> values) {
            addCriterion("daid not in", values, "daid");
            return (Criteria) this;
        }

        public Criteria andDaidBetween(Integer value1, Integer value2) {
            addCriterion("daid between", value1, value2, "daid");
            return (Criteria) this;
        }

        public Criteria andDaidNotBetween(Integer value1, Integer value2) {
            addCriterion("daid not between", value1, value2, "daid");
            return (Criteria) this;
        }

        public Criteria andDacnameIsNull() {
            addCriterion("dacname is null");
            return (Criteria) this;
        }

        public Criteria andDacnameIsNotNull() {
            addCriterion("dacname is not null");
            return (Criteria) this;
        }

        public Criteria andDacnameEqualTo(String value) {
            addCriterion("dacname =", value, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameNotEqualTo(String value) {
            addCriterion("dacname <>", value, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameGreaterThan(String value) {
            addCriterion("dacname >", value, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameGreaterThanOrEqualTo(String value) {
            addCriterion("dacname >=", value, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameLessThan(String value) {
            addCriterion("dacname <", value, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameLessThanOrEqualTo(String value) {
            addCriterion("dacname <=", value, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameLike(String value) {
            addCriterion("dacname like", value, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameNotLike(String value) {
            addCriterion("dacname not like", value, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameIn(List<String> values) {
            addCriterion("dacname in", values, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameNotIn(List<String> values) {
            addCriterion("dacname not in", values, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameBetween(String value1, String value2) {
            addCriterion("dacname between", value1, value2, "dacname");
            return (Criteria) this;
        }

        public Criteria andDacnameNotBetween(String value1, String value2) {
            addCriterion("dacname not between", value1, value2, "dacname");
            return (Criteria) this;
        }

        public Criteria andDaturnoverIsNull() {
            addCriterion("daturnover is null");
            return (Criteria) this;
        }

        public Criteria andDaturnoverIsNotNull() {
            addCriterion("daturnover is not null");
            return (Criteria) this;
        }

        public Criteria andDaturnoverEqualTo(Double value) {
            addCriterion("daturnover =", value, "daturnover");
            return (Criteria) this;
        }

        public Criteria andDaturnoverNotEqualTo(Double value) {
            addCriterion("daturnover <>", value, "daturnover");
            return (Criteria) this;
        }

        public Criteria andDaturnoverGreaterThan(Double value) {
            addCriterion("daturnover >", value, "daturnover");
            return (Criteria) this;
        }

        public Criteria andDaturnoverGreaterThanOrEqualTo(Double value) {
            addCriterion("daturnover >=", value, "daturnover");
            return (Criteria) this;
        }

        public Criteria andDaturnoverLessThan(Double value) {
            addCriterion("daturnover <", value, "daturnover");
            return (Criteria) this;
        }

        public Criteria andDaturnoverLessThanOrEqualTo(Double value) {
            addCriterion("daturnover <=", value, "daturnover");
            return (Criteria) this;
        }

        public Criteria andDaturnoverIn(List<Double> values) {
            addCriterion("daturnover in", values, "daturnover");
            return (Criteria) this;
        }

        public Criteria andDaturnoverNotIn(List<Double> values) {
            addCriterion("daturnover not in", values, "daturnover");
            return (Criteria) this;
        }

        public Criteria andDaturnoverBetween(Double value1, Double value2) {
            addCriterion("daturnover between", value1, value2, "daturnover");
            return (Criteria) this;
        }

        public Criteria andDaturnoverNotBetween(Double value1, Double value2) {
            addCriterion("daturnover not between", value1, value2, "daturnover");
            return (Criteria) this;
        }

        public Criteria andDatimeIsNull() {
            addCriterion("datime is null");
            return (Criteria) this;
        }

        public Criteria andDatimeIsNotNull() {
            addCriterion("datime is not null");
            return (Criteria) this;
        }

        public Criteria andDatimeEqualTo(Date value) {
            addCriterionForJDBCDate("datime =", value, "datime");
            return (Criteria) this;
        }

        public Criteria andDatimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("datime <>", value, "datime");
            return (Criteria) this;
        }

        public Criteria andDatimeGreaterThan(Date value) {
            addCriterionForJDBCDate("datime >", value, "datime");
            return (Criteria) this;
        }

        public Criteria andDatimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("datime >=", value, "datime");
            return (Criteria) this;
        }

        public Criteria andDatimeLessThan(Date value) {
            addCriterionForJDBCDate("datime <", value, "datime");
            return (Criteria) this;
        }

        public Criteria andDatimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("datime <=", value, "datime");
            return (Criteria) this;
        }

        public Criteria andDatimeIn(List<Date> values) {
            addCriterionForJDBCDate("datime in", values, "datime");
            return (Criteria) this;
        }

        public Criteria andDatimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("datime not in", values, "datime");
            return (Criteria) this;
        }

        public Criteria andDatimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("datime between", value1, value2, "datime");
            return (Criteria) this;
        }

        public Criteria andDatimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("datime not between", value1, value2, "datime");
            return (Criteria) this;
        }

        public Criteria andDabusinessIsNull() {
            addCriterion("dabusiness is null");
            return (Criteria) this;
        }

        public Criteria andDabusinessIsNotNull() {
            addCriterion("dabusiness is not null");
            return (Criteria) this;
        }

        public Criteria andDabusinessEqualTo(String value) {
            addCriterion("dabusiness =", value, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessNotEqualTo(String value) {
            addCriterion("dabusiness <>", value, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessGreaterThan(String value) {
            addCriterion("dabusiness >", value, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessGreaterThanOrEqualTo(String value) {
            addCriterion("dabusiness >=", value, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessLessThan(String value) {
            addCriterion("dabusiness <", value, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessLessThanOrEqualTo(String value) {
            addCriterion("dabusiness <=", value, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessLike(String value) {
            addCriterion("dabusiness like", value, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessNotLike(String value) {
            addCriterion("dabusiness not like", value, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessIn(List<String> values) {
            addCriterion("dabusiness in", values, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessNotIn(List<String> values) {
            addCriterion("dabusiness not in", values, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessBetween(String value1, String value2) {
            addCriterion("dabusiness between", value1, value2, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDabusinessNotBetween(String value1, String value2) {
            addCriterion("dabusiness not between", value1, value2, "dabusiness");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityIsNull() {
            addCriterion("dasuperiority is null");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityIsNotNull() {
            addCriterion("dasuperiority is not null");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityEqualTo(String value) {
            addCriterion("dasuperiority =", value, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityNotEqualTo(String value) {
            addCriterion("dasuperiority <>", value, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityGreaterThan(String value) {
            addCriterion("dasuperiority >", value, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityGreaterThanOrEqualTo(String value) {
            addCriterion("dasuperiority >=", value, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityLessThan(String value) {
            addCriterion("dasuperiority <", value, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityLessThanOrEqualTo(String value) {
            addCriterion("dasuperiority <=", value, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityLike(String value) {
            addCriterion("dasuperiority like", value, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityNotLike(String value) {
            addCriterion("dasuperiority not like", value, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityIn(List<String> values) {
            addCriterion("dasuperiority in", values, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityNotIn(List<String> values) {
            addCriterion("dasuperiority not in", values, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityBetween(String value1, String value2) {
            addCriterion("dasuperiority between", value1, value2, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDasuperiorityNotBetween(String value1, String value2) {
            addCriterion("dasuperiority not between", value1, value2, "dasuperiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityIsNull() {
            addCriterion("dainforiority is null");
            return (Criteria) this;
        }

        public Criteria andDainforiorityIsNotNull() {
            addCriterion("dainforiority is not null");
            return (Criteria) this;
        }

        public Criteria andDainforiorityEqualTo(String value) {
            addCriterion("dainforiority =", value, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityNotEqualTo(String value) {
            addCriterion("dainforiority <>", value, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityGreaterThan(String value) {
            addCriterion("dainforiority >", value, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityGreaterThanOrEqualTo(String value) {
            addCriterion("dainforiority >=", value, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityLessThan(String value) {
            addCriterion("dainforiority <", value, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityLessThanOrEqualTo(String value) {
            addCriterion("dainforiority <=", value, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityLike(String value) {
            addCriterion("dainforiority like", value, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityNotLike(String value) {
            addCriterion("dainforiority not like", value, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityIn(List<String> values) {
            addCriterion("dainforiority in", values, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityNotIn(List<String> values) {
            addCriterion("dainforiority not in", values, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityBetween(String value1, String value2) {
            addCriterion("dainforiority between", value1, value2, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDainforiorityNotBetween(String value1, String value2) {
            addCriterion("dainforiority not between", value1, value2, "dainforiority");
            return (Criteria) this;
        }

        public Criteria andDasortIsNull() {
            addCriterion("dasort is null");
            return (Criteria) this;
        }

        public Criteria andDasortIsNotNull() {
            addCriterion("dasort is not null");
            return (Criteria) this;
        }

        public Criteria andDasortEqualTo(Integer value) {
            addCriterion("dasort =", value, "dasort");
            return (Criteria) this;
        }

        public Criteria andDasortNotEqualTo(Integer value) {
            addCriterion("dasort <>", value, "dasort");
            return (Criteria) this;
        }

        public Criteria andDasortGreaterThan(Integer value) {
            addCriterion("dasort >", value, "dasort");
            return (Criteria) this;
        }

        public Criteria andDasortGreaterThanOrEqualTo(Integer value) {
            addCriterion("dasort >=", value, "dasort");
            return (Criteria) this;
        }

        public Criteria andDasortLessThan(Integer value) {
            addCriterion("dasort <", value, "dasort");
            return (Criteria) this;
        }

        public Criteria andDasortLessThanOrEqualTo(Integer value) {
            addCriterion("dasort <=", value, "dasort");
            return (Criteria) this;
        }

        public Criteria andDasortIn(List<Integer> values) {
            addCriterion("dasort in", values, "dasort");
            return (Criteria) this;
        }

        public Criteria andDasortNotIn(List<Integer> values) {
            addCriterion("dasort not in", values, "dasort");
            return (Criteria) this;
        }

        public Criteria andDasortBetween(Integer value1, Integer value2) {
            addCriterion("dasort between", value1, value2, "dasort");
            return (Criteria) this;
        }

        public Criteria andDasortNotBetween(Integer value1, Integer value2) {
            addCriterion("dasort not between", value1, value2, "dasort");
            return (Criteria) this;
        }

        public Criteria andEmpcountIsNull() {
            addCriterion("empcount is null");
            return (Criteria) this;
        }

        public Criteria andEmpcountIsNotNull() {
            addCriterion("empcount is not null");
            return (Criteria) this;
        }

        public Criteria andEmpcountEqualTo(Integer value) {
            addCriterion("empcount =", value, "empcount");
            return (Criteria) this;
        }

        public Criteria andEmpcountNotEqualTo(Integer value) {
            addCriterion("empcount <>", value, "empcount");
            return (Criteria) this;
        }

        public Criteria andEmpcountGreaterThan(Integer value) {
            addCriterion("empcount >", value, "empcount");
            return (Criteria) this;
        }

        public Criteria andEmpcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("empcount >=", value, "empcount");
            return (Criteria) this;
        }

        public Criteria andEmpcountLessThan(Integer value) {
            addCriterion("empcount <", value, "empcount");
            return (Criteria) this;
        }

        public Criteria andEmpcountLessThanOrEqualTo(Integer value) {
            addCriterion("empcount <=", value, "empcount");
            return (Criteria) this;
        }

        public Criteria andEmpcountIn(List<Integer> values) {
            addCriterion("empcount in", values, "empcount");
            return (Criteria) this;
        }

        public Criteria andEmpcountNotIn(List<Integer> values) {
            addCriterion("empcount not in", values, "empcount");
            return (Criteria) this;
        }

        public Criteria andEmpcountBetween(Integer value1, Integer value2) {
            addCriterion("empcount between", value1, value2, "empcount");
            return (Criteria) this;
        }

        public Criteria andEmpcountNotBetween(Integer value1, Integer value2) {
            addCriterion("empcount not between", value1, value2, "empcount");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIsNull() {
            addCriterion("buildtime is null");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIsNotNull() {
            addCriterion("buildtime is not null");
            return (Criteria) this;
        }

        public Criteria andBuildtimeEqualTo(Date value) {
            addCriterionForJDBCDate("buildtime =", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("buildtime <>", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("buildtime >", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buildtime >=", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeLessThan(Date value) {
            addCriterionForJDBCDate("buildtime <", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buildtime <=", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIn(List<Date> values) {
            addCriterionForJDBCDate("buildtime in", values, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("buildtime not in", values, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buildtime between", value1, value2, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buildtime not between", value1, value2, "buildtime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDaotherIsNull() {
            addCriterion("daother is null");
            return (Criteria) this;
        }

        public Criteria andDaotherIsNotNull() {
            addCriterion("daother is not null");
            return (Criteria) this;
        }

        public Criteria andDaotherEqualTo(String value) {
            addCriterion("daother =", value, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherNotEqualTo(String value) {
            addCriterion("daother <>", value, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherGreaterThan(String value) {
            addCriterion("daother >", value, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherGreaterThanOrEqualTo(String value) {
            addCriterion("daother >=", value, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherLessThan(String value) {
            addCriterion("daother <", value, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherLessThanOrEqualTo(String value) {
            addCriterion("daother <=", value, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherLike(String value) {
            addCriterion("daother like", value, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherNotLike(String value) {
            addCriterion("daother not like", value, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherIn(List<String> values) {
            addCriterion("daother in", values, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherNotIn(List<String> values) {
            addCriterion("daother not in", values, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherBetween(String value1, String value2) {
            addCriterion("daother between", value1, value2, "daother");
            return (Criteria) this;
        }

        public Criteria andDaotherNotBetween(String value1, String value2) {
            addCriterion("daother not between", value1, value2, "daother");
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