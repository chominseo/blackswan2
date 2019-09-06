package com.blackswan.web.controller.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/qna/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
//		req.getRequestDispatcher("/WEB-INF/view/qna/reg.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/qna/reg.html").forward(req, resp);
		
	}
	
}
