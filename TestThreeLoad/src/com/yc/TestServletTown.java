package com.yc;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.util.JsonConvert;

//@WebServlet("/town")
public class TestServletTown extends HttpServlet {
	HttpServletResponse resp;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer city_id=Integer.parseInt(req.getParameter("city_id"));
		List list=Data.backTown(city_id);
		System.out.println(list);
		String returnJson;
		try {
			returnJson = JsonConvert.returnJson(list);
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().println(returnJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void jsonUtil(Object accountList) throws Exception{
		String returnJson=JsonConvert.returnJson(accountList);
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println(returnJson);
	}
}
