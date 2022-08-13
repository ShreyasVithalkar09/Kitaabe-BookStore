package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookOperationInterface;
import model.BookOperations;


@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
		
		BookOperationInterface boi = new BookOperations();
		String msg = boi.updateBook(bookId, bookPrice);
		
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

}
