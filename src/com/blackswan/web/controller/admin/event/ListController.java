package com.blackswan.web.controller.admin.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackswan.web.dao.SelEventDao;
import com.blackswan.web.dao.oracle.OracleSelEventDao;
import com.blackswan.web.entity.SelEvent;
import com.blackswan.web.entity.view.SelEventView;

@WebServlet("/admin/event/list")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int sessionId = (int) session.getAttribute("ssid");
		if (session.getAttribute("ssid") == null && sessionId!=1) {
			resp.sendRedirect("/blackswan2/error");
			return;
		}

			int page = 1;
			String p = req.getParameter("page");
			String title = "";
			String state = "";
			String edate = "";
			String sdate = "";

			String new_title = req.getParameter("title");
			String new_state = req.getParameter("state");
			String new_sdate = req.getParameter("sdate");
			String new_edate = req.getParameter("edate");

			String old_title = req.getParameter("old_title");
			String old_sdate = req.getParameter("old_sdate");
			String old_edate = req.getParameter("old_edate");
			String old_state = req.getParameter("old_state");

			if (p != null && !p.equals(""))
				page = Integer.parseInt(p);

			if (new_title != null) {
				title = new_title;
				if (old_title != null && !old_title.equals(new_title))
					page = 1;
			}
			if (new_state != null) {
				state = new_state;
				if (old_state != null && !old_state.equals(new_state))
					page = 1;
			}
			if (new_sdate != null) {
				sdate = new_sdate;
				if (old_sdate != null && !old_sdate.equals(new_sdate))
					page = 1;
			}
			if (new_edate != null) {
				edate = new_edate;
				if (old_edate != null && !old_edate.equals(new_edate))
					page = 1;
			}
			SelEventDao sDao = new OracleSelEventDao();
			List<SelEventView> list = new ArrayList<>();
			try {
				int count = sDao.getCount(title, sdate, edate, state);
				int scount = sDao.getCount(title, sdate, edate, "2");
				list = sDao.getList(page, title, sdate, edate, state);
				req.setAttribute("scount", scount);
				req.setAttribute("count", count);
				req.setAttribute("event", list);
				req.setAttribute("ssid", sessionId);

			} catch (Exception e) {
				e.printStackTrace();
			}
//			req.getRequestDispatcher("/WEB-INF/view/admin/event/list.jsp").forward(req, resp);
		req.getRequestDispatcher("/html/admin/event/list.html").forward(req, resp);
	}
}
