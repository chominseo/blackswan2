package com.blackswan.web.controller.member.mypage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.entity.Member;

@WebServlet("/member/edit")
@MultipartConfig(

)
public class MemberEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("ssid");

		if (session.getAttribute("ssid") == null) {
			resp.sendRedirect("/error.jsp");
			return;
		}

		String add = req.getParameter("address");
		Integer ad = Integer.parseInt(req.getParameter("addnum"));
		if (add == null || add.equals("") || ad == null || ad.equals("")) {
			resp.sendRedirect("mypage?error=1");
			return;
		}
		MemberDao mDao = new OracleMemberDao();
		try {
			Member member = mDao.get(id);
			member.setAddress(add);
			member.setAddressNum(ad);
			mDao.update(member);

			req.setAttribute("member", mDao.get(id));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//req.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp").forward(req, resp);
		resp.sendRedirect("mypage#tab3");
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("ssid");

		if (session.getAttribute("ssid") == null) {
			resp.sendRedirect("/error.jsp");
			return;
		}
		
		String pw = req.getParameter("pw");
		String npw = req.getParameter("npw");
		String npw2 = req.getParameter("npw1");
		if(!npw.equals(npw2)) {
			resp.sendRedirect("mypage?error=2");
			return;
		}
		MemberDao mDao = new OracleMemberDao();
		
		try {
			Member member = mDao.get(id);
			if(!member.getPw().equals(pw)) {
				resp.sendRedirect("mypage?error=3");
				System.out.println("¿©±â");
				return;
			}
			member.setPw(npw);
			mDao.update(member);
			req.setAttribute("member", mDao.get(id));
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//req.getRequestDispatcher("/WEB-INF/view/member/mypage/mypage.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/member/mypage/mypage.html").forward(req, resp);
	}

}
