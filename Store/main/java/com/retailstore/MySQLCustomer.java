package com.retailstore;

import java.sql.*;

public class MySQLCustomer {

    private static final String URL      = "jdbc:mysql://localhost:3306/retail_store";
    private static final String USER     = "root";
    private static final String PASSWORD = "IST888IST888";

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

    public void deleteCustomer(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps = conn.prepareStatement("DELETE FROM Customer WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("[MySQL] Deleted customer ID: " + id);
        conn.close();
    }
}