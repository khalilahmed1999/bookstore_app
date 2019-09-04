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
public interface AuthorsOfBookDAO {
    
    public AuthorsOfBook getAuthorsOfBook(long isbn);
    public int addAuthorsOfBook(AuthorsOfBook authorsOfBook);
    public int modifyAuthorsOfBook(AuthorsOfBook newAOB);
    public int deleteAuthorsOfBook(long isbn);
}
