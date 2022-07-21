package issue.spring.graphql.objectlist;

public class EntityFilterInput {
    private String label;
    private Object value;

    public String getLabel() {
        return label;
    }

    public EntityFilterInput setLabel(String label) {
        this.label = label;
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
