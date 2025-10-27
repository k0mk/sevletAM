package com.koreaIT.servletAM;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.koreaIT.servletAM.dto.Article;

@WebServlet("/usr/article/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	  		Class.forName("com.mysql.cj.jdbc.Driver");
	 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSP_AM", "root", "");
	  		Statement stmt = con.createStatement();
	  		int findid = Integer.parseInt(request.getParameter("id"));
	  		ResultSet rs = stmt.executeQuery("select * from article where id =" + findid);
	  		int id = -1;
	  		Article article = null;
		  	while(rs.next()) {
		  		id = rs.getInt("id");
		  		String regDate = rs.getString("regDate");
		  		String title = rs.getString("title");
		  		String content = rs.getString("content");
		  		article = new Article(id, regDate, title, content);
	  		}
		  	request.setAttribute("article", article);
		  	request.setAttribute("id", id);
		  	request.getRequestDispatcher("/view/Article/modify.jsp").forward(request, response);
	  		rs.close();
	  		stmt.close();
	  		con.close();
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	}
}
