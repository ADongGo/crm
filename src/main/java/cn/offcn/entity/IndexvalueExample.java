package cn.offcn.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IndexvalueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndexvalueExample() {
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

        public Criteria andInIdIsNull() {
            addCriterion("in_id is null");
            return (Criteria) this;
        }

        public Criteria andInIdIsNotNull() {
            addCriterion("in_id is not null");
            return (Criteria) this;
        }

        public Criteria andInIdEqualTo(Integer value) {
            addCriterion("in_id =", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdNotEqualTo(Integer value) {
            addCriterion("in_id <>", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdGreaterThan(Integer value) {
            addCriterion("in_id >", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_id >=", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdLessThan(Integer value) {
            addCriterion("in_id <", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdLessThanOrEqualTo(Integer value) {
            addCriterion("in_id <=", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdIn(List<Integer> values) {
            addCriterion("in_id in", values, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdNotIn(List<Integer> values) {
            addCriterion("in_id not in", values, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdBetween(Integer value1, Integer value2) {
            addCriterion("in_id between", value1, value2, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdNotBetween(Integer value1, Integer value2) {
            addCriterion("in_id not between", value1, value2, "inId");
            return (Criteria) this;
        }

        public Criteria andInTurnoverIsNull() {
            addCriterion("in_turnover is null");
            return (Criteria) this;
        }

        public Criteria andInTurnoverIsNotNull() {
            addCriterion("in_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andInTurnoverEqualTo(Double value) {
            addCriterion("in_turnover =", value, "inTurnover");
            return (Criteria) this;
        }

        public Criteria andInTurnoverNotEqualTo(Double value) {
            addCriterion("in_turnover <>", value, "inTurnover");
            return (Criteria) this;
        }

        public Criteria andInTurnoverGreaterThan(Double value) {
            addCriterion("in_turnover >", value, "inTurnover");
            return (Criteria) this;
        }

        public Criteria andInTurnoverGreaterThanOrEqualTo(Double value) {
            addCriterion("in_turnover >=", value, "inTurnover");
            return (Criteria) this;
        }

        public Criteria andInTurnoverLessThan(Double value) {
            addCriterion("in_turnover <", value, "inTurnover");
            return (Criteria) this;
        }

        public Criteria andInTurnoverLessThanOrEqualTo(Double value) {
            addCriterion("in_turnover <=", value, "inTurnover");
            return (Criteria) this;
        }

        public Criteria andInTurnoverIn(List<Double> values) {
            addCriterion("in_turnover in", values, "inTurnover");
            return (Criteria) this;
        }

        public Criteria andInTurnoverNotIn(List<Double> values) {
            addCriterion("in_turnover not in", values, "inTurnover");
            return (Criteria) this;
        }

        public Criteria andInTurnoverBetween(Double value1, Double value2) {
            addCriterion("in_turnover between", value1, value2, "inTurnover");
            return (Criteria) this;
        }

        public Criteria andInTurnoverNotBetween(Double value1, Double value2) {
            addCriterion("in_turnover not between", value1, value2, "inTurnover");
            return (Criteria) this;
        }

        public Criteria andInBusinessIsNull() {
            addCriterion("in_business is null");
            return (Criteria) this;
        }

        public Criteria andInBusinessIsNotNull() {
            addCriterion("in_business is not null");
            return (Criteria) this;
        }

        public Criteria andInBusinessEqualTo(String value) {
            addCriterion("in_business =", value, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessNotEqualTo(String value) {
            addCriterion("in_business <>", value, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessGreaterThan(String value) {
            addCriterion("in_business >", value, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("in_business >=", value, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessLessThan(String value) {
            addCriterion("in_business <", value, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessLessThanOrEqualTo(String value) {
            addCriterion("in_business <=", value, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessLike(String value) {
            addCriterion("in_business like", value, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessNotLike(String value) {
            addCriterion("in_business not like", value, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessIn(List<String> values) {
            addCriterion("in_business in", values, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessNotIn(List<String> values) {
            addCriterion("in_business not in", values, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessBetween(String value1, String value2) {
            addCriterion("in_business between", value1, value2, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andInBusinessNotBetween(String value1, String value2) {
            addCriterion("in_business not between", value1, value2, "inBusiness");
            return (Criteria) this;
        }

        public Criteria andComnameFkIsNull() {
            addCriterion("comname_fk is null");
            return (Criteria) this;
        }

        public Criteria andComnameFkIsNotNull() {
            addCriterion("comname_fk is not null");
            return (Criteria) this;
        }

        public Criteria andComnameFkEqualTo(Integer value) {
            addCriterion("comname_fk =", value, "comnameFk");
            return (Criteria) this;
        }

        public Criteria andComnameFkNotEqualTo(Integer value) {
            addCriterion("comname_fk <>", value, "comnameFk");
            return (Criteria) this;
        }

        public Criteria andComnameFkGreaterThan(Integer value) {
            addCriterion("comname_fk >", value, "comnameFk");
            return (Criteria) this;
        }

        public Criteria andComnameFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("comname_fk >=", value, "comnameFk");
            return (Criteria) this;
        }

        public Criteria andComnameFkLessThan(Integer value) {
            addCriterion("comname_fk <", value, "comnameFk");
            return (Criteria) this;
        }

        public Criteria andComnameFkLessThanOrEqualTo(Integer value) {
            addCriterion("comname_fk <=", value, "comnameFk");
            return (Criteria) this;
        }

        public Criteria andComnameFkIn(List<Integer> values) {
            addCriterion("comname_fk in", values, "comnameFk");
            return (Criteria) this;
        }

        public Criteria andComnameFkNotIn(List<Integer> values) {
            addCriterion("comname_fk not in", values, "comnameFk");
            return (Criteria) this;
        }

        public Criteria andComnameFkBetween(Integer value1, Integer value2) {
            addCriterion("comname_fk between", value1, value2, "comnameFk");
            return (Criteria) this;
        }

        public Criteria andComnameFkNotBetween(Integer value1, Integer value2) {
            addCriterion("comname_fk not between", value1, value2, "comnameFk");
            return (Criteria) this;
        }

        public Criteria andInRemarkIsNull() {
            addCriterion("in_remark is null");
            return (Criteria) this;
        }

        public Criteria andInRemarkIsNotNull() {
            addCriterion("in_remark is not null");
            return (Criteria) this;
        }

        public Criteria andInRemarkEqualTo(String value) {
            addCriterion("in_remark =", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkNotEqualTo(String value) {
            addCriterion("in_remark <>", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkGreaterThan(String value) {
            addCriterion("in_remark >", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("in_remark >=", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkLessThan(String value) {
            addCriterion("in_remark <", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkLessThanOrEqualTo(String value) {
            addCriterion("in_remark <=", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkLike(String value) {
            addCriterion("in_remark like", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkNotLike(String value) {
            addCriterion("in_remark not like", value, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkIn(List<String> values) {
            addCriterion("in_remark in", values, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkNotIn(List<String> values) {
            addCriterion("in_remark not in", values, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkBetween(String value1, String value2) {
            addCriterion("in_remark between", value1, value2, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInRemarkNotBetween(String value1, String value2) {
            addCriterion("in_remark not between", value1, value2, "inRemark");
            return (Criteria) this;
        }

        public Criteria andInFileIsNull() {
            addCriterion("in_file is null");
            return (Criteria) this;
        }

        public Criteria andInFileIsNotNull() {
            addCriterion("in_file is not null");
            return (Criteria) this;
        }

        public Criteria andInFileEqualTo(String value) {
            addCriterion("in_file =", value, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileNotEqualTo(String value) {
            addCriterion("in_file <>", value, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileGreaterThan(String value) {
            addCriterion("in_file >", value, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileGreaterThanOrEqualTo(String value) {
            addCriterion("in_file >=", value, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileLessThan(String value) {
            addCriterion("in_file <", value, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileLessThanOrEqualTo(String value) {
            addCriterion("in_file <=", value, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileLike(String value) {
            addCriterion("in_file like", value, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileNotLike(String value) {
            addCriterion("in_file not like", value, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileIn(List<String> values) {
            addCriterion("in_file in", values, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileNotIn(List<String> values) {
            addCriterion("in_file not in", values, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileBetween(String value1, String value2) {
            addCriterion("in_file between", value1, value2, "inFile");
            return (Criteria) this;
        }

        public Criteria andInFileNotBetween(String value1, String value2) {
            addCriterion("in_file not between", value1, value2, "inFile");
            return (Criteria) this;
        }

        public Criteria andEmpFk5IsNull() {
            addCriterion("emp_fk5 is null");
            return (Criteria) this;
        }

        public Criteria andEmpFk5IsNotNull() {
            addCriterion("emp_fk5 is not null");
            return (Criteria) this;
        }

        public Criteria andEmpFk5EqualTo(Integer value) {
            addCriterion("emp_fk5 =", value, "empFk5");
            return (Criteria) this;
        }

        public Criteria andEmpFk5NotEqualTo(Integer value) {
            addCriterion("emp_fk5 <>", value, "empFk5");
            return (Criteria) this;
        }

        public Criteria andEmpFk5GreaterThan(Integer value) {
            addCriterion("emp_fk5 >", value, "empFk5");
            return (Criteria) this;
        }

        public Criteria andEmpFk5GreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_fk5 >=", value, "empFk5");
            return (Criteria) this;
        }

        public Criteria andEmpFk5LessThan(Integer value) {
            addCriterion("emp_fk5 <", value, "empFk5");
            return (Criteria) this;
        }

        public Criteria andEmpFk5LessThanOrEqualTo(Integer value) {
            addCriterion("emp_fk5 <=", value, "empFk5");
            return (Criteria) this;
        }

        public Criteria andEmpFk5In(List<Integer> values) {
            addCriterion("emp_fk5 in", values, "empFk5");
            return (Criteria) this;
        }

        public Criteria andEmpFk5NotIn(List<Integer> values) {
            addCriterion("emp_fk5 not in", values, "empFk5");
            return (Criteria) this;
        }

        public Criteria andEmpFk5Between(Integer value1, Integer value2) {
            addCriterion("emp_fk5 between", value1, value2, "empFk5");
            return (Criteria) this;
        }

        public Criteria andEmpFk5NotBetween(Integer value1, Integer value2) {
            addCriterion("emp_fk5 not between", value1, value2, "empFk5");
            return (Criteria) this;
        }

        public Criteria andInStarttimeIsNull() {
            addCriterion("in_starttime is null");
            return (Criteria) this;
        }

        public Criteria andInStarttimeIsNotNull() {
            addCriterion("in_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andInStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("in_starttime =", value, "inStarttime");
            return (Criteria) this;
        }

        public Criteria andInStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("in_starttime <>", value, "inStarttime");
            return (Criteria) this;
        }

        public Criteria andInStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("in_starttime >", value, "inStarttime");
            return (Criteria) this;
        }

        public Criteria andInStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_starttime >=", value, "inStarttime");
            return (Criteria) this;
        }

        public Criteria andInStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("in_starttime <", value, "inStarttime");
            return (Criteria) this;
        }

        public Criteria andInStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_starttime <=", value, "inStarttime");
            return (Criteria) this;
        }

        public Criteria andInStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("in_starttime in", values, "inStarttime");
            return (Criteria) this;
        }

        public Criteria andInStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("in_starttime not in", values, "inStarttime");
            return (Criteria) this;
        }

        public Criteria andInStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_starttime between", value1, value2, "inStarttime");
            return (Criteria) this;
        }

        public Criteria andInStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_starttime not between", value1, value2, "inStarttime");
            return (Criteria) this;
        }

        public Criteria andInEndtimeIsNull() {
            addCriterion("in_endtime is null");
            return (Criteria) this;
        }

        public Criteria andInEndtimeIsNotNull() {
            addCriterion("in_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andInEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("in_endtime =", value, "inEndtime");
            return (Criteria) this;
        }

        public Criteria andInEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("in_endtime <>", value, "inEndtime");
            return (Criteria) this;
        }

        public Criteria andInEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("in_endtime >", value, "inEndtime");
            return (Criteria) this;
        }

        public Criteria andInEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_endtime >=", value, "inEndtime");
            return (Criteria) this;
        }

        public Criteria andInEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("in_endtime <", value, "inEndtime");
            return (Criteria) this;
        }

        public Criteria andInEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_endtime <=", value, "inEndtime");
            return (Criteria) this;
        }

        public Criteria andInEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("in_endtime in", values, "inEndtime");
            return (Criteria) this;
        }

        public Criteria andInEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("in_endtime not in", values, "inEndtime");
            return (Criteria) this;
        }

        public Criteria andInEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_endtime between", value1, value2, "inEndtime");
            return (Criteria) this;
        }

        public Criteria andInEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_endtime not between", value1, value2, "inEndtime");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeIsNull() {
            addCriterion("in_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeIsNotNull() {
            addCriterion("in_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("in_updatetime =", value, "inUpdatetime");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("in_updatetime <>", value, "inUpdatetime");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("in_updatetime >", value, "inUpdatetime");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_updatetime >=", value, "inUpdatetime");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("in_updatetime <", value, "inUpdatetime");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_updatetime <=", value, "inUpdatetime");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("in_updatetime in", values, "inUpdatetime");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("in_updatetime not in", values, "inUpdatetime");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_updatetime between", value1, value2, "inUpdatetime");
            return (Criteria) this;
        }

        public Criteria andInUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_updatetime not between", value1, value2, "inUpdatetime");
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