package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;

public class Time1 extends MyActivity
{
    private TextView volume_symbol;
    private TextView flow_rate_symbol;
    private TextView time_symbol;
    
    private TextView volume_unit;
    private TextView flow_rate_unit;
    
    private EditText volume_value;
    private EditText flow_rate_value;
    
    private TextView formula;
    private TextView result;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeAttributes();
        
        
       /* this.tempo.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {
                    
                    if (Tools.isNull(vol.getText().toString())) {
                        vol.setError(getText(R.string.null_field));
                        verifyVol = false;
                    } else if (Tools.isDot(vol.getText().toString())) {
                        vol.setError(getText(R.string.dot_value));
                        verifyVol = false;
                    } else {
                        volume = Double.valueOf(vol.getText().toString());
                        verifyVol = true;
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


                    if (verifyVaz && verifyVol) {
                        res.setText(getText(R.string.dtp)
                                    + String.valueOf(volume)
                                    + getText(R.string.vmc)
                                    + " "
                                    + getText(R.string.division)
                                    + " ("
                                    + vazao
                                    + getText(R.string.speedmcps)
                                    + ")");

                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.dtp)
                                    + " "
                                    + FF.time(volume, vazao)
                                    + getText(R.string.second));
                                    
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
                    vaz.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });*/
    }
    

    private void getViews()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        volume_symbol = findViewById(R.id.param_0_symbol);
        flow_rate_symbol = findViewById(R.id.param_1_symbol);
        time_symbol = findViewById(R.id.result_symbol);
        
        volume_value = findViewById(R.id.param_0_value);
        flow_rate_value = findViewById(R.id.param_1_value);
        
        volume_unit = findViewById(R.id.param_0_unit);
        flow_rate_unit = findViewById(R.id.param_1_unit);
        
        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
        
        findViewById(R.id.param_2_symbol).setVisibility(View.GONE);
        findViewById(R.id.param_2_value).setVisibility(View.GONE);
        findViewById(R.id.param_2_unit).setVisibility(View.GONE);

        findViewById(R.id.param_3_symbol).setVisibility(View.GONE);
        findViewById(R.id.param_3_value).setVisibility(View.GONE);
        findViewById(R.id.param_3_unit).setVisibility(View.GONE);
    }

    
    private void initializeAttributes()
    {
        volume_symbol.setText("V = ");
        flow_rate_symbol.setText("Q = ");
        time_symbol.setText("t = ?");
        
        volume_unit.setText("m³");
        flow_rate_unit.setText("m³/s");
        
        formula.setText(R.string.fluid_flow_time1_formula);
    }
}

