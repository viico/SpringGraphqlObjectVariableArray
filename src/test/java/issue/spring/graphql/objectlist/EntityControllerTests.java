package issue.spring.graphql.objectlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;
import java.util.Map;

@GraphQlTest(EntityController.class)
@Import(GraphQlConfig.class)
public class EntityControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;

    /**
     * Works with a {@link String} in {@link Object} type (cast OK)
     */
    @Test
    void filterValueIsInstanceOfList_ok() {
        final Map<String, Object> value = Map.of(
                "label", "label",
                "value", "value"
        );

        this.graphQlTester.documentName("filterValueIsInstanceOfList")
                .variable("filter", value)
                .execute()
                .path("filterValueIsInstanceOfList")
                .entity(Boolean.class)
                .isEqualTo(false);
    }

    /**
     * There is no {@link Exception} with an array of 2 {@link String} declared directly in the GraphQL query,
     * we have an {@link graphql.language.ArrayValue} in {@link Object}, shall we have a List instead ?
     */
    @Test
    void filterValueIsInstanceOfList_ko() {
        this.graphQlTester.documentName("filterValueIsInstanceOfList_withoutVariables")
                .execute()
                .path("filterValueIsInstanceOfList")
                .entity(Boolean.class)
                .isEqualTo(true);
    }

    /**
     * Failed with a {@link List} of 2 {@link String} passed in variable, exception :
     * org.springframework.beans.InvalidPropertyException: Invalid property 'value[0]' of bean class [issue.spring.graphql.objectlist.EntityFilterInput]: Property referenced in indexed property path 'value[0]' is neither an array nor a List nor a Map; returned value was [java.lang.Object@7841bd30]
     */
    @Test
    void filterValueIsInstanceOfList_ko2() {
        final Map<String, Object> value = Map.of(
                "label", "label",
                "value", List.of("value1", "value2")
        );

        this.graphQlTester.documentName("filterValueIsInstanceOfList")
                .variable("filter", value)
                .execute()
                .path("filterValueIsInstanceOfList")
                .entity(Boolean.class)
                .isEqualTo(true);
    }
}
