package com.dao;

import com.model.Student;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDOperation {

    public static int insertData(Student obj) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        con = DBUtil.getConnection();
        try {
            pst = con.prepareStatement("insert into student values (?,?,?,?,?,?)");
            pst.setInt(1, obj.getRoll());
            pst.setString(2, obj.getName());
            pst.setString(3, obj.getEmail());
            pst.setString(4, obj.getDepartment());
            pst.setString(5, obj.getSession());
            pst.setString(6, obj.getCountry());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static List<Student> retriveData() {
        List<Student> list = new ArrayList<Student>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = 0;
        con = DBUtil.getConnection();
        try {
            pst = con.prepareStatement("select * from student");
            rs = pst.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setRoll(rs.getInt("roll"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDepartment(rs.getString("department"));
                student.setSession(rs.getString("session"));
                student.setCountry(rs.getString("country"));
                list.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static Student readSingleData(int id) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Student std = new Student();
        con = DBUtil.getConnection();
        try {
            pst = con.prepareStatement("select * from student where roll = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                std.setRoll(rs.getInt("roll"));
                std.setName(rs.getString("name"));
                std.setEmail(rs.getString("email"));
                std.setDepartment(rs.getString("department"));
                std.setSession(rs.getString("session"));
                std.setCountry(rs.getString("country"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return std;
    }

    public static int updateData(Student std) {
        Connection con = DBUtil.getConnection();
        PreparedStatement pst = null;
        int result = 0;

        try {
            pst = con.prepareStatement("update student set name = ?, email = ?, department = ?, session = ?, country = ? where roll = ?");

            pst.setString(1, std.getName());
            pst.setString(2, std.getEmail());
            pst.setString(3, std.getDepartment());
            pst.setString(4, std.getSession());
            pst.setString(5, std.getCountry());
            pst.setInt(6, std.getRoll());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static int deleteData(int id) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        con = DBUtil.getConnection();
        try {
            pst = con.prepareStatement("delete from student where roll = ?");
            pst.setInt(1, id);

            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
