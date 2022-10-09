package com.GabrielMJr.Twaire.AllEasy.physic.kinematic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;
import android.view.View.OnClickListener;
import android.view.View;

public class MRU_Speed2 extends AppCompatActivity {
    
    private static EditText initial_displacement;
    private static EditText final_displacement;
    private static EditText initial_time;
    private static EditText final_time;
    private static TextView speed;
    private static TextView res;
    private static Toolbar toolbar;
    
    private static int verify_initialDisplacement;
    private static int verify_finalDisplacement;
    private static int verify_initialTime;
    private static int verify_finalTime;
    private static double initialDisplacement;
    private static double finalDisplacement;
    private static double initialTime;
    private static double finalTime;
    private static Tools tools;
    private static MRU mru;
    
    private void initialize() {
        initial_displacement = findViewById(R.id.initial_displacement);
        final_displacement = findViewById(R.id.final_displacement);
        initial_time = findViewById(R.id.initial_time);
        final_time= findViewById(R.id.final_time);
        speed = findViewById(R.id.speed);
        res = findViewById(R.id.res);
        toolbar = findViewById(R.id.toolbar);
        
        tools = new Tools();
        mru = new MRU();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.kinematic_mru_speed_law2);
        initialize();
        setSupportActionBar(toolbar);
        
        speed.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tools.isNull(initial_displacement.getText ().toString ())) {
                        initial_displacement.setError(getText(R.string.null_field));
                        verify_initialDisplacement = 0;
                        
                    } else if (tools.isDot(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.dot_value));
                        verify_initialDisplacement = 0;
                        
                    } else {
                        initialDisplacement = Double.valueOf(initial_displacement.getText ().toString ());
                        verify_initialDisplacement = 1;
                    }
                    
                    if (tools.isNull(final_displacement.getText ().toString ())) {
                        final_displacement.setError(getText(R.string.null_field));
                        verify_finalDisplacement = 0;

                    } else if (tools.isDot(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.dot_value));
                        verify_finalDisplacement = 0;

                    } else {
                        finalDisplacement = Double.valueOf(final_displacement.getText ().toString ());
                        verify_finalDisplacement = 1;
                    }
                    
                    if (tools.isNull(initial_time.getText ().toString ())) {
                        initial_time.setError(getText(R.string.null_field));
                        verify_initialTime = 0;

                    } else if (tools.isDot(initial_time.getText().toString())) {
                        initial_time.setError(getText(R.string.dot_value));
                        verify_initialTime = 0;

                    } else {
                        initialTime = Double.valueOf(initial_time.getText ().toString ());
                        verify_initialTime = 1;
                    }
                    
                    if (tools.isNull(final_time.getText ().toString ())) {
                        final_time.setError(getText(R.string.null_field));
                        verify_finalTime = 0;
                        
                    } else if (tools.isDot(final_time.getText().toString())) {
                        final_time.setError(getText(R.string.dot_value));
                        verify_finalTime = 0;

                    } else {
                        finalTime = Double.valueOf(final_time.getText ().toString ());
                        verify_finalTime = 1;
                    }
                    
                    if (verify_initialDisplacement == 1
                        &&
                        verify_finalDisplacement == 1
                        &&
                        verify_initialTime == 1
                        &&
                        verify_finalTime == 1) {
                            
                            res.setText(mru.speedLaw2(initialDisplacement,
                                                      finalDisplacement,
                                                      initialTime, finalTime,
                                                      mru.getStep));
                        }
                }
            });
    }
    
}
