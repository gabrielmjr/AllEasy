package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;

public class Ray1 extends MyActivity 
{
    private TextView flow_rate_symbol;
    private TextView velocity_symbol;
    private TextView pi_symbol;
    private TextView ray_symbol;
    
    private TextView flow_rate_unit;
    private TextView velocity_unit;
    
    private EditText flow_rate_value;
    private EditText velocity_value;
    private TextView pi_value;
    
    private TextView formula;
    private TextView result;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();
        
       /* this.raio.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

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


                    if (Tools.isNull(vel.getText().toString())) {
                        vel.setError(getText(R.string.null_field));
                        verifyVelocity = false;
                    } else if (Tools.isDot(vel.getText().toString())) {
                        vel.setError(getText(R.string.dot_value));
                        verifyVelocity = true;
                    } else {
                        velocidade = Double.valueOf(vel.getText().toString());
                        verifyVelocity = false;
                    }


                    if (verifyVaz && verifyVelocity) {
                        res.setText(FF.ray(vazao, velocidade, physic.GET_STEP));
                        
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
    
    
    private void getViews()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        flow_rate_symbol = findViewById(R.id.param_0_symbol);
        velocity_symbol = findViewById(R.id.param_1_symbol);
        pi_symbol = findViewById(R.id.param_2_symbol);
        ray_symbol = findViewById(R.id.result_symbol);
        
        flow_rate_value = findViewById(R.id.param_0_value);
        velocity_value = findViewById(R.id.param_1_value);
        pi_value = findViewById(R.id.param_2_unit);
        
        flow_rate_unit = findViewById(R.id.param_0_unit);
        velocity_unit = findViewById(R.id.param_1_unit);
        
        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }
    
    
    private void initializeActivity()
    {
        flow_rate_symbol.setText("Q = ");
        velocity_symbol.setText("v = ");
        ray_symbol.setText("r = ?");
        
        pi_symbol.setText("π = ");
        pi_value.setText("3.14");
        
        flow_rate_unit.setText("m³/s");
        velocity_unit.setText("m/s");
        
        formula.setText(R.string.fluid_flow_ray1_formula);
        
        flow_rate_symbol.setVisibility(View.VISIBLE);
        velocity_symbol.setVisibility(View.VISIBLE);
        ray_symbol.setVisibility(View.VISIBLE);
        
        pi_symbol.setVisibility(View.VISIBLE);
        pi_value.setVisibility(View.VISIBLE);
        
        flow_rate_value.setVisibility(View.VISIBLE);
        velocity_value.setVisibility(View.VISIBLE);
        
        flow_rate_unit.setVisibility(View.VISIBLE);
        velocity_unit.setVisibility(View.VISIBLE);
        
        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
