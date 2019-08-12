package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BookMain {

	public static void main(String[] args) throws IOException {
		int total=0, totalsearches=0;
		InputStreamReader inputstreamreader = new InputStreamReader(System.in);
		BufferedReader breader = new BufferedReader(inputstreamreader);
		BookOperations bookoperations = new BookOperations();
		boolean quitflag=false;
		int choice;
		List<Book> books;	
		Iterator<Book> iterator;
		while(true) {
			System.out.print("\n Choice Menu");
			System.out.print("\n-------------");
			System.out.print("\n1. Display all books");
			System.out.print("\n2. Display books by name");
			System.out.print("\n3. Display books by author");
			System.out.print("\n4. Get summary by name");
			System.out.print("\n5. Get summary by author");
			System.out.print("\n6. Get total search");
			System.out.print("\n7. Get total visitors");
			System.out.print("\n9. Quit");
			System.out.print("\n-----------");
			System.out.print("\nEnter Choice : ");
			//choice = scanner.nextInt();
			choice = Integer.parseInt(breader.readLine());
			switch(choice) {
			case 1 ://all books
					books = bookoperations.getAllBooks();
					iterator = books.iterator();
					while(iterator.hasNext()) {
						System.out.println(iterator.next());
					}
					total++;
					break;
			case 2 : // books by name
					String bkname;
					System.out.print("\nEnter book name : ");
					//bkname = scanner.nextLine();
					bkname = breader.readLine();
					books = bookoperations.getBooksByName(bkname);
					iterator = books.iterator();
					while(iterator.hasNext()) {
						System.out.println(iterator.next());
					}
					totalsearches++;
					break;					
			case 3 :// books by author
					String bkauthor;
					System.out.print("\nEnter author name : ");
					//bkauthor = scanner.nextLine();
					bkauthor = breader.readLine();
					books = bookoperations.getBooksByAuthor(bkauthor);
					iterator = books.iterator();
					while(iterator.hasNext()) {
						System.out.println(iterator.next());
					}
					totalsearches++;
					break;
			case 4 : // summary by name
					System.out.println(bookoperations.getSummaryByBookName());				
					break;
			case 5 : // summary by author
					System.out.println(bookoperations.getSummaryByBookAuthor());
					break;
			case 6: // total search
					System.out.print("\nTotal searches : " + totalsearches);
					break;
			case 7: // total visitors 
					System.out.print("\nTotal visitors : " + total);
					break;
			case 9 : //quit
					quitflag=true;
					break;
			default :
				System.out.print("\nInvalid choice, try again...");
			}
			if(quitflag==true) {
				break;
			}
		}

	}

}
