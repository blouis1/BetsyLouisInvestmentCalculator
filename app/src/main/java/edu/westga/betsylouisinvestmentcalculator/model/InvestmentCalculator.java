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

    /**
     * Calculates the future annuity value given principal, rate and number of periods.
     * <preconditions>
     *     rate >= 0
     *     principal >= 0
     *     number of periods >= 0
     * </preconditions>
     * @return the future value of annuity
     */
    public double getFutureValueOfAnnuity() {
        if (this.principal < 0) {
            throw new IllegalArgumentException("Principal must not be negative");
        }
        if (this.rate < 0) {
            throw new IllegalArgumentException("Rate must not be negative");
        }
        if (this.numberOfPeriods < 0) {
            throw new IllegalArgumentException("Number of periods must not be negative");
        }

        if (this.rate == 0) {
            return this.principal * this.numberOfPeriods;
        }

        return this.principal * ((Math.pow((1 + this.rate), this.numberOfPeriods) - 1)/this.rate);

    }
}
