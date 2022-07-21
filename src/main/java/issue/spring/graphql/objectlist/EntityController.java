package issue.spring.graphql.objectlist;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EntityController {

    @QueryMapping
    public boolean filterValueIsInstanceOfList(@Argument EntityFilterInput filter) {
        return filter.getValue() instanceof List;
    }
}
