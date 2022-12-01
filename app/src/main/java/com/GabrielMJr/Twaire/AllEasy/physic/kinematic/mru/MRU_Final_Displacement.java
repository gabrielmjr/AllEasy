package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;
import android.view.View.OnClickListener;
import android.view.View;

public class MRU_Final_Displacement extends MyActivity {

    private EditText initial_displacement;
    private EditText delta_displacement;
    private TextView displacement;
    private TextView res;
    
    private double initialDisplacement;
    private double deltaDisplacement;
    private Boolean verifyInitialDisplacement;
    private Boolean verifyDeltaDisplacement;
    private Tools tools;
    private MRU mru;

    private void initialize () {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.initial_displacement = findViewById(R.id.initial_displacement);
        this.delta_displacement = findViewById(R.id.delta_displacement);
        this.displacement = findViewById(R.id.displacement);
        this.res = findViewById(R.id.res);
        
        this.tools = new Tools();
        this.mru = new MRU();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_final_displacement);
        initialize();
        
        displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {

                    if (tools.isNull(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.null_field));
                        verifyInitialDisplacement = false;

                    }
                    else if (tools.isDot(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.dot_value));
                        verifyInitialDisplacement = false;

                    }
                    else {
                        initialDisplacement = Double.valueOf(initial_displacement.getText().toString());
                        verifyInitialDisplacement = true;
                    }                 

                    if (tools.isNull(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.null_field));
                        verifyDeltaDisplacement = false;

                    }
                    else if (tools.isDot(delta_displacement.getText().toString())) {
                        delta_displacement.setError(getText(R.string.dot_value));
                        verifyDeltaDisplacement = false;

                    }
                    else {
                        deltaDisplacement = Double.valueOf(delta_displacement.getText().toString());
                        verifyDeltaDisplacement = true;
                    }              


                    if (verifyInitialDisplacement && verifyDeltaDisplacement) {
                        res.setText(getText(R.string.final_displacement)
                                    + " = "
                                    + delta_displacement.getText().toString()
                                    + getText(R.string.dm)
                                    + " + "
                                    + initial_displacement.getText().toString()
                                    + getText(R.string.dm));

                        res.setText(res.getText().toString()
                                    + "\n"
                                    + getText(R.string.final_displacement)      
                                    + " = "
                                    + mru.final_displacement(deltaDisplacement, initialDisplacement)
                                    + getText (R.string.dm));
                    }

                }
            });

    }

}
