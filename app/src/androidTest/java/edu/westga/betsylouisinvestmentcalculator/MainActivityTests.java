package edu.westga.betsylouisinvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Betsy on 3/3/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;

    public MainActivityTests() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() {
        this.activity  = getActivity();
    }

    public void testActivityExists() {
        assertNotNull(activity);
    }
}
