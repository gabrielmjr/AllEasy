package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.gabrielMJr.twaire.physic.MRU;
import com.gabrielMJr.twaire.tools.Tools;

public class MRU_Displacement1 extends MyActivity {

    private static EditText sf;
    private static EditText si;
    private static TextView displacement;
    private static TextView res;
    private static Button clear;
    
    private static double initialDisplacement;
    private static double finalDisplacement;
    private static Boolean verify_ID;
    private static Boolean verify_FD;
    private static Tools tools;
    private static MRU mru;

    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        si = findViewById(R.id.initial_displacement);
        sf = findViewById(R.id.final_displacement);
        displacement = findViewById(R.id.displacement);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);
        tools = new Tools();
        mru = new MRU();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_displacement1);
        this.initialize();
        
        displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (tools.isNull(si.getText().toString())) {
                        si.setError(getText(R.string.null_field));
                        verify_ID = false;
                    } else if (tools.isDot(si.getText().toString())) {
                        si.setError(getText(R.string.dot_value));
                        verify_ID = false;
                    } else {
                        initialDisplacement = Double.valueOf(si.getText().toString());
                        verify_ID = true;
                    }


                    if (tools.isNull(sf.getText().toString())) {
                        sf.setError(getText(R.string.null_field));
                        verify_FD = false;
                    } else if (tools.isDot(sf.getText().toString())) {
                        sf.setError(getText(R.string.dot_value));
                        verify_FD = false;
                    } else {
                        finalDisplacement = Double.valueOf(sf.getText().toString());
                        verify_FD = true;
                    }


                    if (verify_ID && verify_FD) {

                        res.setText(getText(R.string.dsp)
                                    + " "
                                    + sf.getText().toString()
                                    + getText(R.string.dm)
                                    + " - "
                                    + si.getText().toString()
                                    + getText(R.string.dm)
                                    
                                    + "\n"
                                    + getText(R.string.dsp)
                                    + " "
                                    + mru.fVDisplacement(initialDisplacement, finalDisplacement)
                                    + getText(R.string.dm));
                                    
                                    return;

                    }
                    else
                    {
                        return;
                    }
                }
            });
            
        clear.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    si.setText(null);
                    sf.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }

}
