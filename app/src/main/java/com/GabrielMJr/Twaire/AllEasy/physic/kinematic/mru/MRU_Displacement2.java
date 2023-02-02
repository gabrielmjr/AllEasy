package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.gabrielMJr.twaire.physic.kinematics.mru.MRU;
import com.gabrielMJr.twaire.tools.Tools;

public class MRU_Displacement2 extends MyActivity 
{
    private TextView delta_time_symbol;
    private TextView velocity_symbol;
    private TextView delta_displacement_symbol;
    
    private TextView delta_time_unit;
    private TextView velocity_unit;
    
    private EditText delta_time_value;
    private EditText velocity_value;
    
    private TextView formula;
    private TextView result;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();
        
        /*this.displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tools.isNull(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.null_field));
                        verify_Time = false;
                    } else if (tools.isDot(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.dot_value));
                        verify_Time = false;
                    } else {
                        time = Double.valueOf(delta_time.getText().toString());
                        verify_Time = true;
                    }


                    if (tools.isNull(media_speed.getText().toString())) {
                       media_speed.setError(getText(R.string.null_field));
                        verify_mediaSpeed = false;
                    } else if (tools.isDot(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.dot_value));
                        verify_mediaSpeed = false;
                    } else {
                        mediaSpeed = Double.valueOf(media_speed.getText().toString());
                        verify_mediaSpeed = true;
                    }


                    if (verify_Time && verify_mediaSpeed) {

                        res.setText( getText(R.string.dsp)
                                    + " "
                                    + delta_time.getText().toString()
                                    + getText(R.string.second)
                                    + " × "
                                    + media_speed.getText().toString()
                                    + getText(R.string.speedmps)
                                    
                                    + "\n"
                                    + getText(R.string.dsp)
                                    + " "
                                    + mru.displacement2(time, mediaSpeed)
                                    + getText(R.string.dm));

                                    return;
                    } 
                    else
                    {
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
                    delta_time.setText(null);
                    media_speed.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });*/
    }
    
    
    private void getViews()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        delta_time_symbol = findViewById(R.id.param_0_symbol);
        velocity_symbol = findViewById(R.id.param_1_symbol);
        delta_displacement_symbol = findViewById(R.id.result_symbol);
        
        delta_time_value = findViewById(R.id.param_0_value);
        velocity_value = findViewById(R.id.param_1_value);
        
        delta_time_unit = findViewById(R.id.param_0_unit);
        velocity_unit = findViewById(R.id.param_1_unit);
        
        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
        
        findViewById(R.id.param_2_symbol).setVisibility(View.GONE);
        findViewById(R.id.param_2_value).setVisibility(View.GONE);
        findViewById(R.id.param_2_unit).setVisibility(View.GONE);

        findViewById(R.id.param_3_symbol).setVisibility(View.GONE);
        findViewById(R.id.param_3_value).setVisibility(View.GONE);
        findViewById(R.id.param_3_unit).setVisibility(View.GONE);
    }
    
    
    private void initializeActivity()
    {
        delta_time_symbol.setText("∆t = ");
        velocity_symbol.setText("v = ");
        delta_displacement_symbol.setText("∆S = ?");
        
        delta_time_unit.setText("s");
        velocity_unit.setText("m/s");
        
        formula.setText(R.string.kinematic_mru_displacement2_formula);
    }
}
