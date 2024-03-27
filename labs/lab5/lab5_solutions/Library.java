import java.util.ArrayList;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();

    public void addBook (Book b){
        if(b==null)
            return;
        library.add(b);
    }

    public Book getBook (int pos){
        // pre-condition: pos is a valid index
        return library.get(pos);
    }

    public void sort() {
        library.sort(new BookComparator());
    }


    public void printLibrary(){

        for (int i=0; i<library.size(); i++) {
            System.out.println(library.get(i));
        }

    }


}
