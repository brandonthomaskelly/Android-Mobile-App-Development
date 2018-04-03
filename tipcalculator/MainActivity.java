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

// Necessary imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Initialize activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // Used for final amount calculations and displaying total
    public void calc(View v){
        DecimalFormat dec = new DecimalFormat();
        dec.setMaximumFractionDigits(2);
        EditText init_bill = (EditText) findViewById(R.id.input_amt);
        EditText init_tip = (EditText) findViewById(R.id.input_tip);
        TipCalculator tip_calc = new TipCalculator(Double.parseDouble(init_bill.getText().toString()), Integer.parseInt(init_tip.getText().toString()));
        TextView tipAmount = (TextView)findViewById(R.id.final_tip);
        TextView billAmount = (TextView)findViewById(R.id.final_bill);

        tipAmount.setText(getText(R.string.tip_amount) + " " + dec.format(tip_calc.calculateTip()));
        billAmount.setText(getText(R.string.total_amount) + " " + dec.format(tip_calc.calculateTotalBill()));
    }
}