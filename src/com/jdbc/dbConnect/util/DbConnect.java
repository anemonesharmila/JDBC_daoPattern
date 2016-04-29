/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc.dbConnect.util;

import com.jdbc.dbConnect.constant.DbConnectMethods;
import com.jdbc.dbConnect.constant.DbConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sharmila
 */
public class DbConnect implements DbConnectMethods{
    Connection conn=null;
    PreparedStatement ps=null;

    @Override
    public void open() throws ClassNotFoundException, SQLException {
        Class.forName(DbConstant.driver);
        conn=DriverManager.getConnection(DbConstant.url, DbConstant.user,DbConstant.password);
    }

    @Override
    public PreparedStatement initStatement(String sql) throws ClassNotFoundException, SQLException {
         ps=conn.prepareStatement(sql);
         return ps;
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
       return ps.executeUpdate();
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
       return ps.executeQuery();
    }

    @Override
    public void close() throws SQLException {
        if(conn!=null && !conn.isClosed())
        {
            conn.close();
            conn=null;
        }
    }
   
}
