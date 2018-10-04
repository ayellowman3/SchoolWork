/*
 * In this file, do the following things:
 * 1) Create a constant called SALES_TAX set for a rate of 6%
 * 2) Create a getCost() method that returns a double
 */

public interface Sellable {
	public static final double SALES_TAX = 0.06;

	double getCost();
}