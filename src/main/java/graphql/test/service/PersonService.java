package graphql.test.service;

import graphql.test.domain.Person;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;

/**
 * Created by toni8810 on 10/07/17.
 */
public class PersonService {

    @GraphQLQuery(name = "person")
    public Person getById(@GraphQLArgument(name = "id") Integer id) {
      Person p = new Person();
      p.setId(id);
      p.setName("Tamas");
      return p;
    }
}
