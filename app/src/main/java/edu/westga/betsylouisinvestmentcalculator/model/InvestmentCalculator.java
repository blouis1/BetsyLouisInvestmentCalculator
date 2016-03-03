package edu.westga.betsylouisinvestmentcalculator.model;

/**
 * Created by Betsy on 3/3/2016.
 */
public class InvestmentCalculator {
    private double principal;
    private double rate;
    private int numberOfPeriods;

    public double getPrincipal() {
        return this.principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate/100.0;
    }

    public int getNumberOfPeriods() {
        return this.numberOfPeriods;
    }

    public void setNumberOfPeriods(int numberOfPeriods) {
        this.numberOfPeriods = numberOfPeriods;
    }

    public double getFutureValueOfAnnuity() {
        return this.principal * ((Math.pow((1 + this.rate), this.numberOfPeriods) - 1)/this.rate);

    }
}
