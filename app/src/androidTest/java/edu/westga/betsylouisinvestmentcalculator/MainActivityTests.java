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

    public MainActivityTests() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() {
        this.activity  = getActivity();
        this.btnCalculate = (Button) this.activity.findViewById(R.id.btnCalculate);
    }

    public void testActivityExists() {
        assertNotNull(activity);
    }

    public void testCalculateButtonIsDisabled() {
        assertTrue(!this.btnCalculate.isEnabled());
    }
}
