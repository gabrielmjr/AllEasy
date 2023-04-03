package com.GabrielMJr.Twaire.AllEasy.activity.physic.vaz;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class Volume1 extends BaseActivity {
    private TextView time_symbol;
    private TextView flow_rate_symbol;
    private TextView volume_symbol;

    private TextView time_unit;
    private TextView flow_rate_unit;

    private EditText time_value;
    private EditText flow_rate_value;

    private TextView formula;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();

		/* this.vol.setOnClickListener(
		 new OnClickListener() {
		 public void onClick(View view) {

		 if (Tools.isNull(tempo.getText().toString())) {
		 tempo.setError(getText(R.string.null_field));
		 verifyTime = false;
		 } else if (Tools.isDot(tempo.getText().toString())) {
		 tempo.setError(getText(R.string.dot_value));
		 verifyTime = false;
		 } else {
		 time = Double.valueOf(tempo.getText().toString());
		 verifyTime = true;
		 }


		 if (Tools.isNull(vaz.getText().toString())) {
		 vaz.setError(getText(R.string.null_field));
		 verifyVaz = false;
		 } else if (Tools.isDot(vaz.getText().toString())) {
		 vaz.setError(getText(R.string.dot_value));
		 verifyVaz = false;
		 } else {
		 vazao = Double.valueOf(vaz.getText().toString());
		 verifyVaz = true;
		 }


		 if (verifyTime && verifyVaz) {                    
		 res.setText(getText(R.string.volumep)
		 + " "
		 + time
		 + getText(R.string.second)
		 + " "
		 + getText(R.string.multiplication)
		 + " ("
		 + vazao
		 + getText(R.string.speedmcps)
		 + ")");

		 res.setText((CharSequence) res.getText().toString()
		 + "\n"
		 + getText(R.string.volumep)
		 + " "
		 + FF.volume(time, vazao)
		 + getText(R.string.vmc));

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
		 tempo.setText(null);
		 vaz.setText(null);
		 res.setText(null);

		 return;
		 }
		 });*/
    }


    private void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        time_symbol = findViewById(R.id.param_0_symbol);
        flow_rate_symbol = findViewById(R.id.param_1_symbol);
        volume_symbol = findViewById(R.id.result_symbol);

        time_value = findViewById(R.id.param_0_value);
        flow_rate_value = findViewById(R.id.param_1_value);

        time_unit = findViewById(R.id.param_0_unit);
        flow_rate_unit = findViewById(R.id.param_1_unit);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }


    private void initializeActivity() {
        time_symbol.setText("t = ");
        flow_rate_symbol.setText("Q = ");
        volume_symbol.setText("V = ?");

        time_unit.setText("s");
        flow_rate_unit.setText("m³/s");

        formula.setText(R.string.fluid_flow_volume1_formula);

        time_symbol.setVisibility(View.VISIBLE);
        flow_rate_symbol.setVisibility(View.VISIBLE);
        volume_symbol.setVisibility(View.VISIBLE);

        time_value.setVisibility(View.VISIBLE);
        flow_rate_value.setVisibility(View.VISIBLE);

        time_unit.setVisibility(View.VISIBLE);
        flow_rate_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
