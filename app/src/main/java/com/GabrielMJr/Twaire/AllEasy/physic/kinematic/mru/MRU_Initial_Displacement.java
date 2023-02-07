package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;

public class MRU_Initial_Displacement extends MyActivity 
{
    private TextView initial_displacement_symbol;
    private TextView delta_displacement_symbol;
    private TextView final_displacement_symbol;
    
    private EditText delta_displacement_value;
    private EditText final_displacement_value;
   
    private TextView delta_displacement_unit;
    private TextView final_displacement_unit;
    
    private TextView formula;
    private TextView result;
    

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();
        
        /*displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    if (tools.isNull(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.null_field));
                        verify_delta_displacement = false;

                    }
                    else if (tools.isDot(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.dot_value));
                        verify_delta_displacement = false;

                    }
                    else {
                        deltaDisplacement = Double.valueOf(delta_displacement.getText().toString());
                        verify_delta_displacement = true;
                    }

                    if (tools.isNull(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.null_field));
                        verify_final_displacement = false;

                    }
                    else if (tools.isDot(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.dot_value));
                        verify_final_displacement = false;

                    }
                    else {
                        finalDisplacement = Double.valueOf(final_displacement.getText().toString());
                        verify_final_displacement = true;
                    }

                    if (verify_delta_displacement && verify_final_displacement) {
                        res.setText(getText(R.string.initial_displacement)
                                    + " = "
                                    + finalDisplacement
                                    + getText(R.string.dm)
                                    + " - "
                                    + deltaDisplacement
                                    + getText(R.string.dm)
                                    + "\n"
                                    + getText(R.string.initial_displacement)
                                    + " = "
                                    + mru.displacement4(deltaDisplacement, finalDisplacement)
                                    + getText(R.string.dm));
                                    
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
                    delta_displacement.setText(null);
                    final_displacement.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });*/
    }
    
    
    private void getViews()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        initial_displacement_symbol = findViewById(R.id.result_symbol);
        delta_displacement_symbol = findViewById(R.id.param_0_symbol);
        final_displacement_symbol = findViewById(R.id.param_1_symbol);
        
        delta_displacement_value = findViewById(R.id.param_0_value);
        final_displacement_value = findViewById(R.id.param_1_value);
        
        delta_displacement_unit = findViewById(R.id.param_0_unit);
        final_displacement_unit = findViewById(R.id.param_1_unit);
       
        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
        
        findViewById(R.id.param_2_symbol).setVisibility(View.GONE);
        findViewById(R.id.param_2_value).setVisibility(View.GONE);
        findViewById(R.id.param_2_unit).setVisibility(View.GONE);

        findViewById(R.id.param_3_symbol).setVisibility(View.GONE);
        findViewById(R.id.param_3_value).setVisibility(View.GONE);
        findViewById(R.id.param_3_unit).setVisibility(View.GONE);
    }
    
   private void initializeActivity()
   {
       initial_displacement_symbol.setText("Si = ?");
       delta_displacement_symbol.setText("∆S = ");
       final_displacement_symbol.setText("S = ");
       
       delta_displacement_unit.setText("m");
       final_displacement_unit.setText("m");
       
       formula.setText(R.string.kinematic_mru_initial_displacement_formula);
   }
}
