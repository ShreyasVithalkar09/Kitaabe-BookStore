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

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		String bookName = req.getParameter("bookName");
		int units = Integer.parseInt(req.getParameter("units"));
		int bookPrice = Integer.parseInt(req.getParameter("bookPrice"));
		
//		Book book = new Book(bookId, bookName, units, bookPrice);
		BookOperationInterface boi = new BookOperations();
		String msg = boi.addBook(bookId, bookName, units, bookPrice);
		
		req.setAttribute("msg", msg);
		
		RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
		rd.forward(req, res);
	}

}
