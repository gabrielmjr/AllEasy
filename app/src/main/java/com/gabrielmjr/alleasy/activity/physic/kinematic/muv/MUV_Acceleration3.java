package com.gabrielmjr.alleasy.activity.physic.kinematic.muv;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;

public class MUV_Acceleration3 extends BaseActivity {
	private TextView initial_velocity_symbol;
	private TextView final_velocity_symbol;
	private TextView delta_time_symbol;
	private TextView acceleration_symbol;

	private EditText initial_velocity_value;
	private EditText final_velocity_value;
	private EditText delta_time_value;

	private TextView initial_velocity_unit;
	private TextView final_velocity_unit;
	private TextView delta_time_unit;

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


		 if (verify_initialSpeed 
		 &&
		 verify_finalSpeed
		 &&
		 verify_deltaTime)
		 {

		 res.setText(muv.acceleration3(initialSpeed, finalSpeed, deltaTime, physic.GET_STEP));
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
		 initial_speed.setText(null);
		 final_speed.setText(null);
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

		initial_velocity_symbol = findViewById(R.id.param_0_symbol);
		final_velocity_symbol = findViewById(R.id.param_1_symbol);
		delta_time_symbol = findViewById(R.id.param_2_symbol);
		acceleration_symbol = findViewById(R.id.result_symbol);

		initial_velocity_value = findViewById(R.id.param_0_value);
		final_velocity_value = findViewById(R.id.param_1_value);
		delta_time_value = findViewById(R.id.param_2_value);

		initial_velocity_unit = findViewById(R.id.param_0_unit);
		final_velocity_unit = findViewById(R.id.param_1_unit);
		delta_time_unit = findViewById(R.id.param_2_unit);

		formula = findViewById(R.id.formula);
		result = findViewById(R.id.result);
	}

    @Override
    protected void initializeAttributes() {
        initial_velocity_symbol.setText("vi = ");
        final_velocity_symbol.setText("vf = ");
        delta_time_symbol.setText("∆t = ");
        acceleration_symbol.setText("a = ?");

        initial_velocity_unit.setText("m/s");
        final_velocity_unit.setText("m/s");
        delta_time_unit.setText("s");

        formula.setText(R.string.kinematic_muv_acceleration3_formula);

        initial_velocity_symbol.setVisibility(View.VISIBLE);
        final_velocity_symbol.setVisibility(View.VISIBLE);
        delta_time_symbol.setVisibility(View.VISIBLE);
        acceleration_symbol.setVisibility(View.VISIBLE);

        initial_velocity_value.setVisibility(View.VISIBLE);
        final_velocity_value.setVisibility(View.VISIBLE);
        delta_time_value.setVisibility(View.VISIBLE);

        initial_velocity_unit.setVisibility(View.VISIBLE);
        final_velocity_unit.setVisibility(View.VISIBLE);
        delta_time_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
