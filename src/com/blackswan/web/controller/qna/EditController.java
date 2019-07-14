package com.blackswan.web.controller.qna;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.QnaDao;
import com.blackswan.web.dao.oracle.OracleQnaDao;
import com.blackswan.web.entity.Qna;

@WebServlet("/qna/edit")
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		QnaDao qnaDao = new OracleQnaDao();

		Integer id = Integer.parseInt(req.getParameter("id"));

		try {
			req.setAttribute("qna", qnaDao.get(id));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		req.getRequestDispatcher("/WEB-INF/view/qna/edit.jsp").forward(req,resp);
		req.getRequestDispatcher("/html/qna/edit.html").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		QnaDao qnaDao = new OracleQnaDao();

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Integer id = Integer.parseInt(req.getParameter("id"));

		int result = 0;

		try {
			Qna q = qnaDao.get(id);
			q.setTitle(title);
			q.setContent(content);

//			result = qnaDao.update(q);
			req.setAttribute("qna", qnaDao.get(id));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (result != 1)
			resp.sendRedirect("/blackswan2/error");
		else
			resp.sendRedirect("detail?id=" + id);

	}

}
