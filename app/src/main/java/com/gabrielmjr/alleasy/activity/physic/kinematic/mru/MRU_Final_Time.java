package com.gabrielmjr.alleasy.activity.physic.kinematic.mru;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;

public class MRU_Final_Time extends BaseActivity {
    private TextView initial_time_symbol;
    private TextView delta_time_symbol;
    private TextView final_time_symbol;

    private EditText initial_time_value;
    private EditText delta_time_value;

    private TextView initial_time_unit;
    private TextView delta_time_unit;

    private TextView formula;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /*final_time.setOnClickListener(
		 new OnClickListener() {
		 @Override
		 public void onClick (View view) {

		 if (tools.isNull(initial_time.getText().toString())) {
		 initial_time.setError(getText(R.string.null_field));
		 verify_initialTime = false;

		 }
		 else if (tools.isDot(initial_time.getText().toString())) {
		 initial_time.setError(getText(R.string.dot_value));
		 verify_initialTime = false;

		 }
		 else {
		 initialTime = Double.valueOf(initial_time.getText().toString());
		 verify_initialTime = true;
		 }

		 if (tools.isNull(delta_time.getText().toString())) {
		 delta_time.setError(getText(R.string.null_field));
		 verify_deltaTime = false;

		 }
		 else if (tools.isDot(delta_time.getText().toString())) {
		 delta_time.setError(getText(R.string.dot_value));
		 verify_deltaTime = false;

		 }
		 else {
		 deltaTime = Double.valueOf(delta_time.getText().toString());
		 verify_deltaTime = true;
		 }

		 if (verify_initialTime && verify_deltaTime) {

		 res.setText(getText(R.string.final_timep)
		 + " "
		 + initialTime
		 + getText(R.string.second)
		 + " "
		 + getText(R.string.plus)
		 + " "
		 + deltaTime
		 + getText(R.string.second)
		 + getText(R.string.newLine)
		 + getText(R.string.final_timep)
		 + " "
		 + mru.time5(initialTime ,deltaTime)
		 + getText(R.string.second));

		 return;
		 }
		 else
		 {
		 return;
		 }
		 }
		 });

		 this.clear.setOnClickListener(
		 new OnClickListener()
		 {
		 @Override
		 public void onClick(View view)
		 {
		 initial_time.setText(null);
		 delta_time.setText(null);
		 res.setText(null);

		 return;
		 }
		 });*/
    }

    @Override
    protected void initializeActivity() {
        setContentView(R.layout.activity_physic_calculations);
    }
    
    @Override
    protected void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        initial_time_symbol = findViewById(R.id.param_0_symbol);
        delta_time_symbol = findViewById(R.id.param_1_symbol);
        final_time_symbol = findViewById(R.id.result_symbol);

        initial_time_value = findViewById(R.id.param_0_value);
        delta_time_value = findViewById(R.id.param_1_value);

        initial_time_unit = findViewById(R.id.param_0_unit);
        delta_time_unit = findViewById(R.id.param_1_unit);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }

    @Override
    protected void initializeAttributes() {
        initial_time_symbol.setText("ti = ");
        delta_time_symbol.setText("∆t = ");
        final_time_symbol.setText("t = ?");

        initial_time_unit.setText("s");
        delta_time_unit.setText("s");

        formula.setText(R.string.kinematic_mru_final_time_formula);

        initial_time_symbol.setVisibility(View.VISIBLE);
        delta_time_symbol.setVisibility(View.VISIBLE);
        final_time_symbol.setVisibility(View.VISIBLE);

        initial_time_value.setVisibility(View.VISIBLE);
        delta_time_value.setVisibility(View.VISIBLE);

        initial_time_unit.setVisibility(View.VISIBLE);
        delta_time_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
