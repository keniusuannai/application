package com.tage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tage.bean.Apply;
import com.tage.dao.ApplyDAO;

public class ApplySerlvet extends HttpServlet {

	private static final long serialVersionUID = -6165312276052612819L;

	@SuppressWarnings("static-access")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("content-type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if (("list").equals(method)) {
			int apn = Integer.parseInt(request.getParameter("apn"));
			int day = Integer.parseInt(request.getParameter("day"));
			int month = Integer.parseInt(request.getParameter("month"));
			int year = Integer.parseInt(request.getParameter("year"));
			List<Apply> list = ApplyDAO.findApply(apn, day, month, year);
			JSONArray json = new JSONArray();
			json.addAll(list);
			response.getWriter().println(json);
		} else if ("init".equals(method)) {
			int month = Integer.parseInt(request.getParameter("month"));
			int year = Integer.parseInt(request.getParameter("year"));
			List<Apply> list = ApplyDAO.findApplyByYYMM(month, year);
			JSONArray json = new JSONArray();
			json.addAll(list);
			response.getWriter().println(json);
		} else if ("detail".equals(method)) {
			int apn = Integer.parseInt(request.getParameter("apn"));
			int day = Integer.parseInt(request.getParameter("day"));
			int month = Integer.parseInt(request.getParameter("month"));
			int year = Integer.parseInt(request.getParameter("year"));
			Apply apply = ApplyDAO.findApplyDetail(apn, day, month, year);
			if (apply != null) {
				response.getWriter()
						.println(new JSONObject().fromObject(apply));
			} else {
				System.out.println("没有信息");
			}

		} else if ("postapply".equals(method)) {
			Apply apply = new Apply();
			apply.setHostapn(Integer.parseInt(request.getParameter("apn")));
			apply.setHostday(Integer.parseInt(request.getParameter("day")));
			apply.setHostmonth(Integer.parseInt(request.getParameter("month")));
			apply.setHostyear(Integer.parseInt(request.getParameter("year")));
			apply.setUserid((Integer) request.getSession().getAttribute(
					"userid"));
			apply.setHostname((String) request.getSession().getAttribute(
					"organize"));
			apply.setPlace(request.getParameter("place"));
			apply.setEventname(request.getParameter("eventname"));
			apply.setEventype(request.getParameter("eventype"));
			apply.setNumber(Integer.parseInt(request.getParameter("number")));
			apply.setDescribe(request.getParameter("describe"));
			System.out.println(apply.toString());
			boolean bool = ApplyDAO.addapply(apply);
			response.getWriter().println(bool);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
