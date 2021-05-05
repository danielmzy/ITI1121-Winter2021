import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    // Implement the comparator method for books.

    public int compare(Book first, Book second) {

        int compareAuthors = first.getAuthor().compareTo(second.getAuthor());

        if ( compareAuthors == 0 ) {
            int compareTitles = first.getTitle().compareTo(second.getTitle());

            if ( compareTitles == 0 ) {

                if (first.getYear() < second.getYear()) {
                    return -1;
                }
                else if (first.getYear() > second.getYear()) {
                    return 1;
                }
                else {
                    return 0;
                }
            }

            return compareTitles;

        }

        return compareAuthors;
    }

}