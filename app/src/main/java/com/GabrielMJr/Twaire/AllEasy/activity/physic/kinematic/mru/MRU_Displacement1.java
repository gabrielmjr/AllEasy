package com.GabrielMJr.Twaire.AllEasy.activity.physic.kinematic.mru;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class MRU_Displacement1 extends BaseActivity {
    private TextView initial_displacement_symbol;
    private TextView delta_displacement_symbol;
    private TextView final_displacement_symbol;

    private TextView initial_displacement_unit;
    private TextView final_displacement_unit;

    private EditText initial_displacement_value;
    private EditText final_displacement_value;

    private TextView formula;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();

        /*displacement.setOnClickListener(
		 new OnClickListener() {
		 @Override
		 public void onClick(View view) {

		 if (tools.isNull(si.getText().toString())) {
		 si.setError(getText(R.string.null_field));
		 verify_ID = false;
		 } else if (tools.isDot(si.getText().toString())) {
		 si.setError(getText(R.string.dot_value));
		 verify_ID = false;
		 } else {
		 initialDisplacement = Double.valueOf(si.getText().toString());
		 verify_ID = true;
		 }


		 if (tools.isNull(sf.getText().toString())) {
		 sf.setError(getText(R.string.null_field));
		 verify_FD = false;
		 } else if (tools.isDot(sf.getText().toString())) {
		 sf.setError(getText(R.string.dot_value));
		 verify_FD = false;
		 } else {
		 finalDisplacement = Double.valueOf(sf.getText().toString());
		 verify_FD = true;
		 }


		 if (verify_ID && verify_FD) {

		 res.setText(getText(R.string.dsp)
		 + " "
		 + sf.getText().toString()
		 + getText(R.string.dm)
		 + " - "
		 + si.getText().toString()
		 + getText(R.string.dm)

		 + "\n"
		 + getText(R.string.dsp)
		 + " "
		 + mru.displacement1(initialDisplacement, finalDisplacement)
		 + getText(R.string.dm));

		 return;

		 }
		 else
		 {
		 return;
		 }
		 }
		 });

		 clear.setOnClickListener(
		 new OnClickListener()
		 {
		 @Override
		 public void onClick(View view)
		 {
		 si.setText(null);
		 sf.setText(null);
		 res.setText(null);

		 return;
		 }
		 });*/
    }


    private void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        initial_displacement_symbol = findViewById(R.id.param_0_symbol);
        delta_displacement_symbol = findViewById(R.id.result_symbol);
        final_displacement_symbol = findViewById(R.id.param_1_symbol);

        initial_displacement_unit = findViewById(R.id.param_0_unit);
        final_displacement_unit = findViewById(R.id.param_1_unit);

        initial_displacement_value = findViewById(R.id.param_0_value);
        final_displacement_value = findViewById(R.id.param_1_value);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }


    private void initializeActivity() {
        initial_displacement_symbol.setText("S｡⁠ = ");
        delta_displacement_symbol.setText("∆S = ?");
        final_displacement_symbol.setText("S = ");

        initial_displacement_unit.setText("m");
        final_displacement_unit.setText("m");

        formula.setText(R.string.kinematic_mru_displacement1_formula);

        initial_displacement_symbol.setVisibility(View.VISIBLE);
        delta_displacement_symbol.setVisibility(View.VISIBLE);
        final_displacement_symbol.setVisibility(View.VISIBLE);

        initial_displacement_value.setVisibility(View.VISIBLE);
        final_displacement_value.setVisibility(View.VISIBLE);

        initial_displacement_unit.setVisibility(View.VISIBLE);
        final_displacement_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
