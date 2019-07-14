package com.blackswan.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.NoticeDao;
import com.blackswan.web.dao.oracle.OracleNoticeDao;

@WebServlet("/notice/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeDao noticeDao = new OracleNoticeDao();
		
		int page = 1;
		if(request.getParameter("page") != null && !request.getParameter("page").equals(""))
			page = Integer.parseInt(request.getParameter("page"));
		
		
		String field = "title";
		if(request.getParameter("field") != null && !request.getParameter("field").equals(""))
			field = request.getParameter("field");
		
		String query = "";
		if(request.getParameter("query") != null && !request.getParameter("query").equals(""))
			query = request.getParameter("query");
		
		
		try {
			request.setAttribute("ncount", noticeDao.getCount(field, query));
			request.setAttribute("nlist", noticeDao.getList(page, field, query));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
		request.getRequestDispatcher("/html/notice/list.html").forward(request, response);
	}
	
}
