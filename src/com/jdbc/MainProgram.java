/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc;

import com.jdbc.Dao.CourseDao;
import com.jdbc.Dao.Impl.CourseDaoImpl;
import com.jdbc.dbConnect.util.DbConnect;
import com.jdbc.entity.Course;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DbConnect dbConn = new DbConnect();
        CourseDao courseDao = new CourseDaoImpl();
        try {
          // courseDao.insert(new Course(3, "php", "database ", "month", 60000, 3, true));
            //courseDao.update(new Course(2, "advanced database(mysql)", "database ", "month", 60000, 3, true));
            // courseDao.delete(3);

//            courseDao.getAll().forEach(c -> {
//                System.out.println(c.getName() + "," + c.getDescription());
//            });
//            Course c = courseDao.getById(1);
//            System.out.println(c.getDurationType());
            System.out.println("Enter the id to search");
            Scanner scanner =new Scanner(System.in);
            int id=scanner.nextInt();
            Course c=courseDao.getById(id);
            System.out.println(c.getName());
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
