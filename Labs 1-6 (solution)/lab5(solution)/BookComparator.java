import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
	
	@Override
	public int compare(Book a, Book b) {
		int delta = a.getAuthor().compareTo(b.getAuthor());
		if (delta != 0) return delta;
		delta = a.getTitle().compareTo(b.getTitle());
		if (delta != 0) return delta;
		return a.getYear() - b.getYear();
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof BookComparator;
	}
}
