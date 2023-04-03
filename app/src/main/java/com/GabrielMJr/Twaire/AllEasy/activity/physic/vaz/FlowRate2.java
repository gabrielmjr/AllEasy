package com.GabrielMJr.Twaire.AllEasy.activity.physic.vaz;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class FlowRate2 extends BaseActivity {
    private TextView area_symbol;
    private TextView velocity_symbol;
    private TextView flow_rate_symbol;

    private TextView area_unit;
    private TextView velocity_unit;

    private EditText area_value;
    private EditText velocity_value;

    private TextView formula;
    private TextView result;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_physic_calculations);
		getViews();
        initializeActivity();

		/*this.vaz.setOnClickListener(
		 new OnClickListener() {
		 public void onClick(View view) {

		 if (Tools.isNull(ar.getText().toString())) {
		 ar.setText(getText(R.string.null_field));
		 verifyArea = false;
		 } else if (Tools.isDot(ar.getText().toString())) {
		 ar.setError(getText(R.string.dot_value));
		 verifyArea = false;
		 } else {
		 area = Double.valueOf(ar.getText().toString());
		 verifyArea = true;
		 }


		 if (Tools.isNull(vel.getText().toString())) {
		 vel.setError(getText(R.string.null_field));
		 verifyVelocity = false;
		 } else if (Tools.isDot(vel.getText().toString())) {
		 vel.setError(getText(R.string.dot_value));
		 verifyVelocity = false;
		 } else {
		 velocidade = Double.valueOf(vel.getText().toString());
		 verifyVelocity = true;
		 }


		 if (verifyVelocity && verifyArea) {
		 res.setText(getText(R.string.flowRatep)
		 + " "
		 + area
		 + getText(R.string.amq)
		 + " "
		 + getText(R.string.multiplication)
		 + " "
		 + velocidade
		 + getText(R.string.speedmps));

		 res.setText((CharSequence) res.getText().toString()
		 + "\n"
		 + getText(R.string.flowRatep)
		 + " "
		 + FF.flowRate2(area, velocidade)
		 + getText(R.string.speedmcps));

		 return;
		 } else {
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
		 vel.setText(null);
		 ar.setText(null);
		 res.setText(null);

		 return;
		 }
		 });*/
	}


    private void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        area_symbol = findViewById(R.id.param_0_symbol);
        velocity_symbol = findViewById(R.id.param_1_symbol);
        flow_rate_symbol = findViewById(R.id.result_symbol);

        area_value = findViewById(R.id.param_0_value);
        velocity_value = findViewById(R.id.param_1_value);

        area_unit = findViewById(R.id.param_0_unit);
        velocity_unit = findViewById(R.id.param_1_unit);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }


    private void initializeActivity() {
        area_symbol.setText("a = ");   
        velocity_symbol.setText("v = ");
        flow_rate_symbol.setText(getText(R.string.flow_rate_symbol_equals)
                                 + " ?");

        area_unit.setText("m²");
        velocity_unit.setText("m/s");

        formula.setText(R.string.fluid_flow_flowRate2_formula);

        area_symbol.setVisibility(View.VISIBLE);
        velocity_symbol.setVisibility(View.VISIBLE);

        area_value.setVisibility(View.VISIBLE);
        velocity_value.setVisibility(View.VISIBLE);

        area_unit.setVisibility(View.VISIBLE);
        velocity_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
