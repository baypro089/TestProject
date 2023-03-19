package com.magaki.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDataExample {

  public static void main(String[] args) throws ClassNotFoundException,
          SQLException {

      // Tạo đối tượng Statement.
      try ( // Lấy ra đối tượng Connection kết nối vào DB.
              Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection()) {
          // Tạo đối tượng Statement.
          Statement statement = connection.createStatement();
          String sql = "Select DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION from DEPARTMENT";
          // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
          ResultSet rs = statement.executeQuery(sql);
          // Duyệt trên kết quả trả về.
          while (rs.next()) {
              // Di chuyển con trỏ xuống bản ghi kế tiếp.
              String deptId = rs.getString(1);
              String deptName = rs.getString(2);
              String deptno = rs.getString(3);
              String depLocation = rs.getString(4);
             
          }
          // Đóng kết nối
          connection.close();
      }
  }

}