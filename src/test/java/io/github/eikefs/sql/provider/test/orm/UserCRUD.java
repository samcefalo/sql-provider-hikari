package io.github.eikefs.sql.provider.test.orm;

import io.github.eikefs.sql.provider.database.Database;
import io.github.eikefs.sql.provider.orm.CRUD;
import io.github.eikefs.sql.provider.orm.ORM;
import io.github.eikefs.sql.provider.orm.annotations.Field;
import io.github.eikefs.sql.provider.orm.annotations.Table;
import io.github.eikefs.sql.provider.query.Query;

public class UserCRUD implements CRUD<User, Integer> {

    private Database database;

    public UserCRUD(Database database) {
        this.database = database;
    }

    @Override
    public void insert(User entity) {
        Query query = new Query()
                .insert("user", entity.getId(), entity.getName());
        database.updateSync(query);
    }

    @Override
    public void update(User entity) {
        Query query = new Query()
                .insert("user", entity.getId(), entity.getName())
                .onDuplicateUpdate()
                .value("name", entity.getName()).end();
        database.updateSync(query);
    }

    @Override
    public void delete(User entity) {
        Query query = new Query()
                .delete()
                .from("user")
                .where("id", entity.getId());
        System.out.println(query.getStringBuilder().toString());
        database.updateSync(query);
    }

    @Override
    public User get(Integer id) {
        return database.buildSync(User.class, new Query()
                .selectAll()
                .from("user")
                .where("id", id)
                .raw());
    }
}
