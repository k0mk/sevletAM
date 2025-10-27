package com.koreaIT.servletAM;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/usr/article/Dowrtie")
public class DoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String sql = "insert into article"
				+ " set regDate = now()"
					+ ", updateDate = now()"
					+ ", title = '" + title  + "'"
					+ ", content = '" + content  + "';";
		try {
	  		Class.forName("com.mysql.cj.jdbc.Driver");
	 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSP_AM", "root", "");
	  		Statement stmt = con.createStatement();
	  		
	  		stmt.executeUpdate(sql);
	  		
	  
	  		stmt.close();
	  		con.close();
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
		response.setContentType("text/html; charset=UTF-8;");
		response.getWriter().append("<script>alert('성공적으로 추가되었습니다'); location.replace('/usr/article/list');</script>");
	}
}
