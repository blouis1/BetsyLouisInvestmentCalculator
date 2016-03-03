package edu.westga.betsylouisinvestmentcalculator;

import org.junit.Test;

import edu.westga.betsylouisinvestmentcalculator.model.InvestmentCalculator;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class CalculateFutureValueTests {

    private InvestmentCalculator calculator;

    public CalculateFutureValueTests() {
        this.calculator = new InvestmentCalculator();
    }

    /*
    Test method for {@Link edu.westga.BetsyLouisInvestmentCalculator.model.InvestmentCalculator.setRate(java.lang.Double)}
     */
    @Test
    public void testSetterSetsCorrectRate() {
        this.calculator.setRate(2);
        assertEquals(0.02, this.calculator.getRate(), 0);
    }

    @Test
    public void testFutureValueIsCorrectWithNormalInputs() {
        this.calculator.setPrincipal(1000);
        this.calculator.setRate(2);
        this.calculator.setNumberOfPeriods(5);

        assertEquals(5204.04, this.calculator.getFutureValueOfAnnuity(), 0.01);
    }

    @Test
    public void testFutureValueIsPrincipalTimesNumberOfPeriodsWhenRateIs0() {
        this.calculator.setPrincipal(1000);
        this.calculator.setRate(0);
        this.calculator.setNumberOfPeriods(1);

        assertEquals(1000, this.calculator.getFutureValueOfAnnuity(), 0.01);
    }

    @Test
    public void testFutureValueIs0WhenPrincipalIs0() {
        this.calculator.setPrincipal(0);
        this.calculator.setRate(1);
        this.calculator.setNumberOfPeriods(1);

        assertEquals(0, this.calculator.getFutureValueOfAnnuity(), 0.01);
    }
}
