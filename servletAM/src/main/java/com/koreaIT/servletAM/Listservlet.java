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
import java.util.ArrayList;
import java.util.List;

import com.koreaIT.servletAM.dto.Article;

@WebServlet("/usr/article/list")
public class Listservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = new ArrayList<Article>();
	  	try {
	  		Class.forName("com.mysql.cj.jdbc.Driver");
	 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSP_AM", "root", "");
	  		Statement stmt = con.createStatement();
	  
	  		ResultSet rs = stmt.executeQuery("select * from article order by id desc");
	  		
		  	while(rs.next()) {
		  		int id = rs.getInt("id");
		  		String regDate = rs.getString("regDate");
		  		String title = rs.getString("title");
		  		String content = rs.getString("content");
		  		articles.add(new Article(id, regDate, title, content));
	  		}
	  
	  		rs.close();
	  		stmt.close();
	  		con.close();
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  	request.setAttribute("articles", articles);
	  	request.getRequestDispatcher("/view/Article/list.jsp").forward(request, response);
	}

}
