package com.blackswan.web.controller.funding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.FundingPriceDao;
import com.blackswan.web.dao.SellerDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;
import com.blackswan.web.dao.oracle.OracleFundingPriceDao;
import com.blackswan.web.dao.oracle.OracleSellerDao;
import com.blackswan.web.entity.Funding;
import com.blackswan.web.entity.FundingPrice;
import com.blackswan.web.entity.Seller;

@WebServlet("/funding/reg")
@MultipartConfig(
		 location="d:\\temp",   
		 fileSizeThreshold = 1024*1024,
		 maxFileSize = 1024*1024*5, //5메가
		 maxRequestSize = 1024*1024*5*5 // 5메가 5개까지
		)
public class RegController extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("ssid");
		
		
		int memberId = id; 
		int categoryId = Integer.parseInt(request.getParameter("categoryId")); 
		String title = request.getParameter("title"); 
		int tAmount = Integer.parseInt(request.getParameter("tAmount"));
		String sdate = request.getParameter("sdate"); 
		String edate = request.getParameter("edate");
		String content = request.getParameter("content");
		 
		
		Part filePart = request.getPart("introImg");
		String urlPath = "/upload";
		String path = request.getServletContext().getRealPath(urlPath);
		String fileName = filePart.getSubmittedFileName();
		System.out.println(path);
		System.out.println(fileName);
		String filePath = path+File.separator+fileName;
		
		File pathFile = new File(path);
		
		if(!pathFile.exists()) {
			pathFile.mkdirs();
		}
		
		File sameFile = new File(filePath);
		if(sameFile.exists()) {
			int ne = fileName.lastIndexOf(".");
			String name = fileName.substring(0,ne);
			String suffix = fileName.substring(ne);
		
			int parenS = name.lastIndexOf("(");
			int parenE = name.lastIndexOf(")");
			
			if(parenE == -1) {
				fileName = name +"("+1+")"+suffix;
				filePath = path+File.separator+fileName;
			}else {
				String indexC = name.substring(parenS+1,parenE);
				int indexN = Integer.parseInt(indexC);
				indexN++;
				fileName = fileName.substring(0,parenS+1)+indexN +")"+suffix;
				filePath = path+File.separator+fileName;
			}
		}
		InputStream fis = filePart.getInputStream();
		OutputStream fos = new FileOutputStream(filePath);
		
		int i = 0;
		byte[] arr = new byte[1024];
 		
		while((i=fis.read(arr)) != -1) {
			fos.write(arr,0,i);
		}
		
		Funding funding = new Funding();

		funding.setMemberId(memberId); 
		funding.setCategoryId(categoryId);
		funding.setTitle(title); 
		funding.settAmount(tAmount);
		funding.setIntroImg(fileName);
		funding.setSdate(sdate); 
		funding.setEdate(edate); 
		funding.setContent(content);
		
		int result =0;
		
		FundingDao fundingDao = new OracleFundingDao();
		
		try {
			result = fundingDao.insert(funding);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FundingPrice fundingprice = new FundingPrice();
		FundingPriceDao fundingPriceDao = new OracleFundingPriceDao();
		
		int fid;
		try {
			fid = fundingPriceDao.getLastId();
			int rPrice = Integer.parseInt(request.getParameter("rPrice"));
			String rContent = request.getParameter("rContent");
			
			fundingprice.setId(fid);
			fundingprice.setrPrice(rPrice);
			fundingprice.setrContent(rContent);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			result = fundingPriceDao.insert(fundingprice);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result != 1)
			response.sendRedirect("error");
		else
			response.sendRedirect("list");
		 
		
	}

	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/view/funding/reg.jsp").forward(request, response);
		request.getRequestDispatcher("/html/funding/reg.html").forward(request, response);
	}
}