public class Book {
	
	private String author, title;
	private int year;
	
	public Book (String author, String title, int year) {
		this.author = author;
		this.title = title;
		this.year = year;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Book)) return false;
		Book otherBook = (Book)other;
		return nullableEquals(author, otherBook.getAuthor()) && nullableEquals(title, otherBook.getTitle()) && year == otherBook.getYear();
	}
	
	@Override
	public String toString() {
		return String.format("%s:%s (%d)", author, title, year);
	}
	
	private boolean nullableEquals(Object a, Object b) {
		if (a == null) {
			if (b == null) {
				return true;
			}
			return false;
		} else if (b == null) {
			return false;
		}
		return a.equals(b);
	}
}
