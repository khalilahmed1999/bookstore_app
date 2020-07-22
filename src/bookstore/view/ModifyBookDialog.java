/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.model.Book;

/**
 *
 * @author Pocsai Zsolt
 */
public class ModifyBookDialog extends Dialog {
    
    public ModifyBookDialog(Book book) {
        super("fxml/ModifyBookGUI.fxml", "Modify Book");
        ModifyBookController dialogController = fxmlLoader.getController();
        dialogController.setBook(book);
        this.show();
    }
}
