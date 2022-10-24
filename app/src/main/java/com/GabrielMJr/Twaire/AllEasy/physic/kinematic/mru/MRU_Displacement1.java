package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;
import android.support.v7.widget.Toolbar;

public class MRU_Displacement1 extends MyActivity {

    private static EditText sf;
    private static EditText si;
    private static TextView displacement;
    private static TextView res;
    
    private static double initialDisplacement;
    private static double finalDisplacement;
    private static int verify_ID;
    private static int verify_FD;
    private static Tools tools;
    private static MRU mru;

    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        si = findViewById(R.id.initial_displacement);
        sf = findViewById(R.id.final_displacement);
        displacement = findViewById(R.id.displacement);
        res = findViewById(R.id.res);
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
                        verify_ID = 0;
                    } else if (tools.isDot(si.getText().toString())) {
                        si.setError(getText(R.string.dot_value));
                        verify_ID = 0;
                    } else {
                        initialDisplacement = Double.valueOf(si.getText().toString());
                        verify_ID = 1;
                    }


                    if (tools.isNull(sf.getText().toString())) {
                        sf.setError(getText(R.string.null_field));
                        verify_FD = 0;
                    } else if (tools.isDot(sf.getText().toString())) {
                        sf.setError(getText(R.string.dot_value));
                        verify_FD = 0;
                    } else {
                        finalDisplacement = Double.valueOf(sf.getText().toString());
                        verify_FD = 1;
                    }


                    if (verify_ID == 1 && verify_FD == 1) {

                        res.setText(getText(R.string.dsp)
                                    + " "
                                    + tools.normalize(tools.expNormalizer(Double.valueOf(sf.getText().toString())))
                                    + getText(R.string.dm)
                                    + " - "
                                    + tools.normalize(tools.expNormalizer(Double.valueOf(si.getText().toString())))
                                    + getText(R.string.dm)
                                    
                                    + "\n"
                                    + getText(R.string.dsp)
                                    + " "
                                    + mru.fVDisplacement(initialDisplacement, finalDisplacement)
                                    + getText(R.string.dm));

                    } else {
                        return;
                    }
                }
            });
    }

}
