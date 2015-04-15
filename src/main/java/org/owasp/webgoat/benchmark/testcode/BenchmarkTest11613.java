package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11613")
public class BenchmarkTest11613 extends HttpServlet {
	
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
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95452 = param; //assign
		StringBuilder b95452 = new StringBuilder(a95452);  // stick in stringbuilder
		b95452.append(" SafeStuff"); // append some safe content
		b95452.replace(b95452.length()-"Chars".length(),b95452.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95452 = new java.util.HashMap<String,Object>();
		map95452.put("key95452", b95452.toString()); // put in a collection
		String c95452 = (String)map95452.get("key95452"); // get it back out
		String d95452 = c95452.substring(0,c95452.length()-1); // extract most of it
		String e95452 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95452.getBytes() ) )); // B64 encode and decode it
		String f95452 = e95452.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g95452 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95452); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass