package com.gabrielmjr.alleasy.activity.physic.kinematic.mru;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;

public class MRU_Initial_Time extends BaseActivity { 
    private TextView initial_time_symbol;
    private TextView delta_time_symbol;
    private TextView final_time_symbol;

    private EditText delta_time_value;
    private EditText final_time_value;

    private TextView delta_time_unit;
    private TextView final_time_unit;

    private TextView formula;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();

		/*initial_time.setOnClickListener(
		 new OnClickListener() {
		 @Override
		 public void onClick(View view)
		 {

		 if (tools.isNull(delta_time.getText().toString()))
		 {
		 delta_time.setError(getText(R.string.null_field));
		 verify_deltaTime = false;

		 }
		 else if (tools.isDot(delta_time.getText().toString()))
		 {
		 delta_time.setError(getText(R.string.dot_value));
		 verify_deltaTime = false;

		 }
		 else
		 {
		 deltaTime = Double.valueOf(delta_time.getText().toString());
		 verify_deltaTime = true;
		 }

		 if (tools.isNull(final_time.getText().toString()))
		 {
		 final_time.setError(getText(R.string.null_field));
		 verify_finalTime = false;

		 }
		 else if (tools.isDot(final_time.getText().toString()))
		 {
		 final_time.setError(getText(R.string.dot_value));
		 verify_finalTime = false;

		 }
		 else
		 {
		 finalTime = Double.valueOf(final_time.getText().toString());
		 verify_finalTime = true;
		 }

		 if (verify_deltaTime && verify_finalTime)
		 {
		 res.setText(getText(R.string.initial_timep)
		 + " "
		 + finalTime
		 + getText(R.string.second)
		 + " "
		 + getText(R.string.minus)
		 + " "
		 + deltaTime
		 + getText(R.string.second)
		 + getText(R.string.newLine)
		 + getText(R.string.initial_timep)
		 + " " 
		 + mru.time4(deltaTime, finalTime)
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
		 delta_time.setText(null);
		 final_time.setText(null);
		 res.setText(null);

		 return;
		 }
		 });*/
    }


    private void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        initial_time_symbol = findViewById(R.id.result_symbol);
        delta_time_symbol = findViewById(R.id.param_0_symbol);
        final_time_symbol = findViewById(R.id.param_1_symbol);

        delta_time_value = findViewById(R.id.param_0_value);
        final_time_value = findViewById(R.id.param_1_value);

        delta_time_unit = findViewById(R.id.param_0_unit);
        final_time_unit = findViewById(R.id.param_1_unit);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }


    private void initializeActivity() {
        initial_time_symbol.setText("ti = ?");
        delta_time_symbol.setText("∆t = ");
        final_time_symbol.setText("t = ");

        delta_time_unit.setText("s");
        final_time_symbol.setText("s");

        formula.setText(R.string.kinematic_mru_initial_time_formula);

        initial_time_symbol.setVisibility(View.VISIBLE);
        delta_time_symbol.setVisibility(View.VISIBLE);
        final_time_symbol.setVisibility(View.VISIBLE);

        delta_time_value.setVisibility(View.VISIBLE);
        final_time_value.setVisibility(View.VISIBLE);

        delta_time_unit.setVisibility(View.VISIBLE);
        final_time_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }

}
