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

public class MRU_Displacement2 extends MyActivity {
    
    private static EditText delta_time;
    private static EditText media_speed;
    private static TextView displacement;
    private static TextView res;
    
    private static Double time;
    private static Double mediaSpeed;
    private static int verify_Time;
    private static int verify_mediaSpeed;
    private static Tools tools;
    private static MRU mru;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.delta_time = findViewById(R.id.delta_time);
        this.media_speed = findViewById(R.id.media_speed);
        this.displacement = findViewById(R.id.second_displacement);
        this.res = findViewById(R.id.res);
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
                        verify_Time = 0;
                    } else if (tools.isDot(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.dot_value));
                        verify_Time = 0;
                    } else {
                        time = Double.valueOf(delta_time.getText().toString());
                        verify_Time = 1;
                    }


                    if (tools.isNull(media_speed.getText().toString())) {
                       media_speed.setError(getText(R.string.null_field));
                        verify_mediaSpeed = 0;
                    } else if (tools.isDot(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.dot_value));
                        verify_mediaSpeed = 0;
                    } else {
                        mediaSpeed = Double.valueOf(media_speed.getText().toString());
                        verify_mediaSpeed = 1;
                    }


                    if (verify_Time == 1 && verify_mediaSpeed == 1) {

                        res.setText( getText(R.string.dsp)
                                    + " "
                                    + tools.normalize(tools.expNormalizer(Double.valueOf(delta_time.getText().toString())))
                                    + getText(R.string.second)
                                    + " × "
                                    + tools.normalize(tools.expNormalizer(Double.valueOf(media_speed.getText().toString())))
                                    + getText(R.string.speedmps)
                                    
                                    + "\n"
                                    + getText(R.string.dsp)
                                    + " "
                                    + mru.sVDisplacement(time, mediaSpeed)
                                    + getText(R.string.dm));

                    } else {
                        return;
                    }
                }
            });
    }
    
    
    
    
}
