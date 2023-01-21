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

public class MRU_Final_Time extends MyActivity {

    private EditText initial_time;
    private EditText delta_time;
    private TextView final_time;
    private TextView res;
    private Button clear;
    
    private Boolean verify_initialTime;
    private Boolean verify_deltaTime;
    private double initialTime;
    private double deltaTime;
    private Tools tools;
    private MRU mru;

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
                        verify_initialTime = false;

                    }
                    else if (tools.isDot(initial_time.getText().toString())) {
                        initial_time.setError(getText(R.string.dot_value));
                        verify_initialTime = false;

                    }
                    else {
                        initialTime = Double.valueOf(initial_time.getText().toString());
                        verify_initialTime = true;
                    }

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

                    if (verify_initialTime && verify_deltaTime) {

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
                                    + mru.time5(initialTime ,deltaTime)
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
