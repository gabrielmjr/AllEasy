package com.GabrielMJr.Twaire.AllEasy.activity.physic.kinematic.muv;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class MUV_Acceleration2 extends BaseActivity {
	private TextView delta_speed_symbol;
	private TextView initial_time_symbol;
	private TextView final_time_symbol;
	private TextView acceleration_symbol;

	private EditText delta_speed_value;
	private EditText initial_time_value;
	private EditText final_time_value;

	private TextView delta_speed_unit;
	private TextView initial_time_unit;
	private TextView final_time_unit;

	private TextView formula;
	private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
		initializeActivity();


        /*acceleration.setOnClickListener(
		 new OnClickListener() {
		 @Override
		 public void onClick(View view)
		 {

		 if (tools.isNull(delta_speed.getText().toString()))
		 {
		 delta_speed.setError(getText(R.string.null_field));
		 verify_deltaSpeed = false;

		 }
		 else if (tools.isDot(delta_speed.getText().toString()))
		 {
		 delta_speed.setError(getText(R.string.dot_value));
		 verify_deltaSpeed = false;

		 }
		 else
		 {
		 deltaSpeed = Double.valueOf(delta_speed.getText().toString());
		 verify_deltaSpeed = true;
		 }


		 if (tools.isNull(initial_time.getText().toString()))
		 {
		 initial_time.setError(getText(R.string.null_field));
		 verify_initialTime = false;

		 }
		 else if (tools.isDot(initial_time.getText().toString()))
		 {
		 initial_time.setError(getText(R.string.dot_value));
		 verify_initialTime = false;

		 }
		 else
		 {
		 initialTime = Double.valueOf(initial_time.getText().toString());
		 verify_initialTime = true;
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


		 if (verify_deltaSpeed
		 &&
		 verify_initialTime
		 &&
		 verify_finalTime)
		 {

		 res.setText(muv.acceleration2(deltaSpeed, initialTime, finalTime, physic.GET_STEP));

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
		 delta_speed.setText(null);
		 initial_time.setText(null);
		 final_time.setText(null);
		 res.setText(null);

		 return;
		 }
		 });*/
    }


	private void getViews() {
		setToolBar((Toolbar) findViewById(R.id.toolbar));

		delta_speed_symbol = findViewById(R.id.param_0_symbol);
		initial_time_symbol = findViewById(R.id.param_1_symbol);
		final_time_symbol = findViewById(R.id.param_2_symbol);
		acceleration_symbol = findViewById(R.id.result_symbol);

		delta_speed_value = findViewById(R.id.param_0_value);
		initial_time_value = findViewById(R.id.param_1_value);
		final_time_value = findViewById(R.id.param_2_value);

		delta_speed_unit = findViewById(R.id.param_0_unit);
		initial_time_unit = findViewById(R.id.param_1_unit);
		final_time_unit = findViewById(R.id.param_2_unit);

		formula = findViewById(R.id.formula);
	    result = findViewById(R.id.result);
	}


	private void initializeActivity() {
		delta_speed_symbol.setText("∆v = ");
		initial_time_symbol.setText("ti = ");
		final_time_symbol.setText("tf = ");
		acceleration_symbol.setText("a = ?");

		delta_speed_unit.setText("m/s");
		initial_time_unit.setText("s");
		final_time_unit.setText("s");

		formula.setText(R.string.kinematic_muv_acceleration2_formula);

		delta_speed_symbol.setVisibility(View.VISIBLE);
		initial_time_symbol.setVisibility(View.VISIBLE);
		final_time_symbol.setVisibility(View.VISIBLE);
		acceleration_symbol.setVisibility(View.VISIBLE);

		delta_speed_value.setVisibility(View.VISIBLE);
		initial_time_value.setVisibility(View.VISIBLE);
		final_time_value.setVisibility(View.VISIBLE);

		delta_speed_unit.setVisibility(View.VISIBLE);
		initial_time_unit.setVisibility(View.VISIBLE);
		final_time_unit.setVisibility(View.VISIBLE);

		formula.setVisibility(View.VISIBLE);
		result.setVisibility(View.VISIBLE);
	}
}
