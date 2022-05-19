package io.github.eikefs.sql.provider.test;

import io.github.eikefs.sql.provider.Provider;
import io.github.eikefs.sql.provider.database.Database;
import io.github.eikefs.sql.provider.query.Query;
import io.github.eikefs.sql.provider.query.TableQuery;
import io.github.eikefs.sql.provider.query.field.TableField;
import io.github.eikefs.sql.provider.test.orm.User;
import io.github.eikefs.sql.provider.test.orm.UserCRUD;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainTest {

    private static Database database;
    private static UserCRUD userCRUD;

    public static void main(String[] args) {
        initDatabase();
        tableConfigure();
        userCRUD = new UserCRUD(database);
        userCRUD.insert(new User(5, "Doria"));
        userCRUD.update(new User(1, "fodase"));
        System.out.println(userCRUD.get(1).getName());
        userCRUD.delete(new User(2, ""));
    }

    private static void initDatabase(){
        database = Provider.getInstance().submitMySql("localhost:3306", "test", "root", "");
    }

    //Create User Table
    private static void tableConfigure() {
        User.create(database, User.class);
    }

}
