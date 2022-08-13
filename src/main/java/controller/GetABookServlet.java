package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookOperationInterface;
import model.BookOperations;


@WebServlet("/GetABookServlet")
public class GetABookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		BookOperationInterface boi = new BookOperations();
		Book book = boi.getABook(bookId);
		
		if(book == null) {
			String errMsg = "Sorry! Book not found";
			request.setAttribute("errMsg", errMsg);
		}
		else {
			request.setAttribute("book", book);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("singebook.jsp");
		rd.forward(request, response);
		
		
	}

}
