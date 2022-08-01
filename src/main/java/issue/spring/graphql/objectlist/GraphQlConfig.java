package issue.spring.graphql.objectlist;

import graphql.scalars.ExtendedScalars;
import graphql.schema.*;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQlConfig {

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

    @Bean
    public GraphQlSourceBuilderCustomizer sourceBuilderCustomizer(GraphQLScalarType objectGraphQLScalarType) {
        return (graphQlSourceBuilder) -> graphQlSourceBuilder
                .configureRuntimeWiring((wiringBuilder) -> wiringBuilder
                        .scalar(ExtendedScalars.Object));
                        //.scalar(objectGraphQLScalarType));
    }
}

