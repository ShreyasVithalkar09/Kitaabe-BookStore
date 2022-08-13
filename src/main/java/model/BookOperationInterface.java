package model;

import java.util.ArrayList;

public interface BookOperationInterface {
	String addBook(int bookId, String bookName, int units, int bookPrice);
	ArrayList<Book> getAllBooks();
	Book getABook(int bookId);
	String deleteBook(int bookId);
	String updateBook(int bookId, int bookPrice);
}
