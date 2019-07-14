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
import com.blackswan.web.entity.Notice;


@WebServlet("/notice/edit")
public class EditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeDao noticeDao = new OracleNoticeDao();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			request.setAttribute("notice", noticeDao.get(id));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		request.getRequestDispatcher("/WEB-INF/view/notice/edit.jsp").forward(request, response);
		request.getRequestDispatcher("/html/notice/edit.html").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		NoticeDao noticeDao = new OracleNoticeDao();
		
		int division = Integer.parseInt(request.getParameter("division"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		int result = 0;
		
		try {
			Notice n = noticeDao.get(id);
			n.setDivision(division);
			n.setTitle(title);
			n.setContent(content);
			
			result = noticeDao.update(n);
			request.setAttribute("notice", noticeDao.get(id));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result != 1)
			response.sendRedirect("/blackswan2/error");
		else
			response.sendRedirect("detail?id="+id);
		
		
	}
	
	
	
	
	
	
}
