package com.GabrielMJr.Twaire.AllEasy.activity.physic.kinematic.mru;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class MRU_Time2 extends BaseActivity {
    
    private TextView delta_time_symbol;
    private TextView delta_displacement_symbol;
    private TextView delta_speed_symbol;
    
    private EditText delta_displacement_value;
    private EditText delta_speed_value;
    
    private TextView delta_displacement_unit;
    private TextView delta_speed_unit;
    
    private TextView formula;
    private TextView result;
    
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();
        
        /*delta_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                    if (tools.isNull(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.null_field));
                        verify_deltaDisplacement = false;
                        
                    } else if (tools.isDot(delta_displacement.getText().toString ())) {
                        delta_displacement.setError(getText(R.string.dot_value));
                        verify_deltaDisplacement = false;
                        
                    } else {
                        deltaDisplacement = Double.valueOf(delta_displacement.getText().toString());
                        verify_deltaDisplacement = true;
                        
                    
                    
                    if (tools.isNull(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.null_field));
                        verify_mediaSpeed = false;
                        
                    } else if (tools.isDot(media_speed.getText().toString ())) {
                        media_speed.setError(getText(R.string.dot_value));
                        verify_mediaSpeed = false;                   
                       
                    } else {
                        mediaSpeed = Double.valueOf(media_speed.getText ().toString());
                        verify_mediaSpeed = true;                    
                    }
                    
                    if (verify_deltaDisplacement && verify_mediaSpeed) {
                        res.setText(getText(R.string.dtp)
                                   + " "
                                   + getText(R.string.openParenthesis)
                                   + deltaDisplacement
                                   + getText(R.string.dm)
                                   + getText (R.string.closeParenthesis)
                                   + " "
                                   + getText(R.string.division)
                                   + " "
                                   + getText(R.string.openParenthesis)
                                   + mediaSpeed
                                   + getText (R.string.speedmps)
                                   + getText(R.string.closeParenthesis)
                                   + getText(R.string.newLine)
                                   + getText(R.string.dtp)
                                   + " "
                                   + mru.time2(deltaDisplacement, mediaSpeed)
                                   + getText(R.string.second));
                                   
                                   return;
                    }
                    else
                    {
                        return;
                    }
                }
            }
            });
            
        this.clear.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    delta_displacement.setText(null);
                    media_speed.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });*/
    }
    
    
    private void getViews()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        delta_time_symbol = findViewById(R.id.result_symbol);
        delta_displacement_symbol = findViewById(R.id.param_0_symbol);
        delta_speed_symbol = findViewById(R.id.param_1_symbol);
        
        delta_displacement_value = findViewById(R.id.param_0_value);
        delta_speed_value = findViewById(R.id.param_1_value);
        
        delta_displacement_unit = findViewById(R.id.param_0_unit);
        delta_speed_unit = findViewById(R.id.param_1_unit);
        
        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }
    
    
    private void initializeActivity()
    {
        delta_time_symbol.setText("∆t = ?");
        delta_displacement_symbol.setText("∆S = ");
        delta_speed_symbol.setText("∆v = ");
        
        delta_displacement_unit.setText("m");
        delta_speed_unit.setText("m/s");
        
        formula.setText(R.string.kinematic_mru_time2_formula);
        
        delta_time_symbol.setVisibility(View.VISIBLE);
        delta_displacement_symbol.setVisibility(View.VISIBLE);
        delta_speed_symbol.setVisibility(View.VISIBLE);
        
        delta_displacement_value.setVisibility(View.VISIBLE);
        delta_speed_value.setVisibility(View.VISIBLE);
        
        delta_displacement_unit.setVisibility(View.VISIBLE);
        delta_speed_unit.setVisibility(View.VISIBLE);
        
        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
