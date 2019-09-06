package com.blackswan.web.controller.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.entity.Member;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/html/member/login.html").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		MemberDao memberDao = new OracleMemberDao();

		try {
			Member member = memberDao.get(email);

			if (member == null) {	//가입 되어있지 않을 때
				resp.sendRedirect("/blackswan2/error");
			}
			else if (!member.getPw().equals(pw)) {	//비밀번호 틀렸을 때
				resp.sendRedirect("/blackswan2/error");
			} else {	//세션 저장
				HttpSession session = req.getSession();
				session.setAttribute("ssid", member.getId());
				req.setAttribute("hmember", member);
				resp.sendRedirect("/blackswan2/index");

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}




