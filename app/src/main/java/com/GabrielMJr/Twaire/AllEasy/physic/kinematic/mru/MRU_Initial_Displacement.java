package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;
import android.widget.Button;

public class MRU_Initial_Displacement extends MyActivity {

    private static EditText delta_displacement;
    private static EditText final_displacement;
    private static TextView displacement;
    private static TextView res;
    private static Button clear;
    
    private static int verify_delta_displacement;
    private static int verify_final_displacement;
    private static double deltaDisplacement;
    private static double finalDisplacement;
    private static Tools tools;
    private static MRU mru;

    private void initialize () {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        delta_displacement = findViewById(R.id.delta_displacement);
        final_displacement = findViewById(R.id.final_displacement);
        displacement = findViewById(R.id.displacement);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);
        
        tools = new Tools();
        mru = new MRU();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_initial_displacement);
        initialize();
        
        displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    if (tools.isNull(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.null_field));
                        verify_delta_displacement = 0;

                    }
                    else if (tools.isDot(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.dot_value));
                        verify_delta_displacement = 0;

                    }
                    else {
                        deltaDisplacement = Double.valueOf(delta_displacement.getText().toString());
                        verify_delta_displacement = 1;
                    }

                    if (tools.isNull(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.null_field));
                        verify_final_displacement = 0;

                    }
                    else if (tools.isDot(final_displacement.getText().toString())) {
                        final_displacement.setError(getText(R.string.dot_value));
                        verify_final_displacement = 0;

                    }
                    else {
                        finalDisplacement = Double.valueOf(final_displacement.getText().toString());
                        verify_final_displacement = 1;
                    }

                    if (verify_delta_displacement == 1 && verify_final_displacement == 1) {
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
                                    + mru.initial_displacement(deltaDisplacement, finalDisplacement)
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
            });
    }

}
