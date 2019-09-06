package com.blackswan.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;

@WebServlet("/index")
public class IndexController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FundingDao fundingDao = new OracleFundingDao();
		
		try {
			req.setAttribute("iflist", fundingDao.getList());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		//req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/index.html").forward(req, resp);

	}

}