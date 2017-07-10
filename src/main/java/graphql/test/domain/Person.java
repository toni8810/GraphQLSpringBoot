package graphql.test.domain;

import io.leangen.graphql.annotations.GraphQLQuery;

/**
 * Created by toni8810 on 10/07/17.
 */
public class Person {
    @GraphQLQuery(name = "name", description = "A person's name")
    private String name;

    @GraphQLQuery(name = "id", description = "A person's id")
    private Integer id;


    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
