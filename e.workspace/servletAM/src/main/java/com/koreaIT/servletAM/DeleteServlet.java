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

@WebServlet("/usr/article/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	  		Class.forName("com.mysql.cj.jdbc.Driver");
	 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSP_AM", "root", "");
	  		Statement stmt = con.createStatement();
	  		int id = Integer.parseInt(request.getParameter("id"));
	  		String sql = "delete from article"
	  				+ " where id=" + id;
	  		stmt.executeUpdate(sql);
	  		
	  
	  		stmt.close();
	  		con.close();
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
		response.setContentType("text/html; charset=UTF-8;");
		response.getWriter().append("<script>alert('성공적으로 삭제되었습니다'); location.replace('/usr/article/list');</script>");
	}
}
