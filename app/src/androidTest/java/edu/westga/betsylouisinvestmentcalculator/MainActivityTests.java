package edu.westga.betsylouisinvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Test class for edu.westga.betsylouisinvestmentcalculator.model.InvestmentCalculator;
 * Created by Betsy on 3/3/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private Button btnCalculate;
    private EditText etPrincipal;
    private EditText etRate;
    private EditText etPeriod;
    private TextView tvResult;

    public MainActivityTests() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() {
        this.activity  = getActivity();
        this.btnCalculate = (Button) this.activity.findViewById(R.id.btnCalculate);
        this.etPrincipal = (EditText) this.activity.findViewById(R.id.etPrincipal);
        this.etRate = (EditText) this.activity.findViewById(R.id.etRate);
        this.etPeriod = (EditText) this.activity.findViewById(R.id.etPeriod);
        this.tvResult = (TextView) this.activity.findViewById(R.id.tvResult);
    }

    public void testActivityExists() {
        assertNotNull(activity);
    }

    public void testCalculateButtonIsDisabled() {
        assertTrue(!this.btnCalculate.isEnabled());
    }

    public void testCalculateButtonIsDisabledWhenOnlyPrincipalIsEntered() {
        this.enterPrincipal();
        assertTrue(!this.btnCalculate.isEnabled());
    }

    // Simulates value entered into principal field
    private void enterPrincipal() {
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                //MainActivityTests.this.nameEditText.requestFocus();
                MainActivityTests.this.etPrincipal.setText("1000");
            }
        });
    }

    public void testCalculateButtonIsDisabledWhenOnlyRateIsEntered() {
        this.enterRate();
        assertTrue(!this.btnCalculate.isEnabled());
    }

    // Simulates value entered into rate field
    private void enterRate() {
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                //MainActivityTests.this.nameEditText.requestFocus();
                MainActivityTests.this.etRate.setText("2");
            }
        });
    }

    public void testCalculateButtonIsDisabledWhenOnlyNumberOfPeriodsIsEntered() {
        this.enterPeriods();
        assertTrue(!this.btnCalculate.isEnabled());
    }

    // Simulates value entered into period field
    private void enterPeriods() {
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                //MainActivityTests.this.nameEditText.requestFocus();
                MainActivityTests.this.etPeriod.setText("5");
            }
        });
    }

    public void testCalculateButtonIsDisabledWhenOnlyPrincipalAndRateAreEntered() {
        this.enterPrincipal();
        this.enterRate();
        assertTrue(!this.btnCalculate.isEnabled());
    }

    public void testCalculateButtonIsDisabledWhenOnlyPrincipalAndNumberOfPeriodsAreEntered() {
        this.enterPrincipal();
        this.enterPeriods();
        assertTrue(!this.btnCalculate.isEnabled());
    }

    public void testCalculateButtonIsDisabledWhenOnlyRateAndNumberOfPeriodsAreEntered() {
        this.enterRate();
        this.enterPeriods();
        assertTrue(!this.btnCalculate.isEnabled());
    }

    public void testCalculateButtonIsEnabledWhenAllFieldsAreEntered() {
        this.enterPrincipal();
        this.enterRate();
        this.enterPeriods();
        assertTrue(this.btnCalculate.isEnabled());
    }

    public void testButtonCalculatesCorrectValue() {
        this.enterPrincipal();
        this.enterRate();
        this.enterPeriods();
        this.clickButton();

        assertEquals("$5,204.04", this.tvResult.getText().toString());
    }

    // Simulate clicking Calculate button
    private void clickButton() {
        TouchUtils.clickView(this, this.btnCalculate);
    }
}
