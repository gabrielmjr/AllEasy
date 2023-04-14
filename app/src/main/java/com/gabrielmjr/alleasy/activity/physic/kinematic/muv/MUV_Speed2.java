package com.gabrielmjr.alleasy.activity.physic.kinematic.muv;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;

public class MUV_Speed2 extends BaseActivity {
	private TextView initial_time_symbol;
	private TextView final_time_symbol;
	private TextView acceleration_symbol;
	private TextView delta_speed_symbol;

	private EditText initial_time_value;
	private EditText final_time_value;
	private EditText acceleration_value;

	private TextView initial_time_unit;
	private TextView final_time_unit;
	private TextView acceleration_unit;

	private TextView formula;
	private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		/*speed.setOnClickListener(
		 new OnClickListener() {
		 @Override
		 public void onClick(View view)
		 {

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

		 if (tools.isNull(acceleration.getText().toString()))
		 {
		 acceleration.setError(getText(R.string.null_field));
		 verify_acceleration = false;

		 }
		 else if (tools.isDot(acceleration.getText().toString()))
		 {
		 acceleration.setError(getText(R.string.dot_value));
		 verify_acceleration = false;

		 }
		 else
		 {
		 accelerationV = Double.valueOf(acceleration.getText().toString());
		 verify_acceleration = true;
		 }


		 if (verify_initialTime && verify_finalTime && verify_acceleration)
		 {

		 res.setText(muv.speed2(initialTime, finalTime, accelerationV, physic.GET_STEP));

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
		 final_time.setText(null);
		 acceleration.setText(null);
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
		setToolBar((Toolbar)findViewById(R.id.toolbar));

		initial_time_symbol = findViewById(R.id.param_0_symbol);
		final_time_symbol = findViewById(R.id.param_1_symbol);
		acceleration_symbol = findViewById(R.id.param_2_symbol);
		delta_speed_symbol = findViewById(R.id.result_symbol);

		initial_time_value = findViewById(R.id.param_0_value);
		final_time_value = findViewById(R.id.param_1_value);
		acceleration_value = findViewById(R.id.param_2_value);

		initial_time_unit = findViewById(R.id.param_0_unit);
		final_time_unit = findViewById(R.id.param_1_unit);
		acceleration_unit = findViewById(R.id.param_2_unit);

		formula = findViewById(R.id.formula);
		result = findViewById(R.id.result);
	}

    @Override
    protected void initializeAttributes() {
        initial_time_symbol.setText("ti = ");
        final_time_symbol.setText("tf = ");
        acceleration_symbol.setText("a = ");
        delta_speed_symbol.setText("∆v = ?");

        initial_time_unit.setText("s");
        final_time_unit.setText("s");
        acceleration_unit.setText("m/s²");

        formula.setText(R.string.kinematic_muv_speed2_formula);

        initial_time_symbol.setVisibility(View.VISIBLE);
        final_time_symbol.setVisibility(View.VISIBLE);
        acceleration_symbol.setVisibility(View.VISIBLE);
        delta_speed_symbol.setVisibility(View.VISIBLE);

        initial_time_value.setVisibility(View.VISIBLE);
        final_time_value.setVisibility(View.VISIBLE);
        acceleration_value.setVisibility(View.VISIBLE);

        initial_time_unit.setVisibility(View.VISIBLE);
        final_time_unit.setVisibility(View.VISIBLE);
        acceleration_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
