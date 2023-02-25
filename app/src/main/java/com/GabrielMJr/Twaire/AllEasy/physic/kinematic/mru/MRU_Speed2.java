package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;

public class MRU_Speed2 extends MyActivity
{
    private TextView initial_displacement_symbol;
    private TextView final_displacement_symbol;
    private TextView initial_time_symbol;
    private TextView final_time_symbol;
    private TextView velocity_symbol;
    
    private EditText initial_displacement_value;
    private EditText final_displacement_value;
    private EditText initial_time_value;
    private EditText final_time_value;
    
    private TextView initial_displacement_unit;
    private TextView final_displacement_unit;
    private TextView initial_time_unit;
    private TextView final_time_unit;
    
    private TextView formula;
    private TextView result;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();

        /*speed.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if (tools.isNull(initial_displacement.getText().toString()))
                    {
                        initial_displacement.setError(getText(R.string.null_field));
                        verify_initialDisplacement = false;

                    }
                    else if (tools.isDot(initial_displacement.getText().toString()))
                    {
                        initial_displacement.setError(getText(R.string.dot_value));
                        verify_initialDisplacement = false;

                    }
                    else
                    {
                        initialDisplacement = Double.valueOf(initial_displacement.getText().toString());
                        verify_initialDisplacement = true;
                    }

                    if (tools.isNull(final_displacement.getText().toString()))
                    {
                        final_displacement.setError(getText(R.string.null_field));
                        verify_finalDisplacement = false;

                    }
                    else if (tools.isDot(final_displacement.getText().toString()))
                    {
                        final_displacement.setError(getText(R.string.dot_value));
                        verify_finalDisplacement = false;

                    }
                    else
                    {
                        finalDisplacement = Double.valueOf(final_displacement.getText().toString());
                        verify_finalDisplacement = true;
                    }

                    if (tools.isNull(initial_time.getText().toString()))
                    {
                        initial_time.setError(getText(R.string.null_field));
                        verify_initialTime = false;

                    }
                    else if (tools.isDot(initial_time.getText().toString()))
                    {
                        initial_time.setError(getText(R.string.dot_value));
                        verify_initialTime = false;

                    }
                    else
                    {
                        initialTime = Double.valueOf(initial_time.getText().toString());
                        verify_initialTime = true;
                    }

                    if (tools.isNull(final_time.getText().toString()))
                    {
                        final_time.setError(getText(R.string.null_field));
                        verify_finalTime = false;

                    }
                    else if (tools.isDot(final_time.getText().toString()))
                    {
                        final_time.setError(getText(R.string.dot_value));
                        verify_finalTime = false;

                    }
                    else
                    {
                        finalTime = Double.valueOf(final_time.getText().toString());
                        verify_finalTime = true;
                    }

                    if (verify_initialDisplacement
                        &&
                        verify_finalDisplacement
                        &&
                        verify_initialTime
                        &&
                        verify_finalTime)
                    {

                        res.setText(mru.speed2(initialDisplacement,
                                               finalDisplacement,
                                               initialTime, finalTime,
                                               physic.GET_STEP));

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
                    initial_displacement.setText(null);
                    final_displacement.setText(null);
                    res.setText(null);

                    return;
                }
            });*/
    }
    
    
    private void getViews()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        initial_displacement_symbol = findViewById(R.id.param_0_symbol);
        final_displacement_symbol = findViewById(R.id.param_1_symbol);
        initial_time_symbol = findViewById(R.id.param_2_symbol);
        final_time_symbol = findViewById(R.id.param_3_symbol);
        velocity_symbol = findViewById(R.id.result_symbol);
        
        initial_displacement_value = findViewById(R.id.param_0_value);
        final_displacement_value = findViewById(R.id.param_1_value);
        initial_time_value = findViewById(R.id.param_2_value);
        final_time_value = findViewById(R.id.param_3_value);
        
        initial_displacement_unit = findViewById(R.id.param_0_unit);
        final_displacement_unit = findViewById(R.id.param_1_unit);
        initial_time_unit = findViewById(R.id.param_2_unit);
        final_time_unit = findViewById(R.id.param_3_unit);
        
        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }
    
    
    private void initializeActivity()
    {
        initial_displacement_symbol.setText("Si = ");
        final_displacement_symbol.setText("S = ");
        initial_time_symbol.setText("ti = ");
        final_time_symbol.setText("t = ");
        velocity_symbol.setText("v = ?");
        
        initial_displacement_unit.setText("m");
        final_displacement_unit.setText("m");
        initial_time_unit.setText("s");
        final_time_unit.setText("s");
        
        formula.setText(R.string.kinematic_mru_speed_law2_formula);
        
        initial_displacement_symbol.setVisibility(View.VISIBLE);
        final_displacement_symbol.setVisibility(View.VISIBLE);
        initial_time_symbol.setVisibility(View.VISIBLE);
        final_time_symbol.setVisibility(View.VISIBLE);
        velocity_symbol.setVisibility(View.VISIBLE);
        
        initial_displacement_value.setVisibility(View.VISIBLE);
        final_displacement_value.setVisibility(View.VISIBLE);
        initial_time_value.setVisibility(View.VISIBLE);
        final_time_value.setVisibility(View.VISIBLE);
        
        initial_time_unit.setVisibility(View.VISIBLE);
        final_displacement_unit.setVisibility(View.VISIBLE);
        initial_time_unit.setVisibility(View.VISIBLE);
        final_time_unit.setVisibility(View.VISIBLE);
        
        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
