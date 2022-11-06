package lan.pojo;

import java.util.ArrayList;
import java.util.List;

public class SupermarketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupermarketExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andSupermarketIdIsNull() {
            addCriterion("supermarket_id is null");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdIsNotNull() {
            addCriterion("supermarket_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdEqualTo(String value) {
            addCriterion("supermarket_id =", value, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdNotEqualTo(String value) {
            addCriterion("supermarket_id <>", value, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdGreaterThan(String value) {
            addCriterion("supermarket_id >", value, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdGreaterThanOrEqualTo(String value) {
            addCriterion("supermarket_id >=", value, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdLessThan(String value) {
            addCriterion("supermarket_id <", value, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdLessThanOrEqualTo(String value) {
            addCriterion("supermarket_id <=", value, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdLike(String value) {
            addCriterion("supermarket_id like", value, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdNotLike(String value) {
            addCriterion("supermarket_id not like", value, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdIn(List<String> values) {
            addCriterion("supermarket_id in", values, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdNotIn(List<String> values) {
            addCriterion("supermarket_id not in", values, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdBetween(String value1, String value2) {
            addCriterion("supermarket_id between", value1, value2, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketIdNotBetween(String value1, String value2) {
            addCriterion("supermarket_id not between", value1, value2, "supermarketId");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameIsNull() {
            addCriterion("supermarket_name is null");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameIsNotNull() {
            addCriterion("supermarket_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameEqualTo(String value) {
            addCriterion("supermarket_name =", value, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameNotEqualTo(String value) {
            addCriterion("supermarket_name <>", value, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameGreaterThan(String value) {
            addCriterion("supermarket_name >", value, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameGreaterThanOrEqualTo(String value) {
            addCriterion("supermarket_name >=", value, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameLessThan(String value) {
            addCriterion("supermarket_name <", value, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameLessThanOrEqualTo(String value) {
            addCriterion("supermarket_name <=", value, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameLike(String value) {
            addCriterion("supermarket_name like", value, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameNotLike(String value) {
            addCriterion("supermarket_name not like", value, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameIn(List<String> values) {
            addCriterion("supermarket_name in", values, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameNotIn(List<String> values) {
            addCriterion("supermarket_name not in", values, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameBetween(String value1, String value2) {
            addCriterion("supermarket_name between", value1, value2, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andSupermarketNameNotBetween(String value1, String value2) {
            addCriterion("supermarket_name not between", value1, value2, "supermarketName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNull() {
            addCriterion("contact_number is null");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNotNull() {
            addCriterion("contact_number is not null");
            return (Criteria) this;
        }

        public Criteria andContactNumberEqualTo(String value) {
            addCriterion("contact_number =", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotEqualTo(String value) {
            addCriterion("contact_number <>", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThan(String value) {
            addCriterion("contact_number >", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contact_number >=", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThan(String value) {
            addCriterion("contact_number <", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThanOrEqualTo(String value) {
            addCriterion("contact_number <=", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLike(String value) {
            addCriterion("contact_number like", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotLike(String value) {
            addCriterion("contact_number not like", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberIn(List<String> values) {
            addCriterion("contact_number in", values, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotIn(List<String> values) {
            addCriterion("contact_number not in", values, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberBetween(String value1, String value2) {
            addCriterion("contact_number between", value1, value2, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotBetween(String value1, String value2) {
            addCriterion("contact_number not between", value1, value2, "contactNumber");
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