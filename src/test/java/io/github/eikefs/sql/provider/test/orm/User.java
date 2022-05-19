package io.github.eikefs.sql.provider.test.orm;

import io.github.eikefs.sql.provider.orm.ORM;
import io.github.eikefs.sql.provider.orm.annotations.Field;
import io.github.eikefs.sql.provider.orm.annotations.Table;

@Table(name = "user", primary = "id", unique = true)
public class User extends ORM {

    @Field(type = "int", size = 8, nullable = false)
    private int id;

    @Field(size = 32, nullable = false)
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String create() {
        return create(User.class);
    }

}
