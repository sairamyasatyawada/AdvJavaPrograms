package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ramya")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void HelloWorldServlet(){
    }
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {
		PrintWriter writer=response.getWriter();
		response.setContentType("text/plain");
		writer.println("<html>");
		writer.println("<h1>Welcome to SathyaTechs</h1>");
		writer.println("<h2>Welcome to Ratan Sir classes</h2>");
		writer.println("<h3>Welcome to ADV JAVA</h3");
		writer.println("</html>");

	}

}