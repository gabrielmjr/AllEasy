package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;
import android.view.View.OnClickListener;
import android.view.View;
import com.gabrielMJr.twaire.physic.Physic;
import android.widget.Button;

public class MRU_Speed2 extends MyActivity {
    
    private EditText initial_displacement;
    private EditText final_displacement;
    private EditText initial_time;
    private EditText final_time;
    private TextView speed;
    private TextView res;
    private Button clear;
    
    private Boolean verify_initialDisplacement;
    private boolean verify_finalDisplacement;
    private Boolean verify_initialTime;
    private Boolean verify_finalTime;
    private double initialDisplacement;
    private double finalDisplacement;
    private double initialTime;
    private double finalTime;
    private Tools tools;
    private MRU mru;
    private Physic physic;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        initial_displacement = findViewById(R.id.initial_displacement);
        final_displacement = findViewById(R.id.final_displacement);
        initial_time = findViewById(R.id.initial_time);
        final_time= findViewById(R.id.final_time);
        speed = findViewById(R.id.speed);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);
        
        tools = new Tools();
        mru = new MRU();
        physic = new Physic();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.kinematic_mru_speed_law2);
        initialize();
        
        speed.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tools.isNull(initial_displacement.getText ().toString ())) {
                        initial_displacement.setError(getText(R.string.null_field));
                        verify_initialDisplacement = false;
                        
                    } else if (tools.isDot(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.dot_value));
                        verify_initialDisplacement = false;
                        
                    } else {
                        initialDisplacement = Double.valueOf(initial_displacement.getText ().toString ());
                        verify_initialDisplacement = true;
                    }
                    
                    if (tools.isNull(final_displacement.getText ().toString ())) {
                        final_displacement.setError(getText(R.string.null_field));
                        verify_finalDisplacement = false;

                    } else if (tools.isDot(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.dot_value));
                        verify_finalDisplacement = false;

                    } else {
                        finalDisplacement = Double.valueOf(final_displacement.getText ().toString ());
                        verify_finalDisplacement = true;
                    }
                    
                    if (tools.isNull(initial_time.getText ().toString ())) {
                        initial_time.setError(getText(R.string.null_field));
                        verify_initialTime = false;

                    } else if (tools.isDot(initial_time.getText().toString())) {
                        initial_time.setError(getText(R.string.dot_value));
                        verify_initialTime = false;

                    } else {
                        initialTime = Double.valueOf(initial_time.getText ().toString ());
                        verify_initialTime = true;
                    }
                    
                    if (tools.isNull(final_time.getText ().toString ())) {
                        final_time.setError(getText(R.string.null_field));
                        verify_finalTime = false;
                        
                    } else if (tools.isDot(final_time.getText().toString())) {
                        final_time.setError(getText(R.string.dot_value));
                        verify_finalTime = false;

                    } else {
                        finalTime = Double.valueOf(final_time.getText ().toString ());
                        verify_finalTime = true;
                    }
                    
                    if (verify_initialDisplacement
                        &&
                        verify_finalDisplacement
                        &&
                        verify_initialTime
                        &&
                        verify_finalTime) {
                            
                            res.setText(mru.speedLaw2(initialDisplacement,
                                                      finalDisplacement,
                                                      initialTime, finalTime,
                                                      physic.GET_STEP));
                                                      
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
                    initial_time.setText(null);
                    final_time.setText(null);
                    initial_displacement.setText(null);
                    final_displacement.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
    
}
