package com.gordon.database;

import java.sql.SQLException;

public interface Operator<T> {
    T   query() throws SQLException;
}
