package library;

public class Book {
	private String bkid, bkname, bkauthor;
	public Book() {
		
	}
	public Book(String bkid, String bkname, String bkauthor) {
		this.bkid=bkid;
		this.bkname=bkname;
		this.bkauthor=bkauthor;		
	}
	public String getBkid() {
		return bkid;
	}
	public void setBkid(String bkid) {
		this.bkid = bkid;
	}
	public String getBkname() {
		return bkname;
	}
	public void setBkname(String bkname) {
		this.bkname = bkname;
	}
	public String getBkauthor() {
		return bkauthor;
	}
	public void setBkauthor(String bkauthor) {
		this.bkauthor = bkauthor;
	}
	
	@Override
	public String toString() {
		String value;
		value = bkid + ", " + bkname + ", " + bkauthor;
		return value;
	}
}
