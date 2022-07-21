package issue.spring.graphql.objectlist;

public class EntityFilterInput {
    private String operator;
    private Object value;

    public String getOperator() {
        return operator;
    }

    public EntityFilterInput setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public EntityFilterInput setValue(Object value) {
        this.value = value;
        return this;
    }
}
