package servlet_examples;

import java.io.*;
import java.sql.*;

import javax.naming.Context;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;

public class DBGifReader extends HttpServlet {

	Connection con;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setCharacterEncoding("Big5");
		res.setContentType("image/jpg");
		ServletOutputStream out = res.getOutputStream();

		try {
			String empno = req.getParameter("empno");
			String picName = new String(empno.getBytes("ISO-8859-1"), "Big5");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT picture FROM EMP_PHOTO WHERE EMPNO = '"+picName+"'");
			
			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("picture"));
				byte[] buf = new byte[4 * 1024 * 1024]; // 4M buffer
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
				in.close();
			} else {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void init() throws ServletException {
		try { //¤É¯Å¬°¨Ï¥ÎConnection Pool
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/TestDB");
			con = ds.getConnection();
		} catch (Exception e) {
			throw new UnavailableException("Couldn't load JdbcOdbcDriver");
		}
	}

	public void destroy() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
