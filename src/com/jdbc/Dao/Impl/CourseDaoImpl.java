/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc.Dao.Impl;

import com.jdbc.Dao.CourseDao;
import com.jdbc.dbConnect.util.DbConnect;
import com.jdbc.entity.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sharmila
 */
public class CourseDaoImpl implements CourseDao {

    DbConnect dbConn = new DbConnect();

    @Override
    public int insert(Course course) throws ClassNotFoundException, SQLException {

        dbConn.open();
        String sql = "Insert into table_courses(course_name,course_description,course_fees,course_duration,duration_type,status) values(?,?,?,?,?,?)";
        PreparedStatement stmt = dbConn.initStatement(sql);
        stmt.setString(1, course.getName());
        stmt.setString(2, course.getDescription());

        stmt.setInt(3, course.getFees());
        stmt.setInt(4, course.getDuration());
        stmt.setString(5, course.getDurationType());
        stmt.setBoolean(6, true);

        int result = dbConn.executeUpdate(sql);
        System.out.println("result is" + result);
        dbConn.close();

        return result;
    }

    @Override
    public int update(Course course) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "update  table_courses set course_name=?,course_description=?,course_fees=?,course_duration=?,duration_type=?,status=? where id=?";
        PreparedStatement stmt = dbConn.initStatement(sql);
        stmt.setString(1, course.getName());
        stmt.setString(2, course.getDescription());

        stmt.setInt(3, course.getFees());
        stmt.setInt(4, course.getDuration());
        stmt.setString(5, course.getDurationType());
        stmt.setBoolean(6, true);
        stmt.setInt(7, course.getId());

        int result = dbConn.executeUpdate(sql);
        System.out.println("result is" + result);
        dbConn.close();

        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "delete from table_courses where id=?";
        PreparedStatement stmt = dbConn.initStatement(sql);
        stmt.setInt(1, id);
        int result = dbConn.executeUpdate(sql);
        System.out.println("deleted " + result);
        return result;
    }

    @Override
    public Course getById(int id) throws ClassNotFoundException, SQLException {
        dbConn.open();
        Course course = null;
        String sql = "select * from table_courses where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = dbConn.executeQuery(sql);
        while (rs.next()) {

            course = mapData(rs);

        }
        dbConn.close();
        return course;
    }

    @Override
    public List<Course> getAll() throws ClassNotFoundException, SQLException {
        List<Course> courseList = new ArrayList<>();
        dbConn.open();
        String sql = "select * from table_courses";
        PreparedStatement stmt = dbConn.initStatement(sql);
        ResultSet rs = dbConn.executeQuery(sql);

        while (rs.next()) {

            courseList.add(mapData(rs));

        }

        dbConn.close();
        return courseList;
    }

    private Course mapData(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setId(rs.getInt("id"));
        course.setName(rs.getString("course_name"));
        course.setDescription(rs.getString("course_description"));
        course.setDurationType(rs.getString("duration_Type"));
        course.setFees(rs.getInt("course_fees"));
        if (rs.getDate("modified_date") != null) {
            course.setModifiedDate(rs.getDate("modified_date"));
        }
        course.setStatus(rs.getBoolean("status"));
        return course;
    }

}
