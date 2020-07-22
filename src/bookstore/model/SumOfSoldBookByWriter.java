/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

/**
 *
 * @author Pocsai Zsolt
 */
public class SumOfSoldBookByWriter {
    private String writerName;
    private String bookTitle;
    private int sold;
    
    SumOfSoldBookByWriter(String writerName, String bookTitle, int sold) {
        this.writerName = writerName;
        this.bookTitle = bookTitle;
        this.sold = sold;
    }
    
    public String getWriterName() {
        return writerName;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public int getSold() {
        return sold;
    }
}
