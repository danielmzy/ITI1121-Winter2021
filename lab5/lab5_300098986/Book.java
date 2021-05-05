public class Book {

    private String author;
    private String title;
    private int year;

    public Book (String author, String title, int year) {
        // Your code here
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        // Your code here
        return author;
    }

    public String getTitle() {
        // Your code here
        return title;
    }

    public int getYear() {
        // Your code here
        return year;
    }

    public boolean equals(Object other) {
        // Your code here

        // testing type of other
        if ( !(other instanceof Book) ) {
            return false;
        }

        Book newOther = Book.class.cast(other);

        // Author
        if (author == null && newOther.author == null) {
            return (title.equals(newOther.title) && year == newOther.year);
        }

        // Title
        if (title == null && newOther.title == null) {
            return (author.equals(newOther.author) && year==newOther.year);
        }

        if ( (title == null || newOther.title == null || author == null || newOther.author==null) ) {
            return false;
        }

        return (author.equals(newOther.author) && title.equals(newOther.title) && year==newOther.year );

    }

    public String toString() {
        // Your code here
        return(author + ": " + title + " (" + year + ")");
    }

    public static void main(String[] args) {
        System.out.println(null ==" hello");
    }

}