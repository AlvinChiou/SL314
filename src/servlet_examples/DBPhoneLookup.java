package servlet_examples;

import java.io.*;
import java.sql.*;

import javax.naming.Context;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;

public class DBPhoneLookup extends HttpServlet {

public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    res.setContentType("text/html; charset=Big5");
    PrintWriter out = res.getWriter();

    try {
      Context ctx = new javax.naming.InitialContext();
      DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/TestDB");
      con = ds.getConnection();
      // Load (and therefore register) the Oracle Driver
      //Class.forName("oracle.jdbc.driver.OracleDriver");

      // Get a Connection to the database
//      con = DriverManager.getConnection(
//        "jdbc:oracle:thin:@localhost:1521:orcl", "user1", "u111");

      // Create a Statement object
      stmt = con.createStatement();

      // Execute an SQL query, get a ResultSet
      //rs = stmt.executeQuery("SELECT NAME, PHONE FROM EMPLOYEES");
      rs = stmt.executeQuery("SELECT * FROM dept2");

      // Display the result set as a list
      out.println("<HTML><HEAD><TITLE>Phonebook</TITLE></HEAD>");
      out.println("<BODY>");
      out.println("<UL>");
//      while(rs.next()) {
//        out.println("<LI>" + rs.getString(1) + " " + rs.getString(2));
//      }
      //out.println(new HtmlResultSet(rs));
      String sql ="SELECT * FROM EMP2";
      out.println(new  HtmlSQLResult(sql, con));
      out.println("</UL>");
      out.println("</BODY></HTML>");
    }
    catch(Exception e) {
      out.println("Couldn't load database driver: " + e.getMessage());
    }
    finally {
      // Always close the database connection.
      try {
        if (con != null) con.close();
      }
      catch (SQLException ignored) { }
    }
  }
}
