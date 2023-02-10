package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;

public class MRU_Displacement_Law extends MyActivity
{
    private TextView initial_displacement_symbol;
    private TextView velocity_symbol;
    private TextView delta_time_symbol;
    private TextView displacement_symbol;
    
    private EditText initial_displacement_value;
    private EditText velocity_value;
    private EditText delta_time_value;
    
    private TextView initial_displacement_unit;
    private TextView velocity_unit;
    private TextView delta_time_unit;
    
    private TextView formula;
    private TextView result;
    
    
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_displacement_law);
        getViews();
        initializeActivity();
        
       /* displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {

                    if (tools.isNull(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.null_field));
                        verifyInitialDisplacement = false;

                    }
                    else if (tools.isDot(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.dot_value));
                        verifyInitialDisplacement = false;

                    }
                    else {
                        initialDisplacement = Double.valueOf(initial_displacement.getText().toString());
                        verifyInitialDisplacement = true;
                    }

                    if (tools.isNull(speed.getText().toString())) {
                        speed.setError(getText(R.string.null_field));
                        verifySpeed = false;

                    }
                    else if (tools.isDot(speed.getText().toString())) {
                        speed.setError(getText(R.string.dot_value));
                        verifySpeed = false;

                    }
                    else {
                        speedValue = Double.valueOf(speed.getText().toString());
                        verifySpeed = true;
                    }

                    if (tools.isNull(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.null_field));
                        verifyDeltaTime = false;

                    }
                    else if (tools.isDot(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.dot_value));
                        verifyDeltaTime = false;

                    }
                    else {
                        deltaTime = Double.valueOf(delta_time.getText().toString());
                        verifyDeltaTime = true;
                    }

                    if (verifyInitialDisplacement
                        &&
                        verifySpeed
                        &&
                        verifyDeltaTime) {
                        res.setText(mru.displacement6(initialDisplacement, speedValue, deltaTime, physic.GET_STEP));

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
                    speed.setText(null);
                    delta_time.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });*/
    }
    
    
    private void getViews()
    {
        initial_displacement_symbol = findViewById(R.id.param_0_symbol);
        velocity_symbol = findViewById(R.id.param_1_symbol);
        delta_time_symbol = findViewById(R.id.param_2_value);
        displacement_symbol = findViewById(R.id.result_symbol);
        
        initial_displacement_value = findViewById(R.id.param_0_value);
        velocity_value = findViewById(R.id.param_1_value);
        delta_time_value = findViewById(R.id.param_2_value);
        
        initial_displacement_unit = findViewById(R.id.param_0_unit);
        velocity_unit = findViewById(R.id.param_1_unit);
        delta_time_unit = findViewById(R.id.param_2_unit);
        
        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
        
        
    }
    
    
    private void initializeActivity()
    {
        
    }

}
