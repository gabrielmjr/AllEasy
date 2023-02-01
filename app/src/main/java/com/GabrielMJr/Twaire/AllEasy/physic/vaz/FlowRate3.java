package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.gabrielMJr.twaire.physic.Physic;
import com.gabrielMJr.twaire.physic.hydrodynamics.fluidflow.FluidFlow;
import com.gabrielMJr.twaire.tools.Tools;

public class FlowRate3 extends MyActivity 
{
    private TextView ray_symbol;
    private TextView velocity_symbol;
    private TextView pi_symbol;
    private TextView flow_rate_symbol;

    private TextView ray_unit;
    private TextView velocity_unit;

    private EditText ray_value;
    private EditText velocity_value;
    private TextView pi_value;

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

                    if (Tools.isNull(ra.getText().toString())) {
                        ra.setError(getText(R.string.null_field));
                        verifyRaio = false;
                    } else if (Tools.isDot(ra.getText().toString())) {
                        ra.setError(getText(R.string.dot_value));
                        verifyRaio = false;
                    } else {
                        raio = Double.valueOf(ra.getText().toString());
                        verifyRaio = true;
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


                    if (verifyRaio && verifyVelocity) {
                        res.setText((CharSequence) FF.flowRate3(raio, velocidade, physic.GET_STEP));
                        
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
                    ra.setText(null);
                    vel.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });*/
	}
    
    
    private void getViews()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        ray_symbol = findViewById(R.id.param_0_symbol);
        velocity_symbol = findViewById(R.id.param_1_symbol);
        pi_symbol = findViewById(R.id.param_2_symbol);
        flow_rate_symbol = findViewById(R.id.result_symbol);

        ray_value = findViewById(R.id.param_0_value);
        velocity_value = findViewById(R.id.param_1_value);
        pi_value = findViewById(R.id.param_2_unit);

        ray_unit = findViewById(R.id.param_0_unit);
        velocity_unit = findViewById(R.id.param_1_unit);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);

        findViewById(R.id.param_2_value).setVisibility(View.GONE);

        findViewById(R.id.param_3_symbol).setVisibility(View.GONE);
        findViewById(R.id.param_3_value).setVisibility(View.GONE);
        findViewById(R.id.param_3_unit).setVisibility(View.GONE);
    }


    private void initializeActivity()
    {
        ray_symbol.setText("r = ");   
        velocity_symbol.setText("v = ");
        flow_rate_symbol.setText(getText(R.string.flow_rate_symbol_equals)
                                 + " ?");
        pi_symbol.setText("π = ");
        pi_value.setText("3.14");
        
        ray_unit.setText("m");
        velocity_unit.setText("m/s");

        formula.setText(R.string.fluid_flow_flowRate3_formula);
    }
}
