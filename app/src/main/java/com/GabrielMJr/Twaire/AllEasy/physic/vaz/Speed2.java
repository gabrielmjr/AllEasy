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

public class Speed2 extends MyActivity 
{
    private TextView flow_rate_symbol;
    private TextView ray_symbol;
    private TextView pi_symbol;
    private TextView velocity_symbol;
    
    private TextView flow_rate_unit;
    private TextView ray_unit;
    
    private EditText flow_rate_value;
    private EditText ray_value;
    private TextView pi_value;
    
    private TextView formula;
    private TextView result;
    
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
		getViews();
        initializeActivity();
        
        
		/*this.speed.setOnClickListener(
            new OnClickListener() {
				public void onClick(View view) {

                        if (Tools.isNull(vaz.getText().toString())) {
                            vaz.setError(getText(R.string.null_field));
                            verifyVaz = false;
                        } else if (Tools.isDot(vaz.getText().toString())) {
							vaz.setError(getText(R.string.dot_value));
							verifyVaz = false;
						} else {
                            fluidFlow = Double.valueOf(vaz.getText().toString());
                            verifyVaz = true;
                        }

                    
                        if (Tools.isNull(ra.getText().toString())) {
                            ra.setError(getText(R.string.null_field));
                            verifyRay = false;
                        } else if (Tools.isDot(ra.getText().toString())) {
							ra.setError(getText(R.string.dot_value));
							verifyRay = false;
						} else {
                            raio = Double.valueOf(ra.getText().toString());
                            verifyRay = true;
                        }


                    if (verifyVaz && verifyRay) {
                        res.setText((CharSequence) FF.speed2(fluidFlow, raio, physic.GET_STEP));
                        
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
                    ra.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });*/
    }

    
    private void getViews()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        flow_rate_symbol = findViewById(R.id.param_0_symbol);
        ray_symbol = findViewById(R.id.param_1_symbol);
        pi_symbol = findViewById(R.id.param_2_symbol);
        velocity_symbol = findViewById(R.id.result_symbol);
        
        flow_rate_value = findViewById(R.id.param_0_value);
        ray_value = findViewById(R.id.param_1_value);
        pi_value = findViewById(R.id.param_2_unit);
        
        flow_rate_unit = findViewById(R.id.param_0_unit);
        ray_unit = findViewById(R.id.param_1_unit);
        
        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
        
        findViewById(R.id.param_2_value).setVisibility(View.GONE);

        findViewById(R.id.param_3_symbol).setVisibility(View.GONE);
        findViewById(R.id.param_3_value).setVisibility(View.GONE);
        findViewById(R.id.param_3_unit).setVisibility(View.GONE);
    }

    
    private void initializeActivity()
    {
        flow_rate_symbol.setText("Q = ");
        ray_symbol.setText("r = ");
        pi_symbol.setText("π = ");
        velocity_symbol.setText("v = ?");
        
        pi_value.setText("3.14");
        
        flow_rate_unit.setText("m³/s");
        ray_unit.setText("m");
        
        formula.setText(R.string.fluid_flow_speed2_formula);
    }
    
}
