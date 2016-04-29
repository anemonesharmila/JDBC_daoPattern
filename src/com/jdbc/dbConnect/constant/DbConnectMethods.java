/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc.dbConnect.constant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sharmila
 */
public interface DbConnectMethods {
    void open() throws ClassNotFoundException,SQLException;
    PreparedStatement initStatement(String sql) throws ClassNotFoundException,SQLException;
    int executeUpdate(String sql) throws SQLException;
    ResultSet executeQuery(String sql) throws SQLException;
    void close() throws SQLException;
}
