package edu.westga.betsylouisinvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Betsy on 3/3/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private Button btnCalculate;
    private EditText etPrincipal;

    public MainActivityTests() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() {
        this.activity  = getActivity();
        this.btnCalculate = (Button) this.activity.findViewById(R.id.btnCalculate);
        this.etPrincipal = (EditText) this.activity.findViewById(R.id.etPrincipal);
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
}
