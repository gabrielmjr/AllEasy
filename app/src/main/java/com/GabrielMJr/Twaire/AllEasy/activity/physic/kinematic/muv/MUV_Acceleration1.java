package com.GabrielMJr.Twaire.AllEasy.activity.physic.kinematic.muv;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class MUV_Acceleration1 extends BaseActivity {

    private TextView delta_speed_symbol;
	private TextView delta_time_symbol;
	private TextView acceleration_symbol;

	private EditText delta_speed_value;
	private EditText delta_time_value;

	private TextView delta_speed_unit;
	private TextView delta_time_unit;

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


		 if (verify_deltaSpeed && verify_deltaTime)
		 {

		 res.setText(getText(R.string.accelerationp)
		 + " "
		 + delta_speed.getText().toString()
		 + getText(R.string.dm)
		 + " - "
		 +delta_time.getText().toString()
		 + getText(R.string.dm)

		 + "\n"
		 + getText(R.string.accelerationp)
		 + " "
		 + muv.acceleration1(deltaSpeed, deltaTime)
		 + getText(R.string.dm));

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
		 delta_time.setText(null);
		 res.setText(null);

		 return;
		 }
		 });*/
    }


	private void getViews() {
		setToolBar((Toolbar) findViewById(R.id.toolbar));

		delta_speed_symbol = findViewById(R.id.param_0_symbol);
		delta_time_symbol = findViewById(R.id.param_1_symbol);
		acceleration_symbol = findViewById(R.id.result_symbol);

		delta_speed_value = findViewById(R.id.param_0_value);
		delta_time_value = findViewById(R.id.param_1_value);

		delta_speed_unit = findViewById(R.id.param_0_unit);
		delta_time_unit = findViewById(R.id.param_1_unit);

		formula = findViewById(R.id.formula);
		result = findViewById(R.id.result);
	}


	private void initializeActivity() {
		delta_speed_symbol.setText("∆v = ");
		delta_time_symbol.setText("∆t = ");
		acceleration_symbol.setText("a = ?");

		delta_speed_unit.setText("m/s");
		delta_time_unit.setText("s");

		formula.setText(R.string.kinematic_muv_acceleration1_formula);

		delta_speed_symbol.setVisibility(View.VISIBLE);
		delta_time_symbol.setVisibility(View.VISIBLE);
		acceleration_symbol.setVisibility(View.VISIBLE);

		delta_speed_value.setVisibility(View.VISIBLE);
		delta_time_value.setVisibility(View.VISIBLE);

		delta_speed_unit.setVisibility(View.VISIBLE);
		delta_time_unit.setVisibility(View.VISIBLE);

		formula.setVisibility(View.VISIBLE);
		result.setVisibility(View.VISIBLE);
	}

}
