package io.github.eikefs.sql.provider.orm;

import io.github.eikefs.sql.provider.database.Database;
import io.github.eikefs.sql.provider.orm.annotations.Field;
import io.github.eikefs.sql.provider.orm.annotations.Table;

import java.util.Arrays;

public interface CRUD<E, I> {

    public void insert(E entity);

    public void update(E entity);

    public void delete(E entity);

    public E get(I id);
}