package library;

import java.util.List;

public class BookOperations {
	
	private BookDAO bookdao;
	public BookOperations() {
		bookdao=new BookDAO();
	}
	
	public List<Book> getAllBooks() {
		return bookdao.getAllBooks();
	}
	
	public List<Book> getBooksByName(String bkname) {
		return bookdao.getBooksByName(bkname);
	}
	
	public List<Book> getBooksByAuthor(String bkauthor) {
		return bookdao.getBooksByAuthor(bkauthor);
	}
	
	public String getSummaryByBookName() {
		return bookdao.getSummaryByBookName();
	}
	public String getSummaryByBookAuthor() {
		return bookdao.getSummaryByBookAuthor();
	}
}
