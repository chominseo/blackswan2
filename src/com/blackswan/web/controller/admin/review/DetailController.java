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

@WebServlet("/review/detail")
public class DetailController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReviewDao reviewDao = new OracleReviewDao();
		
		String sid = request.getParameter("id");
		Integer id = Integer.parseInt(sid);
		
		try {
			request.setAttribute("review", reviewDao.get(id));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		request.getRequestDispatcher("/WEB-INF/view/review/detail.jsp").forward(request, response);
		request.getRequestDispatcher("/html/review/detail.html").forward(request, response);
	}

}
