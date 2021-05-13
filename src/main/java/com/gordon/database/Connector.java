package com.gordon.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connector {
    boolean connect() throws SQLException;
    boolean reConnect() throws SQLException;
    Connection getConnection() throws SQLException;
    void commit() throws SQLException;
    boolean isAutoCommit() throws SQLException;
    void enableAutoCommit() throws SQLException;
    void disableAutoCommit() throws SQLException;
    boolean isConnected() throws SQLException;
    void close() throws SQLException;
}
