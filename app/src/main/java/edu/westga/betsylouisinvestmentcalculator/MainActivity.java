package edu.westga.betsylouisinvestmentcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import edu.westga.betsylouisinvestmentcalculator.model.InvestmentCalculator;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate;
    private EditText etPrincipal;
    private EditText etRate;
    private EditText etNumberOfPeriods;
    private InvestmentCalculator calculator;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnCalculate = (Button) findViewById(R.id.btnCalculate);
        this.btnCalculate.setEnabled(false);
        this.etPrincipal = (EditText) findViewById(R.id.etPrincipal);
        this.etNumberOfPeriods = (EditText) findViewById(R.id.etPeriod);
        this.etRate = (EditText) findViewById(R.id.etRate);
        this.calculator = new InvestmentCalculator();
        this.tvResult = (TextView)findViewById(R.id.tvResult);

        this.etPrincipal.addTextChangedListener(this.watcher);
        this.etNumberOfPeriods.addTextChangedListener(this.watcher);
        this.etRate.addTextChangedListener(this.watcher);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Listens for any changes in the EditText boxes and enables/disables the button appropriately
     */
    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            MainActivity.this.tvResult.setText("");
            boolean principalNotEmpty = MainActivity.this.etPrincipal.getText().length()>0;
            boolean rateNotEmpty = MainActivity.this.etRate.getText().length()>0;
            boolean periodNotEmpty = MainActivity.this.etNumberOfPeriods.getText().length()>0;
            MainActivity.this.btnCalculate.setEnabled(principalNotEmpty && rateNotEmpty && periodNotEmpty);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculateFutureAnnuity(View view) {
        this.calculator.setPrincipal(Double.parseDouble(this.etPrincipal.getText().toString()));
        this.calculator.setRate(Double.parseDouble(this.etRate.getText().toString()));
        this.calculator.setNumberOfPeriods(Integer.parseInt(this.etNumberOfPeriods.getText().toString()));

        String result = NumberFormat.getCurrencyInstance().format(this.calculator.getFutureValueOfAnnuity());
        this.tvResult.setText(result);
    }
}
