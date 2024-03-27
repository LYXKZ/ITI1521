import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    public int compare(Book a, Book b) {

        if(a == null || b == null) {
            throw new NullPointerException();
        }

        int result = 0 ;

        if(a.getAuthor() == null) {
            if(b.getAuthor() != null) {
                result = -1;
            }
        } else if(b.getAuthor() == null) {
            result = 1;
        } else {
            result = a.getAuthor().compareTo(b.getAuthor());
        }
        if(result !=0) {
            return result;
        }

        if(a.getTitle() == null) {
            if(b.getTitle() != null) {
                result = -1;
            }
        } else if(b.getTitle() == null) {
            result = 1;
        } else {
            result = a.getTitle().compareTo(b.getTitle());
        }

        if(result !=0) {
            return result;
        }

        if(a.getYear() < b.getYear()){
            return -1;
        } else if (a.getYear() == b.getYear()){
            return 0;
        } else {
            return 1;
        }

    }

}
