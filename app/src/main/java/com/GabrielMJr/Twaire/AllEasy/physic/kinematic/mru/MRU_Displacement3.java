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
import com.gabrielMJr.twaire.physic.Physic;
import android.widget.Button;


public class MRU_Displacement3 extends MyActivity {
    
    private EditText initial_time;
    private EditText final_time;
    private EditText media_speed;
    private TextView displacement;
    private TextView res;
    private Button clear;
    
    private double initialTime;
    private double finalTime;
    private double mediaSpeed;
    private Boolean verify_initial_time;
    private Boolean verify_final_time;
    private Boolean verify_media_speed;
    private Tools tools;
    private MRU mru;
    private Physic physic;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.initial_time = findViewById(R.id.initial_time);
        this.final_time = findViewById(R.id.final_time);
        this.media_speed = findViewById(R.id.media_speed);
        this.displacement = findViewById(R.id.displacement);
        this.res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        this.tools= new Tools();
        this.mru = new MRU();
        this.physic = new Physic();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_displacement3);
        initialize();
        
        displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                    if (tools.isNull(initial_time.getText().toString())) {
                        initial_time.setError(getText(R.string.null_field));
                        verify_initial_time = false;
                        
                    } else if (tools.isDot(initial_time.getText().toString())) {
                        initial_time.setError(getText(R.string.dot_value));
                        verify_initial_time = false;
                        
                    } else {
                        initialTime = Double.valueOf(initial_time.getText().toString());
                        verify_initial_time = true;
                    }
                    
                    
                    if (tools.isNull(final_time.getText().toString())) {
                        final_time.setError(getText(R.string.null_field));
                        verify_final_time = false;

                    } else if (tools.isDot(final_time.getText().toString())) {
                        final_time.setError(getText(R.string.dot_value));
                        verify_final_time = false;

                    } else {
                        finalTime = Double.valueOf(final_time.getText().toString());
                        verify_final_time = true;
                    }
                    
                    
                    if (tools.isNull(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.null_field));
                        verify_media_speed = false;

                    } else if (tools.isDot(media_speed.getText().toString())) {
                        media_speed.setError(getText(R.string.dot_value));
                        verify_media_speed = false;

                    } else {
                        mediaSpeed = Double.valueOf(media_speed.getText().toString());
                        verify_media_speed = true;
                    }
                    
                    
                    if(verify_initial_time
                      &&
                      verify_final_time
                      &&
                      verify_media_speed) {
                                        
                       res.setText((CharSequence)mru.tVDisplacement(initialTime, finalTime, mediaSpeed, physic.GET_STEP));                       
                          
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
                    final_time.setText(null);
                    media_speed.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
    
}
