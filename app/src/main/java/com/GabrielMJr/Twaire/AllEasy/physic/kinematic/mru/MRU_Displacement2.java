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

public class MRU_Displacement2 extends MyActivity {
    
    private EditText delta_time;
    private EditText media_speed;
    private TextView displacement;
    private TextView res;
    private Button clear;
    
    private Double time;
    private Double mediaSpeed;
    private Boolean verify_Time;
    private Boolean verify_mediaSpeed;
    private Tools tools;
    private MRU mru;
    
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
                                    + mru.displacement2(time, mediaSpeed)
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
