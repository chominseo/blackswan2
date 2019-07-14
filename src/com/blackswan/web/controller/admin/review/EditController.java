package com.blackswan.web.controller.admin.review;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.ReviewDao;
import com.blackswan.web.dao.oracle.OracleReviewDao;
import com.blackswan.web.entity.view.ReviewView;

@WebServlet("/review/edit")
public class EditController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Integer id = Integer.parseInt(request.getParameter("id"));

		ReviewDao reviewDao = new OracleReviewDao();
		ReviewView r;
		int result =0;
		
		try {
			r = reviewDao.get(id);
			r.setTitle(title);
			r.setContent(content);
			result = reviewDao.update(r);
			request.setAttribute("review", reviewDao.get(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result != 1)
			response.sendRedirect("error");
		else
			response.sendRedirect("detail?id="+id);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ReviewDao reviewDao = new OracleReviewDao();
		ReviewView r;
		int result =0;
		
		try {
			r = reviewDao.get(id);
			request.setAttribute("review", reviewDao.get(id));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		request.getRequestDispatcher("/WEB-INF/view/review/edit.jsp").forward(request, response);
		request.getRequestDispatcher("/html/review/edit.html").forward(request, response);
		
	}
}
