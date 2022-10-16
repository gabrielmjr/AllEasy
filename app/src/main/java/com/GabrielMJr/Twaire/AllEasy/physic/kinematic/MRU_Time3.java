package com.GabrielMJr.Twaire.AllEasy.physic.kinematic;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;

public class MRU_Time3 extends MyActivity {

    private static EditText initial_displacement;
    private static EditText final_displacement;
    private static EditText media_speed;
    private static TextView delta_time;
    private static TextView res;
    
    private static int verify_initialDisplacement;
    private static int verify_finalDisplacement;
    private static int verify_mediaSpeed;
    private static double initialDisplacement;
    private static double finalDisplacement;
    private static double mediaSpeed;
    private static Tools tools;
    private static MRU mru;


    private void initialize () {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        initial_displacement = findViewById(R.id.initial_displacement);
        final_displacement = findViewById(R.id.final_displacement);
        media_speed = findViewById(R.id.media_speed);
        delta_time = findViewById(R.id.delta_time);
        res = findViewById(R.id.res);
        
        tools = new Tools();
        mru = new MRU();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_time3);
        initialize();
        
        delta_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {

                    if (tools.isNull(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.null_field));
                        verify_initialDisplacement = 0;

                    }
                    else if (tools.isDot(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.dot_value));
                        verify_initialDisplacement = 0;

                    }
                    else {
                        initialDisplacement = Double.valueOf(initial_displacement.getText().toString());
                        verify_initialDisplacement = 1;
                    }

                    if (tools.isNull(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.null_field));
                        verify_finalDisplacement = 0;

                    }
                    else if (tools.isDot(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.dot_value));
                        verify_finalDisplacement = 0;

                    }
                    else {
                        finalDisplacement = Double.valueOf(final_displacement.getText().toString());
                        verify_finalDisplacement = 1;
                    }

                    if (tools.isNull(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.null_field));
                        verify_mediaSpeed = 0;

                    }
                    else if (tools.isDot(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.dot_value));
                        verify_mediaSpeed = 0;

                    }
                    else {
                        mediaSpeed = Double.valueOf(media_speed.getText().toString());
                        verify_mediaSpeed = 1;
                    }

                    if (verify_initialDisplacement == 1
                        &&
                        verify_finalDisplacement == 1
                        &&
                        verify_mediaSpeed == 1) {

                        res.setText(mru.tVTime(initialDisplacement, finalDisplacement, mediaSpeed, mru.getStep));
                    }
                }
            });
    }

}
