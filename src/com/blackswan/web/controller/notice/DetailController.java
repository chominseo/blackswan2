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

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeDao noticeDao = new OracleNoticeDao();

		Integer id = 53;
		
		if(request.getParameter("id") != null && !request.getParameter("id").equals(""))
			id = Integer.parseInt(request.getParameter("id"));

		try {
			request.setAttribute("notice", noticeDao.get(id));
			request.setAttribute("prev", noticeDao.getPrev(id));
			request.setAttribute("next", noticeDao.getNext(id));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);
		request.getRequestDispatcher("/html/notice/detail.html").forward(request, response);
	}

}
