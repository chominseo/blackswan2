
package com.blackswan.web.controller.funding;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.FundingPriceDao;
import com.blackswan.web.dao.ReviewDao;
import com.blackswan.web.dao.SelQnaDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;
import com.blackswan.web.dao.oracle.OracleFundingPriceDao;
import com.blackswan.web.dao.oracle.OracleReviewDao;
import com.blackswan.web.dao.oracle.OracleSelQNADao;

@WebServlet("/funding/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FundingDao fundingDao = new OracleFundingDao();
		FundingPriceDao fundingPrice = new OracleFundingPriceDao();
		ReviewDao rDao = new OracleReviewDao();
		SelQnaDao sDao = new OracleSelQNADao();
		Integer id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		try {
			req.setAttribute("qna", sDao.getList(id));
			req.setAttribute("review", rDao.getList(1, id));
			req.setAttribute("funding", fundingDao.get(id));
			req.setAttribute("price", fundingPrice.getList(id));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		req.getRequestDispatcher("/WEB-INF/view/funding/detail.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/funding/detail.html").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
