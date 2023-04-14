package com.gabrielmjr.alleasy.activity.physic.kinematic.muv;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;

public class MUV_Acceleration4 extends BaseActivity {
	private TextView initial_velocity_symbol;
	private TextView final_velocity_symbol;
	private TextView initial_time_symbol;
	private TextView final_time_symbol;
	private TextView acceleration_symbol;

	private EditText initial_velocity_value;
	private EditText final_velocity_value;
	private EditText initial_time_value;
	private EditText final_time_value;

	private TextView initial_velocity_unit;
	private TextView final_velocity_unit;
	private TextView initial_time_unit;
	private TextView final_time_unit;

	private TextView formula;
	private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
        /*acceleration.setOnClickListener(
		 new OnClickListener() {
		 @Override
		 public void onClick(View view)
		 {

		 if (tools.isNull(initial_speed.getText().toString()))
		 {
		 initial_speed.setError(getText(R.string.null_field));
		 verify_initialSpeed = false;

		 }
		 else if (tools.isDot(initial_speed.getText().toString()))
		 {
		 initial_speed.setError(getText(R.string.dot_value));
		 verify_initialSpeed = false;

		 }
		 else
		 {
		 initialSpeed = Double.valueOf(initial_speed.getText().toString());
		 verify_initialSpeed = true;
		 }


		 if (tools.isNull(final_speed.getText().toString()))
		 {
		 final_speed.setError(getText(R.string.null_field));
		 verify_finalSpeed = false;

		 }
		 else if (tools.isDot(final_speed.getText().toString()))
		 {
		 final_speed.setError(getText(R.string.dot_value));
		 verify_finalSpeed = false;

		 }
		 else
		 {
		 finalSpeed = Double.valueOf(final_speed.getText().toString());
		 verify_finalSpeed = true;
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

		 if (verify_initialSpeed
		 &&
		 verify_finalSpeed
		 &&
		 verify_initialTime
		 &&
		 verify_finalTime)
		 {

		 res.setText(muv.acceleration4(initialSpeed, finalSpeed, initialTime, finalTime, physic.GET_STEP));
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
		 initial_speed.setText(null);
		 final_speed.setText(null);
		 final_time.setText(null);
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

		initial_velocity_symbol = findViewById(R.id.param_0_symbol);
		final_velocity_symbol = findViewById(R.id.param_1_symbol);
		initial_time_symbol = findViewById(R.id.param_2_symbol);
		final_time_symbol = findViewById(R.id.param_3_symbol);
		acceleration_symbol = findViewById(R.id.result_symbol);

		initial_velocity_value = findViewById(R.id.param_0_value);
		final_velocity_value = findViewById(R.id.param_1_value);
		initial_time_value = findViewById(R.id.param_2_value);
		final_time_value = findViewById(R.id.param_3_value);

		initial_velocity_unit = findViewById(R.id.param_0_unit);
		final_velocity_unit = findViewById(R.id.param_1_unit);
		initial_time_unit = findViewById(R.id.param_2_unit);
		final_time_unit = findViewById(R.id.param_3_unit);

		formula = findViewById(R.id.formula);
		result = findViewById(R.id.result);
	}

    @Override
    protected void initializeAttributes() {
        initial_velocity_symbol.setText("vi = ");
        final_velocity_symbol.setText("vf = ");
        initial_time_symbol.setText("ti = ");
        final_time_symbol.setText("tf = ");
        acceleration_symbol.setText("a = ?");

        initial_velocity_unit.setText("m/s");
        final_velocity_unit.setText("m/s");
        initial_time_unit.setText("s");
        final_time_unit.setText("s");

        formula.setText(R.string.kinematic_muv_acceleration4_formula);

        initial_velocity_symbol.setVisibility(View.VISIBLE);
        final_velocity_symbol.setVisibility(View.VISIBLE);
        initial_time_symbol.setVisibility(View.VISIBLE);
        final_time_symbol.setVisibility(View.VISIBLE);
        acceleration_symbol.setVisibility(View.VISIBLE);

        initial_velocity_value.setVisibility(View.VISIBLE);
        final_velocity_value.setVisibility(View.VISIBLE);
        initial_time_value.setVisibility(View.VISIBLE);
        final_time_value.setVisibility(View.VISIBLE);

        initial_velocity_unit.setVisibility(View.VISIBLE);
        final_velocity_unit.setVisibility(View.VISIBLE);
        initial_time_unit.setVisibility(View.VISIBLE);
        final_time_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
