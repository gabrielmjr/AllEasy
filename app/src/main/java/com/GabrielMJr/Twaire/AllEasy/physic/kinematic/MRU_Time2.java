package com.GabrielMJr.Twaire.AllEasy.physic.kinematic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;

public class MRU_Time2 extends AppCompatActivity {
    
    private static EditText delta_displacement;
    private static EditText media_speed;
    private static TextView delta_time;
    private static TextView res;
    private static Toolbar toolbar;
    
    private static int verify_deltaDisplacement;
    private static int verify_mediaSpeed;
    private static double deltaDisplacement;
    private static double mediaSpeed;
    private static Tools tools;
    private static MRU mru;
    
    private void initialize() {
        delta_displacement=  findViewById(R.id.delta_displacement);
        media_speed = findViewById(R.id.media_speed);
        delta_time = findViewById(R.id.delta_time);
        res = findViewById(R.id.res);
        toolbar = findViewById(R.id.toolbar);
        tools = new Tools();
        mru = new MRU();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_time2);
        initialize();
        setSupportActionBar(toolbar);
        
        delta_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                    if (tools.isNull(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.null_field));
                        verify_deltaDisplacement = 0;
                        
                    } else if (tools.isDot(delta_displacement.getText().toString ())) {
                        delta_displacement.setError(getText(R.string.dot_value));
                        verify_deltaDisplacement = 0;
                        
                    } else {
                        deltaDisplacement = Double.valueOf(delta_displacement.getText().toString());
                        verify_deltaDisplacement = 1;
                        
                    }
                    
                    if (tools.isNull(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.null_field));
                        verify_mediaSpeed = 0;
                        
                    } else if (tools.isDot(media_speed.getText().toString ())) {
                        media_speed.setError(getText(R.string.dot_value));
                        verify_mediaSpeed = 0;                   
                       
                    } else {
                        mediaSpeed = Double.valueOf(media_speed.getText ().toString());
                        verify_mediaSpeed = 1;                    
                    }
                    
                    if (verify_deltaDisplacement == 1 && verify_mediaSpeed == 1) {
                        res.setText(getText(R.string.dtp)
                                   + " "
                                   + getText(R.string.openParenthesis)
                                   + deltaDisplacement
                                   + getText(R.string.dm)
                                   + getText (R.string.closeParenthesis)
                                   + " "
                                   + getText(R.string.division)
                                   + " "
                                   + getText(R.string.openParenthesis)
                                   + mediaSpeed
                                   + getText (R.string.speedmps)
                                   + getText(R.string.closeParenthesis)
                                   + getText(R.string.newLine)
                                   + getText(R.string.dtp)
                                   + " "
                                   + mru.sVTime(deltaDisplacement, mediaSpeed)
                                   + getText(R.string.second));
                    }
                        
                }
            });
    }
    
}
