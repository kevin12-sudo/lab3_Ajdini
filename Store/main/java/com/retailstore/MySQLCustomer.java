/** Project: LAB 3
 * Purpose Details: Class
 * Course: IST 242
 * Author: KEVIN AJDINI
 * Date Developed: 3/1/2026
 * Last Date Changed: 3/1/2026
 * Rev: 3/1/2026

 */

package com.retailstore;

import java.sql.*;

public class MySQLCustomer {
    /** defines what database to use and the password needed to access it and where*/
    private static final String URL      = "jdbc:mysql://localhost:3306/retail_store";
    private static final String USER     = "root";
    private static final String PASSWORD = "IST888IST888";
    /** very important part this creates the costumers to be used in the database*/
    public void createCustomer(int id, String firstName, String lastName,
                               String instagram, String address, String shirtType) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO Customer (id, firstName, lastName, instagram, address, shirtType) VALUES (?,?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, firstName);
        ps.setString(3, lastName);
        ps.setString(4, instagram);
        ps.setString(5, address);
        ps.setString(6, shirtType);
        ps.executeUpdate();
        System.out.println("[MySQL] Created: " + firstName + " " + lastName);
        conn.close();
    }
    /** all costumers are read through here and are then processed*/
    public void readCustomers() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Customer");
        System.out.println("[MySQL] All customers:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " + rs.getString("firstName") +
                    " " + rs.getString("lastName") + " | " + rs.getString("instagram") +
                    " | " + rs.getString("shirtType"));
        }
        conn.close();
    }
    /** updates the specific costumers information*/
    public void updateCustomer(int id, String instagram, String shirtType) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE Customer SET instagram=?, shirtType=? WHERE id=?");
        ps.setString(1, instagram);
        ps.setString(2, shirtType);
        ps.setInt(3, id);
        ps.executeUpdate();
        System.out.println("[MySQL] Updated customer ID: " + id);
        conn.close();
    }
    /** deletes a costumer off the data*/
    public void deleteCustomer(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps = conn.prepareStatement("DELETE FROM Customer WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("[MySQL] Deleted customer ID: " + id);
        conn.close();
    }
}