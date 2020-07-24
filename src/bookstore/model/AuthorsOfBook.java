package bookstore.model;

import java.util.ArrayList;


public class AuthorsOfBook {
    private long isbn;
    private ArrayList<String> authors = new ArrayList<>();
    
    public AuthorsOfBook(long isbn) {
        this.isbn = isbn;
    }
    
    public long getIsbn() {
        return isbn;
    }
    
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    public ArrayList<String> getAuthors() {
        return authors;
    }
    
    public String getAuthorsLabel() {
        String authorsText = "";
        for (int i = 0; i < authors.size(); i++) {
            authorsText = authorsText.concat(authors.get(i));
            if (i + 1 < authors.size()) {
                authorsText = authorsText.concat(", ");
            }
        }
        return authorsText;
    }
}
