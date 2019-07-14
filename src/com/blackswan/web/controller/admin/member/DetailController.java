package com.blackswan.web.controller.admin.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;

@WebServlet("/admin/member/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberDao memberDao = new OracleMemberDao();

		int id = 1;
		String id_ = req.getParameter("id");
		if (id_ != null && !id_.equals(""))
			id = Integer.parseInt(id_);

		try {
			req.setAttribute("md", memberDao.get(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

//		req.getRequestDispatcher("/WEB-INF/view/admin/member/detail.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/admin/member/detail.html").forward(req, resp);
		
	}
	
}
