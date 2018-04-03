/**
 * This is a tip calculating android application
 * CPSC 312-01, Fall 2017
 * Programming Assignment #3
 * No sources to cite.
 *
 * @author Brandon Kelly
 * @version v1.0 10/04/17
 */
package com.example.brandonkelly.tipcalculator;

public class TipCalculator {

    double bill;    // Bill with type double as requested
    int tip;    // Tip with type int as requested

    // Constructor for TipCalculator
    public TipCalculator(double bill, int tip){
        this.bill = bill;
        this.tip = tip;
    }
    // Return the tip amount calculation
    public double calculateTip(){
        return ((this.bill * this.tip) / 100);
    }

    // Calculates the total bill using tip and bill total
    public  double calculateTotalBill(){
        return calculateTip() + this.bill;
    }

    // Setter for the bill with type double
    public void set_bill(double b){
        this.bill = b;
    }

    // Setter for tip percent with type int
    public void set_percent_tip(int tip){
        this.tip = tip;
    }

    // Getter to return the bill amount
    public double get_bill(){
        return this.bill;
    }

    // Getter for tip percentage
    public double get_tip(){
        return this.tip;
    }

}