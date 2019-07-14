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

@WebServlet("/notice/reg")
public class RegController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getRequestDispatcher("/WEB-INF/view/notice/reg.jsp").forward(request, response);
		request.getRequestDispatcher("/html/notice/reg.html").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int division = Integer.parseInt(request.getParameter("division"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Notice notice = new Notice();
		notice.setDivision(division);
		notice.setTitle(title);
		notice.setContent(content);
		
		NoticeDao noticeDao = new OracleNoticeDao();
	
		int result = 0;
		
		try {
			result = noticeDao.insert(notice);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(result != 1)
			response.sendRedirect("/blackswan2/error");
		else
			response.sendRedirect("list");
		
	}

}
