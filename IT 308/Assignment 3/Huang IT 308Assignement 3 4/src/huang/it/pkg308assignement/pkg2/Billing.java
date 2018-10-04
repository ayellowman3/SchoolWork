/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huang.it.pkg308assignement.pkg2;

/**
 *
 * @author George
 */
public class Billing{
    String type;
    String accountNum;
    String qty;
    String totalCost;
    String comments;
    boolean same;
    String product;
    int productIndex;
    
    public Billing(){
        this.type = "";
	this.accountNum = "";
	this.qty = "1";
	this.totalCost = "50.95";
        this.comments = "";
        this.product = "";
    }

    public Billing(String type, String accountNum, String qty, String totalCost, String comments, boolean same, String product, int productIndex){
    	this.type = type;
        this.accountNum = accountNum;
	this.qty = qty;
	this.totalCost = totalCost;
        this.comments = comments;
        this.product = product;
        this.productIndex = productIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isSame() {
        return same;
    }

    public void setSame(boolean same) {
        this.same = same;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getProductIndex() {
        return productIndex;
    }

    public void setProductIndex(int productIndex) {
        this.productIndex = productIndex;
    }

    @Override
    public String toString() {
        return "Billing{" + "type=" + type + ", accountNum=" + accountNum + ", qty=" + qty + ", totalCost=" + totalCost + ", comments=" + comments + ", same=" + same + ", product=" + product + ", productIndex=" + productIndex + '}';
    }

    
    
    
    
}