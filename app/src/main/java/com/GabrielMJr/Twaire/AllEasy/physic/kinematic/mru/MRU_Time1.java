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
import android.widget.Button;

public class MRU_Time1 extends MyActivity {
    
    private static EditText initial_time;
    private static EditText final_time;
    private static TextView delta_time;
    private static TextView res;
    private static Button clear;
    
    private static int verify_initialTime;
    private static int verify_finalTime;
    private static double initialTime;
    private static double finalTime;
    private static Tools tools;
    private static MRU mru;
    
    public void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        initial_time = findViewById(R.id.initial_time);
        final_time = findViewById(R.id.final_time);
        delta_time = findViewById(R.id.delta_time);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);
        
        tools = new Tools();
        mru = new MRU();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_time1);
        initialize();
        
        delta_time.setOnClickListener (
            new OnClickListener () {
                @Override
                public void onClick(View view) {
                    
                    if (tools.isNull(initial_time.getText().toString())) {
                        initial_time.setError (getText(R.string.null_field));
                        verify_initialTime = 0;
                        
                    } else if (tools.isDot(initial_time.getText().toString())) {
                        initial_time.setError (getText(R.string.dot_value));
                        verify_initialTime = 0;
                        
                    } else {
                        initialTime = Double.valueOf(initial_time.getText().toString());
                        verify_initialTime = 1;
                    }
                    
                    if (tools.isNull(final_time.getText().toString())) {
                        final_time.setError (getText(R.string.null_field));
                        verify_finalTime = 0;

                    } else if (tools.isDot(final_time.getText().toString())) {
                        final_time.setError (getText(R.string.dot_value));
                        verify_finalTime = 0;

                    } else {
                        finalTime = Double.valueOf(final_time.getText().toString());
                        verify_finalTime = 1;
                    }
                    
                    if (verify_initialTime == 1 && verify_finalTime == 1) {
                        res.setText(getText(R.string.dtp)
                                   + " "
                                   + finalTime
                                   + getText(R.string.second)
                                   + " "
                                   + getText(R.string.minus)
                                   + " "
                                   + initialTime
                                   + getText(R.string.second)
                                   + getText(R.string.newLine)
                                   + getText(R.string.dtp)
                                   + " "
                                   + mru.fVTime(initialTime, finalTime)
                                   + getText(R.string.second));
                                   
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
                    res.setText(null);
                    
                    return;
                }
            });
    }
    
}
