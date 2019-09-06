package com.blackswan.web.controller.admin.category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackswan.web.dao.CategoryDao;
import com.blackswan.web.dao.oracle.OracleCategoryDao;
import com.blackswan.web.entity.Category;
import com.blackswan.web.entity.view.CategoryView;

@WebServlet("/admin/category")
public class CategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		int sessionId = (int) session.getAttribute("ssid");
		if (session.getAttribute("ssid") == null && sessionId!=1) {
			resp.sendRedirect("/blackswan2/error");
			return;
		}
 
		List<CategoryView> list = new ArrayList<>();
		CategoryDao cDao = new OracleCategoryDao();
		
		int sum = 0;
		int result = 0;
		try {

			if (req.getParameter("name") != null && !req.getParameter("name").equals("")) {
				String name = req.getParameter("name");
				Category category = new Category();
				category.setName(name);
				String uuid = String.valueOf(sessionId);
				category.setAdmin_Id(uuid);
				System.out.println(category.getAdmin_Id());

				result = cDao.insert(category);
				if (result == -1) {
					resp.sendRedirect("/blackswan2/error.jsp");
					return;
				}
			
			}
			 sum = cDao.sum();
			list = cDao.countlist();
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		req.setAttribute("sum", sum);
		req.setAttribute("countlist", list);
		req.getRequestDispatcher("/WEB-INF/view/admin/category/category.jsp").forward(req, resp);
		return;

	}
}
