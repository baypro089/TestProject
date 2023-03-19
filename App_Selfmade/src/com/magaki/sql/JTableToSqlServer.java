package com.magaki.sql;

import java.sql.*;

import javax.swing.JTable;

public class JTableToSqlServer {

  public static void main(String[] args) {
    try {
      // Connect to SQL Server
      String url = "jdbc:sqlserver://localhost:1433;databaseName=mydatabase";
      String username = "myusername";
      String password = "mypassword";
      Connection con = DriverManager.getConnection(url, username, password);

      // Get data from JTable
      JTable table = new JTable();
      // ...
      // Code to populate JTable with data
      // ...

      // Update data in SQL Server table
      String sql = "UPDATE mytable SET column1=?, column2=?, ... WHERE id=?";
      PreparedStatement ps = con.prepareStatement(sql);
      for (int i = 0; i < table.getRowCount(); i++) {
        ps.setString(1, table.getValueAt(i, 0).toString());
        ps.setString(2, table.getValueAt(i, 1).toString());
        // ...
        ps.setInt(n, id); // set the value for the id parameter
        ps.executeUpdate();
      }

      // Close the database connection
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
