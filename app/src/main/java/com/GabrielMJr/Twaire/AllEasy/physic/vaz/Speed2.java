package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.FluidFlow;
import android.support.v7.widget.Toolbar;

public class Speed2 extends MyActivity {
    
	private static EditText vaz;
	private static EditText ra;
	private static TextView speed;
	private static TextView res;
    
	private static Tools Tools;
	private static int verifyVaz;
	private static int verifyRay;
	private static double fluidFlow;
	private static double raio;
	private static FluidFlow FF;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.vaz = findViewById(R.id.vaz);
        this.ra = findViewById(R.id.ra);
        this.speed = findViewById(R.id.speed);
        this.res = findViewById(R.id.res);
        this.Tools = new Tools();
		this.FF = new FluidFlow();
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
                            verifyVaz = 0;
                        } else if (Tools.isDot(vaz.getText().toString())) {
							vaz.setError(getText(R.string.dot_value));
							verifyVaz = 0;
						} else {
                            fluidFlow = Double.valueOf(vaz.getText().toString());
                            verifyVaz = 1;
                        }

                    
                        if (Tools.isNull(ra.getText().toString())) {
                            ra.setError(getText(R.string.null_field));
                            verifyRay = 0;
                        } else if (Tools.isDot(ra.getText().toString())) {
							ra.setError(getText(R.string.dot_value));
							verifyRay = 0;
						} else {
                            raio = Double.valueOf(ra.getText().toString());
                            verifyRay = 1;
                        }


                    if (verifyVaz == 1 && verifyRay == 1) {
                        res.setText((CharSequence) FF.sSpeed(fluidFlow, raio, FF.getStep));
                    } else {
                        return;
                    }
				}
			});
    }
    
}
