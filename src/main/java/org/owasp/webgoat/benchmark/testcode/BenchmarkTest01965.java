package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01965")
public class BenchmarkTest01965 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a85011 = param; //assign
		StringBuilder b85011 = new StringBuilder(a85011);  // stick in stringbuilder
		b85011.append(" SafeStuff"); // append some safe content
		b85011.replace(b85011.length()-"Chars".length(),b85011.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85011 = new java.util.HashMap<String,Object>();
		map85011.put("key85011", b85011.toString()); // put in a collection
		String c85011 = (String)map85011.get("key85011"); // get it back out
		String d85011 = c85011.substring(0,c85011.length()-1); // extract most of it
		String e85011 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85011.getBytes() ) )); // B64 encode and decode it
		String f85011 = e85011.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f85011); // reflection
		
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}
}