package com.GabrielMJr.Twaire.AllEasy.physic.kinematic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;

public class MRU_Initial_Time extends AppCompatActivity {

    private static EditText delta_time;
    private static EditText final_time;
    private static TextView initial_time;
    private static TextView res;
    private static Toolbar toolbar;

    private static int verify_deltaTime;
    private static int verify_finalTime;
    private static double deltaTime;
    private static double finalTime;
    private static Tools tools;
    private static MRU mru;

    private void initialize () {
        delta_time = findViewById(R.id.delta_time);
        final_time = findViewById(R.id.final_time);
        initial_time = findViewById(R.id.initial_time);
        res = findViewById(R.id.res);
        toolbar = findViewById(R.id.toolbar);
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_initial_time);
        initialize();
        setSupportActionBar(toolbar);

        initial_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {

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

                    if (tools.isNull(final_time.getText().toString())) {
                        final_time.setError(getText(R.string.null_field));
                        verify_deltaTime = 0;

                    }
                    else if (tools.isDot(final_time.getText().toString())) {
                        final_time.setError(getText(R.string.dot_value));
                        verify_finalTime = 0;

                    }
                    else {
                        finalTime = Double.valueOf(final_time.getText().toString());
                        verify_finalTime = 1;
                    }

                    if (verify_deltaTime == 1 && verify_finalTime == 1) {
                        res.setText(getText(R.string.initial_time_ig)
                                    + " "
                                    + finalTime
                                    + getText(R.string.second)
                                    + " "
                                    + getText(R.string.minus)
                                    + " "
                                    + deltaTime
                                    + getText(R.string.second)
                                    + getText(R.string.newLine)
                                    + getText(R.string.initial_time_ig)
                                    + " " 
                                    + mru.initial_time(deltaTime, finalTime));
                    }
                }
            });
    }

}
