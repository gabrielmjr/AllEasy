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
import android.widget.Button;

public class MRU_Time2 extends MyActivity {
    
    private EditText delta_displacement;
    private EditText media_speed;
    private TextView delta_time;
    private TextView res;
    private Button clear;
    
    private Boolean verify_deltaDisplacement;
    private Boolean verify_mediaSpeed;
    private double deltaDisplacement;
    private double mediaSpeed;
    private Tools tools;
    private MRU mru;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        delta_displacement=  findViewById(R.id.delta_displacement);
        media_speed = findViewById(R.id.media_speed);
        delta_time = findViewById(R.id.delta_time);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);
        tools = new Tools();
        mru = new MRU();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_time2);
        initialize();
        
        delta_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                    if (tools.isNull(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.null_field));
                        verify_deltaDisplacement = false;
                        
                    } else if (tools.isDot(delta_displacement.getText().toString ())) {
                        delta_displacement.setError(getText(R.string.dot_value));
                        verify_deltaDisplacement = false;
                        
                    } else {
                        deltaDisplacement = Double.valueOf(delta_displacement.getText().toString());
                        verify_deltaDisplacement = true;
                        
                    
                    
                    if (tools.isNull(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.null_field));
                        verify_mediaSpeed = false;
                        
                    } else if (tools.isDot(media_speed.getText().toString ())) {
                        media_speed.setError(getText(R.string.dot_value));
                        verify_mediaSpeed = false;                   
                       
                    } else {
                        mediaSpeed = Double.valueOf(media_speed.getText ().toString());
                        verify_mediaSpeed = true;                    
                    }
                    
                    if (verify_deltaDisplacement && verify_mediaSpeed) {
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
                                   
                                   return;
                    }
                    else
                    {
                        return;
                    }
                }
            }
            });
            
        this.clear.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    delta_displacement.setText(null);
                    media_speed.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
    
}
