package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11626")
public class BenchmarkTest11626 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map24032 = new java.util.HashMap<String,Object>();
		map24032.put("keyA-24032", "a_Value"); // put some stuff in the collection
		map24032.put("keyB-24032", param.toString()); // put it in a collection
		map24032.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map24032.get("keyB-24032"); // get it back out
		bar = (String)map24032.get("keyA-24032"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass