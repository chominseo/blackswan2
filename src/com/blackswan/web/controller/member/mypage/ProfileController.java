package com.blackswan.web.controller.member.mypage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.entity.Member;

@WebServlet("/member/profile")
@MultipartConfig(
		location = "C:\\profile",
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*5,
		maxRequestSize = 1024*1024*5*5
		)
public class ProfileController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("ssid");

		if (session.getAttribute("ssid") == null) {
			resp.sendRedirect("/error.jsp");
			return;
		}
		Part filePart = req.getPart("file");
		String urlPath = "/upload";
		String path = req.getServletContext().getRealPath(urlPath);
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
		
		int result = 0;
		
		MemberDao mDao = new OracleMemberDao();
		try {
			Member member = mDao.get(id);
			member.setProfile(fileName);
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

	
}
