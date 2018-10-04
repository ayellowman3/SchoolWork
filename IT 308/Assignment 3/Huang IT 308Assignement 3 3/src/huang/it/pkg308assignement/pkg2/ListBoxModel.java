/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huang.it.pkg308assignement.pkg2;

import javax.swing.DefaultListModel;

/**
 *
 * @author RM
 */
public class ListBoxModel extends DefaultListModel {
    
    private static String[] items = {"Java 101", "English 101", "Biology 101", "Calculus 101", "Chemistry 101"};
    
    public ListBoxModel() {
        super();
        for(int i=0; i < items.length; i++) {
            super.addElement(items[i]);
        }
    }
    
}
