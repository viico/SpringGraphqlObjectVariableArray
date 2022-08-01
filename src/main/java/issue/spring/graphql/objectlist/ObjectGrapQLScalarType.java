package issue.spring.graphql.objectlist;

import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectGrapQLScalarType {

    @Bean
    public GraphQLScalarType objectGraphQLScalarType() {
        return GraphQLScalarType.newScalar()
                .name("Object")
                .description("Type Object Java")
                .coercing(new Coercing<>() {

                    @Override
                    public Object serialize(Object output) throws CoercingSerializeException {
                        return output;
                    }

                    @Override
                    public Object parseValue(Object input) throws CoercingParseValueException {
                        return input;
                    }

                    @Override
                    public Object parseLiteral(Object input) throws CoercingParseLiteralException {
                        return input;
                    }
                })
                .build();
    }
}
