package com.blackswan.web.controller.funding;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.NoticeDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;
import com.blackswan.web.dao.oracle.OracleNoticeDao;

@WebServlet("/funding/list")
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FundingDao fundingDao = new OracleFundingDao();
		
		int page = 1;
		String p_ = request.getParameter("page");
		
		if(p_ != null && !p_.equals(""))
			page = Integer.parseInt(p_);
		
		
//		String field = "title";
//		if(request.getParameter("field") != null && request.getParameter("field").equals(""))
//			field = request.getParameter("field");
//		
//		String query = "";
//		if(request.getParameter("query") != null && request.getParameter("query").equals(""))
//			query = request.getParameter("query");
		
		try {
			request.setAttribute("flist", fundingDao.getList(page));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		request.getRequestDispatcher("/WEB-INF/view/funding/list.jsp").forward(request, response);
		
		request.getRequestDispatcher("/html/funding/list.html").forward(request, response);
	}

}