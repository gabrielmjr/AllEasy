package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.gabrielMJr.twaire.physic.Physic;
import com.gabrielMJr.twaire.physic.hydrodynamics.fluidflow.FluidFlow;
import com.gabrielMJr.twaire.tools.Tools;

public class Speed2 extends MyActivity {
    
	private EditText vaz;
	private EditText ra;
	private TextView speed;
	private TextView res;
    private Button clear;
    
	private Tools Tools;
	private Boolean verifyVaz;
	private Boolean verifyRay;
	private double fluidFlow;
	private double raio;
	private FluidFlow FF;
    private Physic physic;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.vaz = findViewById(R.id.vaz);
        this.ra = findViewById(R.id.ra);
        this.speed = findViewById(R.id.speed);
        this.res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        this.Tools = new Tools();
		this.FF = new FluidFlow();
        this.physic = new Physic();
    }
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluid_flow_speed2);
		this.initialize();
        
		this.speed.setOnClickListener(
            new OnClickListener() {
				public void onClick(View view) {

                        if (Tools.isNull(vaz.getText().toString())) {
                            vaz.setError(getText(R.string.null_field));
                            verifyVaz = false;
                        } else if (Tools.isDot(vaz.getText().toString())) {
							vaz.setError(getText(R.string.dot_value));
							verifyVaz = false;
						} else {
                            fluidFlow = Double.valueOf(vaz.getText().toString());
                            verifyVaz = true;
                        }

                    
                        if (Tools.isNull(ra.getText().toString())) {
                            ra.setError(getText(R.string.null_field));
                            verifyRay = false;
                        } else if (Tools.isDot(ra.getText().toString())) {
							ra.setError(getText(R.string.dot_value));
							verifyRay = false;
						} else {
                            raio = Double.valueOf(ra.getText().toString());
                            verifyRay = true;
                        }


                    if (verifyVaz && verifyRay) {
                        res.setText((CharSequence) FF.speed2(fluidFlow, raio, physic.GET_STEP));
                        
                        return;
                    } else {
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
                    vaz.setText(null);
                    ra.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
    
}
