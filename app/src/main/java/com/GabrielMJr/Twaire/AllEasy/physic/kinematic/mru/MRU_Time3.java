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
import com.gabrielMJr.twaire.physic.Physic;
import com.gabrielMJr.twaire.physic.kinematics.mru.MRU;
import com.gabrielMJr.twaire.tools.Tools;

public class MRU_Time3 extends MyActivity 
{

    private TextView initial_displacement_symbol;
    private TextView final_displacement_symbol;
    private TextView velocity_symbol;
    private TextView time_symbol;
    
    private EditText initial_displacement_value;
    private EditText final_displacement_value;
    private EditText velocity_value;
    
    private TextView initial_displacement_unit;
    private TextView final_displacement_unit;
    private TextView velocity_unit;
    
    private TextView formula;
    private TextView result;
    
    
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();
        
       /* delta_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {

                    if (tools.isNull(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.null_field));
                        verify_initialDisplacement = false;

                    }
                    else if (tools.isDot(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.dot_value));
                        verify_initialDisplacement = false;

                    }
                    else {
                        initialDisplacement = Double.valueOf(initial_displacement.getText().toString());
                        verify_initialDisplacement = true;
                    }

                    if (tools.isNull(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.null_field));
                        verify_finalDisplacement = false;

                    }
                    else if (tools.isDot(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.dot_value));
                        verify_finalDisplacement = false;

                    }
                    else {
                        finalDisplacement = Double.valueOf(final_displacement.getText().toString());
                        verify_finalDisplacement = true;
                    }

                    if (tools.isNull(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.null_field));
                        verify_mediaSpeed = false;

                    }
                    else if (tools.isDot(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.dot_value));
                        verify_mediaSpeed = false;

                    }
                    else {
                        mediaSpeed = Double.valueOf(media_speed.getText().toString());
                        verify_mediaSpeed = true;
                    }

                    if (verify_initialDisplacement
                        &&
                        verify_finalDisplacement
                        &&
                        verify_mediaSpeed) {

                        res.setText(mru.time3(initialDisplacement, finalDisplacement, mediaSpeed, physic.GET_STEP));
                        
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
                    initial_displacement.setText(null);
                    final_displacement.setText(null);
                    media_speed.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });*/
    }
    
    
    private void getViews()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        initial_displacement_symbol = findViewById(R.id.param_0_symbol);
        final_displacement_symbol = findViewById(R.id.param_1_symbol);
        velocity_symbol = findViewById(R.id.param_2_symbol);
        time_symbol = findViewById(R.id.result_symbol);
        
        initial_displacement_value = findViewById(R.id.param_0_value);
        final_displacement_value = findViewById(R.id.param_1_value);
        velocity_value = findViewById(R.id.param_2_value);
        
        initial_displacement_unit = findViewById(R.id.param_0_unit);
        final_displacement_unit = findViewById(R.id.param_1_unit);
        velocity_unit = findViewById(R.id.param_2_unit);
        
        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }
    
    
    private void initializeActivity()
    {
        initial_displacement_symbol.setText("Si = ");
        final_displacement_symbol.setText("S = ");
        velocity_symbol.setText("v = ");
        time_symbol.setText("t = ?");
        
        initial_displacement_unit.setText("m");
        final_displacement_unit.setText("m");
        velocity_unit.setText("m/s");
        
        formula.setText(R.string.kinematic_mru_displacement3_formula);
        
        initial_displacement_symbol.setVisibility(View.VISIBLE);
        final_displacement_symbol.setVisibility(View.VISIBLE);
        velocity_symbol.setVisibility(View.VISIBLE);
        time_symbol.setVisibility(View.VISIBLE);
        
        initial_displacement_value.setVisibility(View.VISIBLE);
        final_displacement_value.setVisibility(View.VISIBLE);
        velocity_value.setVisibility(View.VISIBLE);
        
        initial_displacement_unit.setVisibility(View.VISIBLE);
        final_displacement_unit.setVisibility(View.VISIBLE);
        velocity_unit.setVisibility(View.VISIBLE);
        
        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
