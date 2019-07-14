package com.blackswan.web.controller.funding;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;

@WebServlet("/funding/search")
public class SearchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FundingDao fundingDao = new OracleFundingDao();
		
		int page = 1;
		String p_ = req.getParameter("page");
		if(p_ != null && !p_.equals(""))
			page = Integer.parseInt(p_);
		
		String query = "";
		if(req.getParameter("query") != null && !req.getParameter("query").equals(""))
			query = req.getParameter("query");
		
		try {
			req.setAttribute("srlist", fundingDao.getList(page, "title", query));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		req.getRequestDispatcher("/WEB-INF/view/funding/search.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/funding/search.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
