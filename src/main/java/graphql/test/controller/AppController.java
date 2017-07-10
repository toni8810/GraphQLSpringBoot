package graphql.test.controller;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.test.service.PersonService;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by toni8810 on 10/07/17.
 */
@RestController
public class AppController {
    private GraphQL graphQlFromAnnotated;

    public AppController() {
        PersonService personService = new PersonService();
        //Schema generated from annotated query classes
        GraphQLSchema schemaFromAnnotated = new GraphQLSchemaGenerator()
                .withOperationsFromSingleton(personService)
                //Shortcut method to set usage of default resolver extractors, type mappers and value converters
                .withDefaults()
                .generate();
        graphQlFromAnnotated = GraphQL.newGraphQL(schemaFromAnnotated).build();
    }

    @PostMapping("/")
    public Object graphController(@RequestBody String query) {
        final ExecutionResult executionResult = graphQlFromAnnotated.execute(query);

        return executionResult;
    }

}
