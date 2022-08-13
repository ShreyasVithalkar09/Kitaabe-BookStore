package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		if((uname.equalsIgnoreCase("Admin")) && (pass.equals("yourpassword"))) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			
			String msg = "Logged in successfully!";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		else {
			String errMsg = "Invalid username or password";
			request.setAttribute("msg", errMsg);
			RequestDispatcher rd = request.getRequestDispatcher("loginform.jsp");
			rd.include(request, response);
		}
		
		
	}

}
