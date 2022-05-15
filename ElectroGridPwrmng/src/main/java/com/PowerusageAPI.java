package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PowerusageAPI
 */
@WebServlet("/PowerusageAPI")
public class PowerusageAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Powerusage powerusageObj = new Powerusage();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PowerusageAPI() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 // Convert request parameters to a Map
 	private static Map getParasMap(HttpServletRequest request) {
 		// TODO Auto-generated method stub
 		Map<String, String> map = new HashMap<String, String>();
 		try
 		 {
 		 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
 		 String queryString = scanner.hasNext() ?
 		 scanner.useDelimiter("\\A").next() : "";
 		 scanner.close();
 		 String[] params = queryString.split("&");
 		 for (String param : params)
 		 {
 		 String[] p = param.split("=");
 		 map.put(p[0], p[1]);
 		 }
 		 }
 		catch (Exception e)
 		 {
 		 } 

 		return map;
 	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = powerusageObj.InsertPowerusage(request.getParameter("pwrusagedataID"),
				 request.getParameter("username"),
				request.getParameter("useraddress"),
				request.getParameter("noofpwrunits"),
				request.getParameter("unitprice"),
				request.getParameter("totalprice"),
				request.getParameter("payedmonth"));
				response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Map paras = getParasMap(request);
		 String output = powerusageObj.UpdatePowerusage(paras.get("hidrecordIDUpdate").toString(),
		 paras.get("pwrusagedataID").toString(),
		paras.get("username").toString(),
		paras.get("useraddress").toString(),
		paras.get("noofpwrunits").toString(),
		paras.get("unitprice").toString(),
		paras.get("totalprice").toString(),
		paras.get("payedmonth").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		 String output = powerusageObj.DeletePowerusage(paras.get("recordID").toString());
		response.getWriter().write(output);
	}

}
