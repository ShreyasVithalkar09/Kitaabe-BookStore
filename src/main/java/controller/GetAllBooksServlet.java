package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookOperationInterface;
import model.BookOperations;


@WebServlet("/GetAllBooksServlet")
public class GetAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		BookOperationInterface boi = new BookOperations();
		ArrayList<Book> bookList = boi.getAllBooks();
		
		req.setAttribute("bookList", bookList);
		
		RequestDispatcher rd = req.getRequestDispatcher("booklist.jsp");
		rd.forward(req, res);
	}

	

}
