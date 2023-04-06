package com.gabrielmjr.alleasy.activity.physic.kinematic.mru;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;


public class MRU_Displacement3 extends BaseActivity {
    private TextView initial_time_symbol;
    private TextView final_time_symbol;
    private TextView velocity_symbol;
    private TextView delta_displacement_symbol;

    private EditText initial_time_value;
    private EditText final_time_value;
    private EditText velocity_value;

    private TextView initial_time_unit;
    private TextView final_time_unit;
    private TextView velocity_unit;

    private TextView formula;
    private TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializsActivity();

		/* displacement.setOnClickListener(
		 new OnClickListener() {
		 @Override
		 public void onClick(View view) {

		 if (tools.isNull(initial_time.getText().toString())) {
		 initial_time.setError(getText(R.string.null_field));
		 verify_initial_time = false;

		 } else if (tools.isDot(initial_time.getText().toString())) {
		 initial_time.setError(getText(R.string.dot_value));
		 verify_initial_time = false;

		 } else {
		 initialTime = Double.valueOf(initial_time.getText().toString());
		 verify_initial_time = true;
		 }


		 if (tools.isNull(final_time.getText().toString())) {
		 final_time.setError(getText(R.string.null_field));
		 verify_final_time = false;

		 } else if (tools.isDot(final_time.getText().toString())) {
		 final_time.setError(getText(R.string.dot_value));
		 verify_final_time = false;

		 } else {
		 finalTime = Double.valueOf(final_time.getText().toString());
		 verify_final_time = true;
		 }


		 if (tools.isNull(media_speed.getText().toString())) {
		 media_speed.setError(getText(R.string.null_field));
		 verify_media_speed = false;

		 } else if (tools.isDot(media_speed.getText().toString())) {
		 media_speed.setError(getText(R.string.dot_value));
		 verify_media_speed = false;

		 } else {
		 mediaSpeed = Double.valueOf(media_speed.getText().toString());
		 verify_media_speed = true;
		 }


		 if(verify_initial_time
		 &&
		 verify_final_time
		 &&
		 verify_media_speed) {

		 res.setText((CharSequence)mru.displacement3(initialTime, finalTime, mediaSpeed, physic.GET_STEP));                       

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
		 media_speed.setText(null);
		 res.setText(null);

		 return;
		 }
		 });*/
    }


    private void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        initial_time_symbol = findViewById(R.id.param_0_symbol);
        final_time_symbol = findViewById(R.id.param_1_symbol);
        velocity_symbol = findViewById(R.id.param_2_symbol);
        delta_displacement_symbol = findViewById(R.id.result_symbol);

        initial_time_value = findViewById(R.id.param_0_value);
        final_time_value = findViewById(R.id.param_1_value);
        velocity_value = findViewById(R.id.param_2_value);

        initial_time_unit = findViewById(R.id.param_0_unit);
        final_time_unit = findViewById(R.id.param_1_unit);
        velocity_unit = findViewById(R.id.param_2_unit);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }


    private void initializsActivity() {
        initial_time_symbol.setText("ti = ");
        final_time_symbol.setText("t = ");
        velocity_symbol.setText("v = ");
        delta_displacement_symbol.setText("∆S = ?");

        initial_time_unit.setText("s");
        final_time_unit.setText("s");
        velocity_unit.setText("m/s");

        formula.setText(R.string.kinematic_mru_displacement3_formula);

        initial_time_symbol.setVisibility(View.VISIBLE);
        final_time_symbol.setVisibility(View.VISIBLE);
        velocity_symbol.setVisibility(View.VISIBLE);
        delta_displacement_symbol.setVisibility(View.VISIBLE);

        initial_time_value.setVisibility(View.VISIBLE);
        final_time_value.setVisibility(View.VISIBLE);
        velocity_value.setVisibility(View.VISIBLE);

        initial_time_unit.setVisibility(View.VISIBLE);
        final_time_unit.setVisibility(View.VISIBLE);
        velocity_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }

}
