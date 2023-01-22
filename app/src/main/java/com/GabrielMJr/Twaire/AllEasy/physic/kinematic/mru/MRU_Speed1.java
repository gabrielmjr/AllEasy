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

public class MRU_Speed1 extends MyActivity {
    
    private EditText delta_displacement;
    private EditText delta_time;
    private TextView speed;
    private TextView res;
    private Button clear;
    
    private Tools tools;
    private MRU mru;
    private Boolean verify_deltaDisplacement;
    private Boolean verify_deltaTime;
    private double deltaDisplacement;
    private double deltaTime;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        delta_displacement=  findViewById(R.id.delta_displacement);
        delta_time = findViewById(R.id.delta_time);
        speed = findViewById(R.id.speed);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);
        
        tools = new Tools();
        mru = new MRU();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_speed_law1);
        initialize();
        
        
        speed.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    
                    if (tools.isNull(delta_displacement.getText ().toString())) { 
                      delta_displacement.setError (getText(R.string.null_field));
                      verify_deltaDisplacement = false;
                      
                    } else if (tools.isDot(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.dot_value));
                        verify_deltaDisplacement = false;
                        
                    } else {
                        deltaDisplacement = Double.valueOf(delta_displacement.getText().toString());
                        verify_deltaDisplacement = true;
                    }
                    
                    if (tools.isNull(delta_time.getText ().toString())) { 
                        delta_time.setError (getText(R.string.null_field));
                        verify_deltaTime = false;

                    } else if (tools.isDot(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.dot_value));
                        verify_deltaTime = false;

                    } else {
                        deltaTime = Double.valueOf(delta_time.getText().toString());
                        verify_deltaTime = true;
                    }
                    
                    if (verify_deltaDisplacement && verify_deltaTime) {
                        res.setText(getText(R.string.speedp)
                                   + " "
                                   + deltaDisplacement
                                   + getText(R.string.dm)
                                   + " / "
                                   + deltaTime
                                   + getText(R.string.second)
                                   + "\n"
                                   + getText(R.string.speedp)
                                   + " "
                                   + mru.speed1(deltaDisplacement, deltaTime)
                                   + getText(R.string.speedmps));
                        
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
                    delta_displacement.setText(null);
                    delta_time.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
    
}
