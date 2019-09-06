package com.blackswan.web.controller.member.mypage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.entity.Funding;
import com.blackswan.web.entity.view.FundingView;

@WebServlet("/member/mypage")
public class MypageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		int id;
		if(session.getAttribute("ssid") != null && !session.getAttribute("ssid").equals(""))
			id = (int) session.getAttribute("ssid");
		else {
			resp.sendRedirect("/blackswan2/error");
			return;
			
		}
		MemberDao mDao = new OracleMemberDao();
		FundingDao fundingDao = new OracleFundingDao();
		
		try {
			req.setAttribute("member", mDao.get(id));
			req.setAttribute("flist", fundingDao.getViewMypage(id));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//req.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/member/mypage.html").forward(req, resp);

	}
}
