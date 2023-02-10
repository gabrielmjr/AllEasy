package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;

public class Speed1 extends MyActivity
{
    private TextView flow_rate_symbol;
    private TextView area_symbol;
    private TextView velocity_symbol;
    
    private TextView flow_rate_unit;
    private TextView area_unit;
    
    private EditText flow_rate_value;
    private EditText area_value;
    
    private TextView formula;
    private TextView result;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();
        
        /*this.vel.setOnClickListener(
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


                    if (Tools.isNull(ar.getText().toString())) {
                        ar.setError(getText(R.string.null_field));
                        verifyAr = false;
                    } else if (Tools.isDot(ar.getText().toString())) {
                        ar.setError(getText(R.string.dot_value));
                        verifyAr = false;
                    } else {
                        area = Double.valueOf(ar.getText().toString());
                        verifyAr = true;
                    }

                    
                    if (verifyVaz && verifyAr) {
                        res.setText(getText(R.string.speedp)
                                    + " "
                                    + "("
                                    + vazao
                                    + getText(R.string.vmc)
                                    + ") "
                                    + getText(R.string.division)
                                    + " ("
                                    + area
                                    + getText(R.string.amq)
                                    + ")");
                                    
                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.speedp)
                                    + " "
                                    + FF.speed1(vazao, area)
                                    + getText(R.string.speedmps));
                                    
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
                    ar.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });*/
    }
    
    
    private void getViews()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        flow_rate_symbol = findViewById(R.id.param_0_symbol);
        area_symbol = findViewById(R.id.param_1_symbol);
        velocity_symbol = findViewById(R.id.result_symbol);
        
        flow_rate_value = findViewById(R.id.param_0_value);
        area_value = findViewById(R.id.param_1_value);
        
        flow_rate_unit = findViewById(R.id.param_0_unit);
        area_unit = findViewById(R.id.param_1_unit);
        
        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }
    
    
    private void initializeActivity()
    {
        flow_rate_symbol.setText("Q = ");
        area_symbol.setText("A = ");
        velocity_symbol.setText("v = ?");
        
        flow_rate_unit.setText("m³/s");
        area_unit.setText("m²");
        
        formula.setText(R.string.fluid_flow_speed1_formula);
        
        flow_rate_symbol.setVisibility(View.VISIBLE);
        area_symbol.setVisibility(View.VISIBLE);
        velocity_symbol.setVisibility(View.VISIBLE);
        
        flow_rate_value.setVisibility(View.VISIBLE);
        area_value.setVisibility(View.VISIBLE);
        
        flow_rate_unit.setVisibility(View.VISIBLE);
        area_unit.setVisibility(View.VISIBLE);
        
        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
