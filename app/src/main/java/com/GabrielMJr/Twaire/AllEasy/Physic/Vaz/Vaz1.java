package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import com.GabrielMJr.Twaire.Physic.FluidFlow;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.tools.StringAnalyst;
import android.widget.Toast;

public class Vaz1 extends Activity {

	private static FluidFlow FF;
	private static EditText vol;
	private static EditText dt;
	private static TextView vaz;
	private static Double volume;
	private static Double time;
	private static StringAnalyst StringAnalyst;
	private static Integer verifyVolume;
	private static Integer verifyTime;
	private static TextView res;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vaz1);

		this.vol = findViewById(R.id.vol);
		this.dt = findViewById(R.id.dt);
		this.vaz = findViewById(R.id.vaz);
		this.res = findViewById(R.id.res);
		this.FF = new FluidFlow();
		this.StringAnalyst = new StringAnalyst();

		this.vaz.setOnClickListener(
			new OnClickListener() {
				public void onClick(View view) {				
                  
                    try {
                        // Verificar se volume é nulo através do método StringAnalyst
                        if (StringAnalyst.isNull(vol.getText().toString())) {

                            Toast.makeText(Vaz1.this, R.string.vol_null, Toast.LENGTH_SHORT).show();
                            verifyVolume = 0;

                            // Se não for nulo, continue
                        } else {           
                            volume = Double.valueOf(vol.getText().toString());
                            verifyVolume = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Vaz1.this, R.string.insert_volume_well, Toast.LENGTH_SHORT).show();
                        verifyVolume = 0;
                    }

                    try {
                        // Verificar se delta tempo é nulo
                        if (StringAnalyst.isNull(dt.getText().toString())) {                        
                            Toast.makeText(Vaz1.this, R.string.time_null, Toast.LENGTH_SHORT).show();
                            verifyTime = 0;

                            // Se não for, comtinue
                        } else {
                            time = Double.valueOf(dt.getText().toString());
                            verifyTime = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Vaz1.this, R.string.insert_time_well, Toast.LENGTH_SHORT).show();
                        verifyTime = 0;
                    }

                    // Se os valores VerifyVolume e time forem true, efectuar a operação
                    if (verifyVolume == 1 && verifyTime == 1) {
                        res.setText((CharSequence) "Q = "
                                         + String.valueOf(volume) 
                                         + "m³"
                                         + "/"
                                         + time
                                         + "s");

                        res.setText((CharSequence) res.getText().toString()
                                         + "\nQ = "
                                         + FF.ffluidFlow(volume, time)
                                         + "m³/s");
                    } else {
                        return;
                    }
                }
            });
    }
}
