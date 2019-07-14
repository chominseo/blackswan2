package com.blackswan.web.controller.admin.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;

@WebServlet("/admin/member/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberDao memberDao = new OracleMemberDao();

		int page = 1;
		String p_ = req.getParameter("page");
		if (p_ != null && !p_.equals(""))
			page = Integer.parseInt(p_);
		
		String field = "name";
		if (req.getParameter("field") != null && !req.getParameter("field").equals(""))
			field = req.getParameter("field");
		
		String query = "";
		if (req.getParameter("q") != null && !req.getParameter("q").equals(""))
			query = req.getParameter("q");

		try {
			req.setAttribute("member", memberDao.getList(page, "name", query));
			req.setAttribute("count", memberDao.getCount(field, query));
		} catch (Exception e) {
			e.printStackTrace();
		}

//		req.getRequestDispatcher("/WEB-INF/view/admin/member/list.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/admin/member/list.html").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String field = req.getParameter("field");
		MemberDao memberDao = new OracleMemberDao();
		
		resp.sendRedirect("list");
		
	}
	
}
