package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.support.v7.app.AppCompatActivity;
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

public class FlowRate1 extends AppCompatActivity {
    
	private static EditText vol;
    private static TextView res;
	private static EditText dt;
	private static TextView vaz;
    private static Toolbar toolbar;
    
	private static Double volume;
	private static Double time;
	private static Tools Tools;
	private static Integer verifyVolume;
	private static Integer verifyTime;
    private static FluidFlow FF;
    
    private void initialize() {
        this.vol = findViewById(R.id.vol);
        this.dt = findViewById(R.id.dt);
        this.vaz = findViewById(R.id.vaz);
        this.res = findViewById(R.id.res);
        this.toolbar = findViewById(R.id.toolbar);
        this.FF = new FluidFlow();
		this.Tools = new Tools();
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fluid_flow_flow_rate1);
        this.initialize();
        setSupportActionBar(toolbar);
	
		this.vaz.setOnClickListener(
			new OnClickListener() {
				public void onClick(View view) {				

                    // Verificar se volume é nulo ou ponto através do método Tools
                    if (Tools.isNull(vol.getText().toString())) {
                        vol.setError(getText(R.string.null_field));
                        verifyVolume = 0;

					    // Se for ponto, pare
                    } else if (Tools.isDot(vol.getText().toString())) {
                        vol.setError(getText(R.string.dot_value));
                        verifyVolume = 0;

                        // Se não for nulo, continue
                    } else {           
                        volume = Double.valueOf(vol.getText().toString());
                        verifyVolume = 1;
                    }


                    // Verificar se delta tempo é nulo
                    if (Tools.isNull(dt.getText().toString())) {                        
                        dt.setError(getText(R.string.null_field));
                        verifyTime = 0;

					    // Se for ponto, pare
                    } else if (Tools.isDot(dt.getText().toString())) {
                        dt.setError(getText(R.string.dot_value));
                        verifyTime = 0;

					    // Se não for, comtinue
                    } else {
                        time = Double.valueOf(dt.getText().toString());
                        verifyTime = 1;
                    }

                    
                    // Se os valores VerifyVolume e time forem true, efectuar a operação
                    if (verifyVolume == 1 && verifyTime == 1) {
                        res.setText(getText(R.string.flowRatep)
                                    + " "
                                    + Tools.normalize(Tools.expNormalizer(volume))
                                    + getText(R.string.vmc)
                                    + getText(R.string.division)
                                    + Tools.normalize(Tools.expNormalizer(time))
                                    + getText(R.string.second));

                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.flowRatep)
                                    + " "
                                    + FF.fFluidFlow(volume, time)
                                    + getText(R.string.speedmcps));
                    } else {
                        return;
                    }
                }
            });
    }
}
