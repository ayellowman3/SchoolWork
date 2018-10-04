/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huang.it.pkg308assignement.pkg2;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

class State {
    private String description;
    private String code;

    public State(String desc, String code) {
        this.description = desc;
        this.code = code;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return description ;
    }
    
}
/**
 *
 * @author RM
 */
public class ComboBoxModel extends DefaultComboBoxModel {
    
    private static String[] states = {"Virginia", "Maryland", "New Jersey", "New York", "Delaware", "Kentucky"};
    
    private static State[] stateList = {new State("Virginia", "VA"), new State("Maryland", "MD"), new State("Delware", "DE")};
    
    public ComboBoxModel() {
        //stateList.add(new State("Virginia", "VA"));
        super(stateList);
    }
    
}
