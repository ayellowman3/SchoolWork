package huang.it.pkg308assignement.pkg2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */
public class Address {
    private String fName;
    private String lName;
    private String street;
    private String city;
    private String state;
    private int stateIndex;

    public int getStateIndex() {
        return stateIndex;
    }

    public void setStateIndex(int stateIndex) {
        this.stateIndex = stateIndex;
    }
    private String zip;
    private String country;

    
    public Address(){
        this.fName = "";
        this.lName = "";
        this.street = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.country = "";
    }
    
    public Address(String fName,String lName,String street,String city,String state,int stateIndex, String zip,String country){
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.stateIndex = stateIndex;
        this.zip = zip;
        this.country = country;
    }



    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" + "fName=" + fName + ", lName=" + lName + ", street=" + street + ", city=" + city + ", state=" + state + ", stateIndex=" + stateIndex + ", zip=" + zip + ", country=" + country + '}';
    }

    
    
}
