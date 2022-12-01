package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import com.gabrielMJr.twaire.physic.FluidFlow;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.gabrielMJr.twaire.tools.Tools;
import android.support.v7.widget.Toolbar;

public class FlowRate1 extends MyActivity {
    
	private EditText vol;
    private TextView res;
	private EditText dt;
	private TextView vaz;
    private Button clear;
    
	private Double volume;
	private Double time;
	private Tools Tools;
	private Boolean verifyVolume;
	private Boolean verifyTime;
    private FluidFlow FF;
  
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.vol = findViewById(R.id.ff1_vol);
        this.dt = findViewById(R.id.ff1_dt);
        this.vaz = findViewById(R.id.ff1_vaz);
        this.res = findViewById(R.id.ff1_res);
        this.clear = findViewById(R.id.clear);
        this.FF = new FluidFlow();
		this.Tools = new Tools();
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fluid_flow_flow_rate1);
        this.initialize();
        
		this.vaz.setOnClickListener(
			new OnClickListener() {
				public void onClick(View view) {				

                    // Verificar se volume é nulo ou ponto através do método Tools
                    if (Tools.isNull(vol.getText().toString())) {
                        vol.setError(getText(R.string.null_field));
                        verifyVolume = false;

					    // Se for ponto, pare
                    } else if (Tools.isDot(vol.getText().toString())) {
                        vol.setError(getText(R.string.dot_value));
                        verifyVolume = false;

                        // Se não for nulo, continue
                    } else {           
                        volume = Double.valueOf(vol.getText().toString());
                        verifyVolume = true;
                    }


                    // Verificar se delta tempo é nulo
                    if (Tools.isNull(dt.getText().toString())) {                        
                        dt.setError(getText(R.string.null_field));
                        verifyTime = false;

					    // Se for ponto, pare
                    } else if (Tools.isDot(dt.getText().toString())) {
                        dt.setError(getText(R.string.dot_value));
                        verifyTime = false;

					    // Se não for, continue
                    } else {
                        time = Double.valueOf(dt.getText().toString());
                        verifyTime = true;
                    }

                    
                    // Se os valores VerifyVolume e time forem true, efectuar a operação
                    if (verifyVolume && verifyTime) {
                        res.setText(getText(R.string.flowRatep)
                                    + " "
                                    + volume 
                                    + getText(R.string.vmc)
                                    + getText(R.string.division)
                                    + time
                                    + getText(R.string.second));

                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.flowRatep)
                                    + " "
                                    + FF.fFluidFlow(volume, time)
                                    + getText(R.string.speedmcps));
                                    
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
                    vol.setText(null);
                    dt.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
}
