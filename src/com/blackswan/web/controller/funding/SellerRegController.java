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
import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.SellerDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;
import com.blackswan.web.dao.oracle.OracleFundingPriceDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.dao.oracle.OracleSellerDao;
import com.blackswan.web.entity.Funding;
import com.blackswan.web.entity.FundingPrice;
import com.blackswan.web.entity.Seller;

@WebServlet("/funding/reg2")
@MultipartConfig(location = "d:\\temp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, // 5메가
		maxRequestSize = 1024 * 1024 * 5 * 5 // 5메가 5개까지
)
public class SellerRegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("ssid");
		
		int memberId = id;
		int companyTel = Integer.parseInt(request.getParameter("companyTel"));
		String companyEmail = request.getParameter("companyEmail");
		String companyName = request.getParameter("companyName");
		String companyWeb = request.getParameter("companyWeb");
		int companyComi = Integer.parseInt(request.getParameter("companyComi"));
		int companyRegNum = Integer.parseInt(request.getParameter("companyRegNum"));
		//String companyReg = request.getParameter("companyReg");
		//String companyPass = request.getParameter("companyPass");
		//Part filePart1 = request.getPart("companyReg");
		//Part filePart2 = request.getPart("companyPass");
		String companyBoss = request.getParameter("companyBoss");
		String companyBossEmail = request.getParameter("companyBossEmail");

		int result = 0;

		Seller seller = new Seller();

		Part filePart = request.getPart("companyImg");
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

//		fis.close();
		fos.close();
		
		Part filePart1 = request.getPart("companyImg");
		
		
		String fileName1 = filePart1.getSubmittedFileName();
		System.out.println(path);
		System.out.println(fileName);
		filePath = path+File.separator+fileName;
		
		 pathFile = new File(path);
		
		if(!pathFile.exists()) {
			pathFile.mkdirs();
		}
		
		 sameFile = new File(filePath);
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
		fis = filePart.getInputStream();
		fos = new FileOutputStream(filePath);
		
	
		while((i=fis.read(arr)) != -1) {
			fos.write(arr,0,i);
		}

//		fis.close();
		fos.close();
		
		
		Part filePart2 = request.getPart("companyImg");
		
		
		String fileName2 = filePart2.getSubmittedFileName();
		System.out.println(path);
		System.out.println(fileName);
		 filePath = path+File.separator+fileName;
		
		pathFile = new File(path);
		
		if(!pathFile.exists()) {
			pathFile.mkdirs();
		}
		
		sameFile = new File(filePath);
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
		fis = filePart.getInputStream();
		fos = new FileOutputStream(filePath);
		
		
		while((i=fis.read(arr)) != -1) {
			fos.write(arr,0,i);
		}

		fis.close();
		fos.close();

		seller.setId(memberId);
		seller.setCompanyTel(companyTel);
		seller.setCompanyEmail(companyEmail);
		seller.setCompanyName(companyName);
		seller.setCompanyImg(fileName);
		seller.setCompanyWeb(companyWeb);
		seller.setCompanyComi(companyComi);
		seller.setCompanyRegNum(companyRegNum);
		seller.setCompanyReg(fileName1);
		seller.setCompanyPass(fileName2);
		seller.setCompanyBoss(companyBoss);
		seller.setCompanyBossEmail(companyBossEmail);

		SellerDao sellerDao = new OracleSellerDao();
		
		try {
			result = sellerDao.insert(seller);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (result != 1)
			response.sendRedirect("error");
		else
			response.sendRedirect("reg");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		int sId = (int)session.getAttribute("ssid");
		
		SellerDao sDao = new OracleSellerDao();
		
		try {
			if(sDao.get(sId) == null) {
				//request.getRequestDispatcher("/WEB-INF/view/funding/reg2.jsp").forward(request, response);
				request.getRequestDispatcher("/html/funding/reg2.html").forward(request, response);
			} else {
				//request.getRequestDispatcher("/WEB-INF/view/funding/reg.jsp").forward(request, response);
				request.getRequestDispatcher("/html/funding/reg.html").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}