package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelconnection.DataManager;

public class BookOperations implements BookOperationInterface {
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	@Override
	public String addBook(int bookId, String bookName, int units, int bookPrice) {
		
		Connection con = DataManager.getConnection();
		PreparedStatement pst = null;
		
		String query = "insert into books values(?, ?, ?, ?);";
		
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, bookId);
			pst.setString(2, bookName);
			pst.setInt(3, units);
			pst.setInt(4, bookPrice);
			
			int res = pst.executeUpdate();
			if(res!=1)
				return "Book not added";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Book added successfully";
	}
	
	@Override
	public ArrayList<Book> getAllBooks(){
		
		Connection con = DataManager.getConnection();	
		Statement st = null;
		
		String query= "select * from books";
		
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookList;
	}
	
	@Override
	public  Book getABook(int bookId) {
		Connection con = DataManager.getConnection();
		
		Statement pst = null;
		
		String query = "select * from books where bookId="+bookId;
		try {
			pst = con.createStatement();
			
			ResultSet rs = pst.executeQuery(query);
			
			if(rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				return book;
			}
				  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		return null;
	}
	
	@Override
	public String deleteBook(int bookId) {
		Connection con = DataManager.getConnection();
		
		PreparedStatement pst = null;
		String query = "delete from books where bookId=?";
		
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, bookId);
			int res = pst.executeUpdate();
			
			if(res!=1) {
				return "Book not deleted!";
			}
			else {
				return "Book deleted successfully";
			}
		} catch (SQLException e) {
			
			e.getMessage();
		}
		return "Book deleted successfully";
	}
	
	public String updateBook(int bookId, int bookPrice) {
		Connection con = DataManager.getConnection();
		
		PreparedStatement pst = null;
		
		String query = "update books set bookPrice=? where bookId=?";
		
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, bookPrice);
			pst.setInt(2, bookId);
			int res = pst.executeUpdate();
			
			if(res!=1)
				return "Book price not updated!";
		} catch (SQLException e) {
			e.getMessage();
		}
		return "Book price updated successfully!";
	}
	
}
