package com.gabrielmjr.alleasy.activity.physic.vaz;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;

public class Area1 extends BaseActivity {
    private TextView flow_rate_symbol;
    private TextView velocity_symbol;
    private TextView area_symbol;

    private EditText flow_rate_value;
    private EditText velocity_value;

    private TextView flow_rate_unit;
    private TextView velocity_unit;

    private TextView formula;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		/*this.area.setOnClickListener(
		 new OnClickListener() {
		 public void onClick(View view) {

		 if (Tools.isNull(vaz.getText().toString())) {
		 vaz.setError(getText(R.string.null_field));
		 verifyVaz = 0;
		 } else if (Tools.isDot(vaz.getText().toString())) {
		 vaz.setError(getText(R.string.dot_value));
		 verifyVaz = 0;
		 } else {
		 vazao = Double.valueOf(vaz.getText().toString());
		 verifyVaz = 1;
		 }


		 if (Tools.isNull(vel.getText().toString())) {
		 vel.setError(getText(R.string.null_field));
		 verifyVel = 0;
		 } else if (Tools.isDot(vel.getText().toString())) {
		 vel.setError(getText(R.string.dot_value));
		 verifyVel = 0;
		 } else {
		 velocidade = Double.valueOf(vel.getText().toString());
		 verifyVel = 1;
		 }


		 if (verifyVaz == 1 && verifyVel == 1) {
		 res.setText(getText(R.string.areap)
		 + " ("
		 + vazao
		 + getText(R.string.speedmcps)
		 + ") "
		 + getText(R.string.division)
		 + " ("
		 + velocidade
		 + getText(R.string.speedmps)
		 + ")");

		 res.setText((CharSequence) res.getText().toString()
		 + "\n"
		 + getText(R.string.areap)
		 + " "
		 + FF.area(vazao, velocidade)
		 + getText(R.string.amq));

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
		 vaz.setText(null);
		 vel.setText(null);
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

        flow_rate_symbol = findViewById(R.id.param_0_symbol);
        velocity_symbol = findViewById(R.id.param_1_symbol);
        area_symbol = findViewById(R.id.result_symbol);

        flow_rate_value = findViewById(R.id.param_0_value);
        velocity_value = findViewById(R.id.param_1_value);

        flow_rate_unit = findViewById(R.id.param_0_unit);
        velocity_unit = findViewById(R.id.param_1_unit);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }

    @Override
    protected void initializeAttributes() {
        flow_rate_symbol.setText("Q = ");
        velocity_symbol.setText("v = ");
        area_symbol.setText("A = ?");

        flow_rate_unit.setText("m³/s");
        velocity_unit.setText("m/s");

        formula.setText(R.string.fluid_flow_area1_formula);

        flow_rate_symbol.setVisibility(View.VISIBLE);
        velocity_symbol.setVisibility(View.VISIBLE);
        area_symbol.setVisibility(View.VISIBLE);

        flow_rate_unit.setVisibility(View.VISIBLE);
        velocity_unit.setVisibility(View.VISIBLE);

        flow_rate_value.setVisibility(View.VISIBLE);
        velocity_value.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
