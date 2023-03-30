package com.GabrielMJr.Twaire.AllEasy.activity.physic.vaz;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class FlowRate1 extends BaseActivity {

    private TextView volume_symbol;
    private TextView delta_time_symbol;
    private TextView flow_rate_symbol;

    private TextView volume_unit;
    private TextView delta_time_unit;

	private EditText volume_value;
    private EditText delta_time_value;

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

		 // Verificar se volume é nulo ou ponto através do método Tools
		 /* if (Tools.isNull(vol.getText().toString())) {
		 vol.setError(getText(R.string.null_field));
		 verifyVolume = false;

		 // Se for ponto, pare
		 } else if (Tools.isDot(vol.getText().toString())) {
		 vol.setError(getText(R.string.dot_value));
		 verifyVolume = false;

		 // Se não for nulo, continue
		 } else {           
		 volume = Double.valueOf(vol.getText().toString());
		 verifyVolume = true;
		 }


		 // Verificar se delta tempo é nulo
		 if (Tools.isNull(dt.getText().toString())) {                        
		 dt.setError(getText(R.string.null_field));
		 verifyTime = false;

		 // Se for ponto, pare
		 } else if (Tools.isDot(dt.getText().toString())) {
		 dt.setError(getText(R.string.dot_value));
		 verifyTime = false;

		 // Se não for, continue
		 } else {
		 time = Double.valueOf(dt.getText().toString());
		 verifyTime = true;
		 }


		 // Se os valores VerifyVolume e time forem true, efectuar a operação
		 if (verifyVolume && verifyTime) {
		 res.setText(getText(R.string.flowRatep)
		 + " "
		 + volume 
		 + getText(R.string.vmc)
		 + getText(R.string.division)
		 + time
		 + getText(R.string.second));

		 res.setText((CharSequence) res.getText().toString()
		 + "\n"
		 + getText(R.string.flowRatep)
		 + " "
		 + FF.flowRate1(volume, time)
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
		 vol.setText(null);
		 dt.setText(null);
		 res.setText(null);

		 return;
		 }
		 });*/
    }


    private void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        volume_symbol = findViewById(R.id.param_0_symbol);
        delta_time_symbol = findViewById(R.id.param_1_symbol);
        flow_rate_symbol = findViewById(R.id.result_symbol);

        volume_value = findViewById(R.id.param_0_value);
        delta_time_value = findViewById(R.id.param_1_value);

        volume_unit = findViewById(R.id.param_0_unit);
        delta_time_unit = findViewById(R.id.param_1_unit);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }


    private void initializeActivity() {
        volume_symbol.setText((String)getText(R.string.volume_symbol_equals)
							  + " ");           
        delta_time_symbol.setText((String)getText(R.string.time_symbol_equals) 
								  + " ");
        flow_rate_symbol.setText(getText(R.string.flow_rate_symbol_equals)
								 + " ?");

        volume_unit.setText("m³");
        delta_time_unit.setText("s");

        formula.setText(R.string.fluid_flow_flowRate1_formula);

        volume_symbol.setVisibility(View.VISIBLE);
        delta_time_symbol.setVisibility(View.VISIBLE);
        flow_rate_symbol.setVisibility(View.VISIBLE);

        volume_value.setVisibility(View.VISIBLE);
        delta_time_value.setVisibility(View.VISIBLE);

        volume_unit.setVisibility(View.VISIBLE);
        delta_time_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}