/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import java.util.ArrayList;

/**
 *
 * @author Pocsai Zsolt
 */
public interface WriterDAO {
    
    public ArrayList<Writer> getWritersWithSoldBooks();
    public ArrayList<Writer> getAllWriter();
    public ArrayList<SumOfSoldBookByWriter> getListOfSoldBooksByWriter();
}
