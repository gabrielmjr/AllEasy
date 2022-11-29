package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class MRU_Initial_Time extends MyActivity {

    private static EditText delta_time;
    private static EditText final_time;
    private static TextView initial_time;
    private static TextView res;
    private static Button clear;
    
    private static Boolean verify_deltaTime;
    private static Boolean verify_finalTime;
    private static double deltaTime;
    private static double finalTime;
    private static Tools tools;
    private static MRU mru;

    private void initialize () {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        delta_time = findViewById(R.id.delta_time);
        final_time = findViewById(R.id.final_time);
        initial_time = findViewById(R.id.initial_time);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);
        
        tools = new Tools();
        mru = new MRU();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_initial_time);
        initialize();
        
        initial_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {

                    if (tools.isNull(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.null_field));
                        verify_deltaTime = false;

                    }
                    else if (tools.isDot(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.dot_value));
                        verify_deltaTime = false;

                    }
                    else {
                        deltaTime = Double.valueOf(delta_time.getText().toString());
                        verify_deltaTime = true;
                    }

                    if (tools.isNull(final_time.getText().toString())) {
                        final_time.setError(getText(R.string.null_field));
                        verify_finalTime = false;

                    }
                    else if (tools.isDot(final_time.getText().toString())) {
                        final_time.setError(getText(R.string.dot_value));
                        verify_finalTime = false;

                    }
                    else {
                        finalTime = Double.valueOf(final_time.getText().toString());
                        verify_finalTime = true;
                    }

                    if (verify_deltaTime && verify_finalTime) {
                        res.setText(getText(R.string.initial_timep)
                                    + " "
                                    + finalTime
                                    + getText(R.string.second)
                                    + " "
                                    + getText(R.string.minus)
                                    + " "
                                    + deltaTime
                                    + getText(R.string.second)
                                    + getText(R.string.newLine)
                                    + getText(R.string.initial_timep)
                                    + " " 
                                    + mru.initial_time(deltaTime, finalTime)
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
                    delta_time.setText(null);
                    final_time.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }

}
