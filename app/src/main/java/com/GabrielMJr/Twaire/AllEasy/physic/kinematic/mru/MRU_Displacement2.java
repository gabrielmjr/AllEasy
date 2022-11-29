package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class MRU_Displacement2 extends MyActivity {
    
    private static EditText delta_time;
    private static EditText media_speed;
    private static TextView displacement;
    private static TextView res;
    private static Button clear;
    
    private static Double time;
    private static Double mediaSpeed;
    private static Boolean verify_Time;
    private static Boolean verify_mediaSpeed;
    private static Tools tools;
    private static MRU mru;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.delta_time = findViewById(R.id.delta_time);
        this.media_speed = findViewById(R.id.media_speed);
        this.displacement = findViewById(R.id.second_displacement);
        this.res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        this.tools = new Tools();
        this.mru = new MRU();
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_displacement2);
        initialize();
        
        this.displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tools.isNull(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.null_field));
                        verify_Time = false;
                    } else if (tools.isDot(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.dot_value));
                        verify_Time = false;
                    } else {
                        time = Double.valueOf(delta_time.getText().toString());
                        verify_Time = true;
                    }


                    if (tools.isNull(media_speed.getText().toString())) {
                       media_speed.setError(getText(R.string.null_field));
                        verify_mediaSpeed = false;
                    } else if (tools.isDot(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.dot_value));
                        verify_mediaSpeed = false;
                    } else {
                        mediaSpeed = Double.valueOf(media_speed.getText().toString());
                        verify_mediaSpeed = true;
                    }


                    if (verify_Time && verify_mediaSpeed) {

                        res.setText( getText(R.string.dsp)
                                    + " "
                                    + delta_time.getText().toString()
                                    + getText(R.string.second)
                                    + " × "
                                    + media_speed.getText().toString()
                                    + getText(R.string.speedmps)
                                    
                                    + "\n"
                                    + getText(R.string.dsp)
                                    + " "
                                    + mru.sVDisplacement(time, mediaSpeed)
                                    + getText(R.string.dm));

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
                    media_speed.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
}
