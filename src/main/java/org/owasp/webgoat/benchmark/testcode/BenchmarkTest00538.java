package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00538")
public class BenchmarkTest00538 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map49188 = new java.util.HashMap<String,Object>();
		map49188.put("keyA-49188", "a_Value"); // put some stuff in the collection
		map49188.put("keyB-49188", param.toString()); // put it in a collection
		map49188.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map49188.get("keyB-49188"); // get it back out
		bar = (String)map49188.get("keyA-49188"); // get safe value back out
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}
}