package com.blackswan.web.controller.qna;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.QnaDao;
import com.blackswan.web.dao.QnaDao;
import com.blackswan.web.dao.oracle.OracleQnaDao;
import com.blackswan.web.dao.oracle.OracleQnaDao;
import com.blackswan.web.entity.Qna;
import com.blackswan.web.entity.Qna;

@WebServlet("/qna/reply")
public class ReplyController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//request.getRequestDispatcher("/WEB-INF/view/qna/reply.jsp").forward(request, response);
		request.getRequestDispatcher("/html/qna/reply.html").forward(request, response);

	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		int id = Integer.parseInt(request.getParameter("id"));
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//
//		Qna qna = new Qna();
//
//		qna.setTitle(title);
//		qna.setContent(content);
//
//		QnaDao qnaDao = new OracleQnaDao();
//
//		int result = 0;
//
//		try {
//			result = qnaDao.insert(qna);
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//
//		if (result != 1)
//			response.sendRedirect("/blackswan2/error");
//		else
//			response.sendRedirect("list");
//
//		request.getRequestDispatcher("/WEB-INF/view/qna/replyreg.jsp").forward(request, response);
//	}
}
