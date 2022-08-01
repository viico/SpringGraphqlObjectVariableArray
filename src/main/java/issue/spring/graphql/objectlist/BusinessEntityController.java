package issue.spring.graphql.objectlist;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessEntityController implements GraphQLQueryResolver {

    public boolean filterValueIsInstanceOfList(BusinessEntityFilterInput filter) {
        return filter.getValue() instanceof List;
    }

    public boolean inputIsInstanceOfList(Object object) {
        return object instanceof List;
    }
}
