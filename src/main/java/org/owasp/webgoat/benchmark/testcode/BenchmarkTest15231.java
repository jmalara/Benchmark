package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15231")
public class BenchmarkTest15231 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql, java.sql.ResultSet.TYPE_FORWARD_ONLY, 
							java.sql.ResultSet.CONCUR_READ_ONLY );
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar;
		String guess = "ABC";
		char switchTarget = guess.charAt(2);
		
		// Simple case statement that assigns param to bar on conditions 'A' or 'C'
		switch (switchTarget) {
		  case 'A':
		        bar = param;
		        break;
		  case 'B': 
		        bar = "bobs_your_uncle";
		        break;
		  case 'C':
		  case 'D':        
		        bar = param;
		        break;
		  default:
		        bar = "bobs_your_uncle";
		        break;
		}
	
		return bar;	
	}
}