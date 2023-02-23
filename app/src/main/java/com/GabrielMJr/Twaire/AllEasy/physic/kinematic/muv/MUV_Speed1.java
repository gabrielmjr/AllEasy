package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;

public class MUV_Speed1 extends MyActivity
{
    
    private TextView delta_time_symbol;
	private TextView acceleration_symbol;
	private TextView delta_speed_symbol;
	
	private EditText delta_time_value;
	private EditText acceleration_value;
	
	private TextView delta_time_unit;
	private TextView acceleration_unit;
	
	private TextView formula;
	private TextView result;
	
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
		initializeActivity();
        
        /*speed.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {

                    if (tools.isNull(delta_time.getText().toString()))
                    {
                        delta_time.setError(getText(R.string.null_field));
                        verify_deltaTime = false;

                    }
                    else if (tools.isDot(delta_time.getText().toString()))
                    {
                        delta_time.setError(getText(R.string.dot_value));
                        verify_deltaTime = false;

                    }
                    else
                    {
                        deltaTime = Double.valueOf(delta_time.getText().toString());
                        verify_deltaTime = true;
                    }


                    if (tools.isNull(acceleration.getText().toString()))
                    {
                        acceleration.setError(getText(R.string.null_field));
                        verify_acceleration = false;

                    }
                    else if (tools.isDot(acceleration.getText().toString()))
                    {
                        acceleration.setError(getText(R.string.dot_value));
                        verify_acceleration = false;

                    }
                    else
                    {
                        accelerationV = Double.valueOf(acceleration.getText().toString());
                        verify_acceleration = true;
                    }


                    if (verify_deltaTime && verify_acceleration)
                    {

                        res.setText(getText(R.string.dvp)
                                    + " "
                                    + delta_time.getText().toString()
                                    + getText(R.string.dm)
                                    + " "
                                    + getText(R.string.multiplication)
                                    + " "
                                    + delta_time.getText().toString()
                                    + getText(R.string.dm)

                                    + "\n"
                                    + getText(R.string.dvp)
                                    + " "
                                    + muv.speed1(deltaTime, accelerationV)
                                    + getText(R.string.speedmps));

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
                    acceleration.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });*/
    }
    
	
	private void getViews()
	{
		setToolBar((Toolbar) findViewById(R.id.toolbar));
		
		delta_time_symbol = findViewById(R.id.param_0_symbol);
		acceleration_symbol = findViewById(R.id.param_1_symbol);
		delta_speed_symbol = findViewById(R.id.result_symbol);
		
		delta_time_value = findViewById(R.id.param_0_value);
		acceleration_value = findViewById(R.id.param_1_value);
		
		delta_time_unit = findViewById(R.id.param_0_unit);
		acceleration_unit = findViewById(R.id.param_1_unit);
		
		formula = findViewById(R.id.formula);
		result = findViewById(R.id.result);
	}
	
	
	private void initializeActivity()
	{
		delta_time_symbol.setText("∆t = ");
		acceleration_symbol.setText("a = ");
		delta_speed_symbol.setText("∆v = ?");
		
		delta_time_unit.setText("s");
		acceleration_unit.setText("m/s");
		
		formula.setText(R.string.kinematic_muv_speed1_formula);
		
		delta_time_symbol.setVisibility(View.VISIBLE);
		acceleration_symbol.setVisibility(View.VISIBLE);
		delta_speed_symbol.setVisibility(View.VISIBLE);
		
		delta_time_value.setVisibility(View.VISIBLE);
		acceleration_value.setVisibility(View.VISIBLE);
		
		delta_time_unit.setVisibility(View.VISIBLE);
		acceleration_unit.setVisibility(View.VISIBLE);
		
		formula.setVisibility(View.VISIBLE);
		result.setVisibility(View.VISIBLE);
	}
}
