package library;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	
	
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<Book>();
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Assignment", "sa", "");
			String query = "Select * from Book";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()) {
				Book b = new Book();
				b.setBkid(resultset.getString(1));
				b.setBkname(resultset.getString(2));
				b.setBkauthor(resultset.getString(3));
				books.add(b);			
			}
			statement.close();
			connection.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return books;
	}
	public List<Book> getBooksByName(String bkname){
		List<Book> books = new ArrayList<Book>();
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Assignment", "sa", "");
			String query = "Select * from Book where bkname=?" ;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, bkname);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Book b = new Book();
				b.setBkid(resultset.getString(1));
				b.setBkname(resultset.getString(2));
				b.setBkauthor(resultset.getString(3));
				books.add(b);			
			}
			if(books.size()>0) {
				statement = connection.prepareStatement("insert into log values (?,?,?)");
				statement.setString(1, books.get(0).getBkname());
				statement.setString(2, books.get(0).getBkauthor());
				java.util.Date date = new java.util.Date();
				statement.setDate(3, new Date(date.getYear(), date.getMonth(), date.getSeconds()));
				statement.executeUpdate();				
			}
			statement.close();
			connection.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}		
		return books;
	}
	public List<Book> getBooksByAuthor(String bkauthor){
		List<Book> books = new ArrayList<Book>();
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Assignment", "sa", "");
			String query = "Select * from Book where bkauthor=?" ;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, bkauthor);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Book b = new Book();
				b.setBkid(resultset.getString(1));
				b.setBkname(resultset.getString(2));
				b.setBkauthor(resultset.getString(3));
				books.add(b);			
			}
			if(books.size()>0) {
				statement = connection.prepareStatement("insert into log values (?,?,?)");
				statement.setString(1, books.get(0).getBkname());
				statement.setString(2, books.get(0).getBkauthor());
				java.util.Date date = new java.util.Date();
				statement.setDate(3, new Date(date.getYear(), date.getMonth(), date.getSeconds()));
				statement.executeUpdate();				
			}
			statement.close();
			connection.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}			
		return books;
	}
	
	public String getSummaryByBookName() {
		String message="";
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Assignment", "sa", "");
			String query = "Select bkname, count(*) from Book group by bkname order by 2";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			resultset.next();
			message = resultset.getString(1) + "  searched for " + resultset.getInt(2) + " times";
			statement.close();
			connection.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return message;
	}
	
	public String getSummaryByBookAuthor() {
		String message="";
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Assignment", "sa", "");
			String query = "Select bkauthor, count(*) from Book group by bkauthor order by 2";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			resultset.next();
			message = resultset.getString(1) + "  searched for " + resultset.getInt(2) + " times";
			statement.close();
			connection.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return message;
	}
	
}
