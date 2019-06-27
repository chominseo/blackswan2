package com.blackswan.web.controller.funding;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackswan.web.dao.BuyingDao;
import com.blackswan.web.dao.FundingPriceDao;
import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleBuyingDao;
import com.blackswan.web.dao.oracle.OracleFundingPriceDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.entity.Buying;
import com.blackswan.web.entity.Member;

@WebServlet("/funding/buying")
public class buyingController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		int sessionId;
		if(session.getAttribute("ssid") != null && !session.getAttribute("ssid").equals(""))
			sessionId = (int) session.getAttribute("ssid");

		
		FundingPriceDao fundingPrice = new OracleFundingPriceDao();
		
		int id = 0;
		String id_ = request.getParameter("id");
		
		if(id_ != null && !id_.equals(""))
			id= Integer.parseInt(id_);
		
		try {
			request.setAttribute("fpr", fundingPrice.getList(id));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/WEB-INF/view/funding/buying.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int sessionId = (int) session.getAttribute("ssid");
		
		int memberId = sessionId;
		int payPr = Integer.parseInt(request.getParameter("pay_pr"));
		String adress = request.getParameter("adress");
		int fundingId = Integer.parseInt(request.getParameter("funding_id"));
		int adressNum = Integer.parseInt(request.getParameter("adress_num"));
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String req = request.getParameter("req");
		
		
		
		Buying buying = new Buying();
		buying.setPayPr(payPr);
		buying.setFundingId(fundingId);
		buying.setName(name);
		buying.setPhone(phone);
		buying.setAddressNum(adressNum);
		buying.setAddress(adress);
		buying.setMemberId(memberId);
		buying.setReq(req);

		BuyingDao buyingDao = new OracleBuyingDao();
		
		int result = 0;
		
		try {
			result = buyingDao.insert(buying);		
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
