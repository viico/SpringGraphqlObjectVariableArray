package issue.spring.graphql.objectlist;

public class BusinessEntityFilterInput {
    private String operator;
    private Object value;

    public String getOperator() {
        return operator;
    }

    public BusinessEntityFilterInput setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public BusinessEntityFilterInput setValue(Object value) {
        this.value = value;
        return this;
    }
}
