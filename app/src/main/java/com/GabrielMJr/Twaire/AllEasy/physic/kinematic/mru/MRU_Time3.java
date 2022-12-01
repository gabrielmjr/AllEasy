package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

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
import com.gabrielMJr.twaire.physic.Physic;
import android.widget.Button;

public class MRU_Time3 extends MyActivity {

    private EditText initial_displacement;
    private EditText final_displacement;
    private EditText media_speed;
    private TextView delta_time;
    private TextView res;
    private Button clear;
    
    private Boolean verify_initialDisplacement;
    private Boolean verify_finalDisplacement;
    private Boolean verify_mediaSpeed;
    private double initialDisplacement;
    private double finalDisplacement;
    private double mediaSpeed;
    private Tools tools;
    private MRU mru;
    private Physic physic;


    private void initialize () {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        initial_displacement = findViewById(R.id.initial_displacement);
        final_displacement = findViewById(R.id.final_displacement);
        media_speed = findViewById(R.id.media_speed);
        delta_time = findViewById(R.id.delta_time);
        res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        
        tools = new Tools();
        mru = new MRU();
        physic = new Physic();
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
                        verify_initialDisplacement = false;

                    }
                    else if (tools.isDot(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.dot_value));
                        verify_initialDisplacement = false;

                    }
                    else {
                        initialDisplacement = Double.valueOf(initial_displacement.getText().toString());
                        verify_initialDisplacement = true;
                    }

                    if (tools.isNull(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.null_field));
                        verify_finalDisplacement = false;

                    }
                    else if (tools.isDot(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.dot_value));
                        verify_finalDisplacement = false;

                    }
                    else {
                        finalDisplacement = Double.valueOf(final_displacement.getText().toString());
                        verify_finalDisplacement = true;
                    }

                    if (tools.isNull(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.null_field));
                        verify_mediaSpeed = false;

                    }
                    else if (tools.isDot(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.dot_value));
                        verify_mediaSpeed = false;

                    }
                    else {
                        mediaSpeed = Double.valueOf(media_speed.getText().toString());
                        verify_mediaSpeed = true;
                    }

                    if (verify_initialDisplacement
                        &&
                        verify_finalDisplacement
                        &&
                        verify_mediaSpeed) {

                        res.setText(mru.tVTime(initialDisplacement, finalDisplacement, mediaSpeed, physic.GET_STEP));
                        
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
                    initial_displacement.setText(null);
                    final_displacement.setText(null);
                    media_speed.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }

}
