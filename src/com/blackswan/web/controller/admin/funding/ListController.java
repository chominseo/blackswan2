package com.blackswan.web.controller.admin.funding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;

@WebServlet("/admin/funding/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FundingDao fundingDao = new OracleFundingDao();
		
		int page = 1;
		String p_ = req.getParameter("page");
		if (p_ != null && !p_.equals(""))
			page = Integer.parseInt(p_);
		
		String field = "title";
		if (req.getParameter("field") != null && !req.getParameter("field").equals(""))
			field = req.getParameter("field");
		
		String query = "";
		if (req.getParameter("q") != null && !req.getParameter("q").equals(""))
			query = req.getParameter("q");

		try {
			req.setAttribute("aflist", fundingDao.getList(page, field, query));
			req.setAttribute("afcount", fundingDao.getCount(field, query));
		} catch (Exception e) {
			e.printStackTrace();
		}

//		req.getRequestDispatcher("/WEB-INF/view/admin/funding/list.jsp").forward(req, resp);	
		req.getRequestDispatcher("/html/admin/funding/list.html").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
