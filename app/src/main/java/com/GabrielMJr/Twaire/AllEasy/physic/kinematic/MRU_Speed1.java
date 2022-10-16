package com.GabrielMJr.Twaire.AllEasy.physic.kinematic;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;

public class MRU_Speed1 extends MyActivity {
    
    private static EditText delta_displacement;
    private static EditText delta_time;
    private static TextView speed;
    private static TextView res;
    
    private static Tools tools;
    private static MRU mru;
    private static int verify_deltaDisplacement;
    private static int verify_deltaTime;
    private static double deltaDisplacement;
    private static double deltaTime;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        delta_displacement=  findViewById(R.id.delta_displacement);
        delta_time = findViewById(R.id.delta_time);
        speed = findViewById(R.id.speed);
        res = findViewById(R.id.res);
        
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
                      verify_deltaDisplacement = 0;
                      
                    } else if (tools.isDot(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.dot_value));
                        verify_deltaDisplacement = 0;
                        
                    } else {
                        deltaDisplacement = Double.valueOf(delta_displacement.getText().toString());
                        verify_deltaDisplacement = 1;
                    }
                    
                    if (tools.isNull(delta_time.getText ().toString())) { 
                        delta_time.setError (getText(R.string.null_field));
                        verify_deltaTime = 0;

                    } else if (tools.isDot(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.dot_value));
                        verify_deltaTime = 0;

                    } else {
                        deltaTime = Double.valueOf(delta_time.getText().toString());
                        verify_deltaTime = 1;
                    }
                    
                    if (verify_deltaDisplacement == 1 && verify_deltaTime == 1) {
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
                                   + mru.speedLaw(deltaDisplacement, deltaTime)
                                   + getText(R.string.speedmps));
                    }
                }
            });
    }
    
}
