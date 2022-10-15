package com.GabrielMJr.Twaire.AllEasy.physic.kinematic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.gabrielMJr.twaire.tools.Tools;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import com.gabrielMJr.twaire.physic.MRU;
import android.view.View.OnClickListener;
import android.view.View;

public class MRU_Final_Time extends AppCompatActivity {

    private static EditText initial_time;
    private static EditText delta_time;
    private static TextView final_time;
    private static TextView res;
    private static Toolbar toolbar;

    private static int verify_initialTime;
    private static int verify_deltaTime;
    private static double initialTime;
    private static double deltaTime;
    private static Tools tools;
    private static MRU mru;

    private void initialize () {
        initial_time = findViewById(R.id.initial_time);
        delta_time =  findViewById(R.id.delta_time);
        final_time = findViewById(R.id.final_time);
        res = findViewById(R.id.res);
        toolbar =  findViewById(R.id.toolbar);
        tools = new Tools();
        mru = new MRU();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_final_time);
        initialize();
        setSupportActionBar(toolbar);

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

                        res.setText(getText(R.string.final_time_ig)
                                    + " "
                                    + initialTime
                                    + getText(R.string.second)
                                    + " "
                                    + getText(R.string.minus)
                                    + " "
                                    + deltaTime
                                    + getText(R.string.second)
                                    + getText(R.string.newLine)
                                    + getText(R.string.final_time_ig)
                                    + " "
                                    + mru.final_time(initialTime, deltaTime)
                                    + getText(R.string.second));
                    }
                }
            });
    }

}
