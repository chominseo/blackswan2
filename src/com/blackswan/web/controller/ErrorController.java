package com.blackswan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/error.html").forward(req, resp);
		
	}
	
}
