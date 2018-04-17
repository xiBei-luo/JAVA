package com.yc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.util.JsonConvert;


//@WebServlet("/province")
public class TestServletProvince extends HttpServlet{
	HttpServletResponse resp;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List list=Data.backProvince();
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
		//HttpServletResponse response=ServiceContext.getResponse();
		//log.info("JSON∏Ò Ω:"+accountList.toString());
		String returnJson=JsonConvert.returnJson(accountList);
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println(returnJson);
	}
}
