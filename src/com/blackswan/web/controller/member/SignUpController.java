package com.blackswan.web.controller.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.entity.Member;

@WebServlet("/member/signUp")
public class SignUpController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getRequestDispatcher("/WEB-INF/view/member/signUp.jsp").forward(request, response);
		request.getRequestDispatcher("/html/member/signUp.html").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");

		int phone = Integer.parseInt(request.getParameter("phone"));

		String eventAgree = "N";
		if(request.getParameter("event_agree") != null && !request.getParameter("event_agree").equals(""))
			eventAgree =request.getParameter("event_agree");
		
		
		Member member = new Member();
		member.setEmail(email);
		member.setName(name);
		member.setPw(pw);
		member.setPhone(phone);
		member.setEventAgree(eventAgree);
		
		MemberDao memberDao = new OracleMemberDao();
		
		int result = 0;
		
		try {
			result = memberDao.insert(member);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(result != 1)
			response.sendRedirect("/blackswan2/error");
		else
			response.sendRedirect("/blackswan2/index");
		
		
		
	}

}
