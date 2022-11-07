package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.gabrielMJr.twaire.tools.Tools;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import com.gabrielMJr.twaire.physic.MRU;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class MRU_Final_Time extends MyActivity {

    private static EditText initial_time;
    private static EditText delta_time;
    private static TextView final_time;
    private static TextView res;
    private static Button clear;
    
    private static int verify_initialTime;
    private static int verify_deltaTime;
    private static double initialTime;
    private static double deltaTime;
    private static Tools tools;
    private static MRU mru;

    private void initialize () {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        initial_time = findViewById(R.id.initial_time);
        delta_time =  findViewById(R.id.delta_time);
        final_time = findViewById(R.id.final_time);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);
        
        tools = new Tools();
        mru = new MRU();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_final_time);
        initialize();
        
        final_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {

                    if (tools.isNull(initial_time.getText().toString())) {
                        initial_time.setError(getText(R.string.null_field));
                        verify_initialTime = 0;

                    }
                    else if (tools.isDot(initial_time.getText().toString())) {
                        initial_time.setError(getText(R.string.dot_value));
                        verify_initialTime = 0;

                    }
                    else {
                        initialTime = Double.valueOf(initial_time.getText().toString());
                        verify_initialTime = 1;
                    }

                    if (tools.isNull(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.null_field));
                        verify_deltaTime = 0;

                    }
                    else if (tools.isDot(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.dot_value));
                        verify_deltaTime = 0;

                    }
                    else {
                        deltaTime = Double.valueOf(delta_time.getText().toString());
                        verify_deltaTime = 1;
                    }

                    if (verify_initialTime == 1 && verify_deltaTime == 1) {

                        res.setText(getText(R.string.final_timep)
                                    + " "
                                    + initialTime
                                    + getText(R.string.second)
                                    + " "
                                    + getText(R.string.plus)
                                    + " "
                                    + deltaTime
                                    + getText(R.string.second)
                                    + getText(R.string.newLine)
                                    + getText(R.string.final_timep)
                                    + " "
                                    + mru.final_time(initialTime ,deltaTime)
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
                    delta_time.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }

}
