package com.blackswan.web.controller.admin.funding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;

@WebServlet("/admin/funding/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FundingDao fundingDao = new OracleFundingDao();

		int id = 1;
		String id_ = req.getParameter("id");
		if (id_ != null && !id_.equals(""))
			id = Integer.parseInt(id_);

		try {
			req.setAttribute("fd", fundingDao.get(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

//		req.getRequestDispatcher("/WEB-INF/view/admin/funding/detail.jsp").forward(req, resp);	
		req.getRequestDispatcher("/html/admin/funding/detail.html").forward(req, resp);	
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
