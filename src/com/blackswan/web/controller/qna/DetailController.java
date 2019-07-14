package com.blackswan.web.controller.qna;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.blackswan.web.dao.QnaDao;
import com.blackswan.web.dao.oracle.OracleQnaDao;


@WebServlet("/qna/detail")
public class DetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		QnaDao qnaDao = new OracleQnaDao();
		
		
		Integer id = 53;
		
		if(req.getParameter("id") !=null && !req.getParameter("id").equals(""))
		id = Integer.parseInt(req.getParameter("id"));
		
		try {
			req.setAttribute("qna", qnaDao.get(id));
		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
//		req.getRequestDispatcher("/WEB-INF/view/qna/detail.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/qna/detail.html").forward(req, resp);
	}
	

}
