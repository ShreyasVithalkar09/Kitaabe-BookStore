package model;

public class Book {
	private int bookId;
	private String bookName;
	private int units;
	private int bookPrice;
	
	public Book(int bookId, String bookName, int units, int bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.units = units;
		this.bookPrice = bookPrice;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public int getUnits() {
		return units;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", units=" + units + ", bookPrice=" + bookPrice
				+ "]";
	}
	
	
	
}
