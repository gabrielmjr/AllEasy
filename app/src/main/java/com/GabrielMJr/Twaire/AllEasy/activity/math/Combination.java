package com.GabrielMJr.Twaire.AllEasy.activity.math;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;
import com.GabrielMJr.Twaire.Math.Arranjo;
import com.gabrielMJr.twaire.tools.Tools;

public class Combination extends BaseActivity {

    // Atributes
    private EditText n;
    private EditText p;
    private TextView c;
    private TextView result;
    private Button clear;

    private String[] res = new String[4];
    private Tools Tools;
    private Arranjo Arranjo;
    private Boolean verifyN;
    private Boolean verifyP;
    private Boolean verifyNfat;
    private Boolean verifyPfat;

    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        this.n = findViewById(R.id.n);
        this.p = findViewById(R.id.p);
        this.c = findViewById(R.id.c);
        this.result = findViewById(R.id.result);
        this.clear = findViewById(R.id.clear);
        this.Tools = new Tools();
        this.Arranjo = new Arranjo();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combination);

        this.initialize();

        this.c.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    if (Tools.isNull(n.getText().toString())) {
                        n.setError(getText(R.string.null_field));
                        verifyN = false;
                    } else {
                        verifyN = true;
                    }

                    if (Tools.isNull(p.getText().toString())) {
                        p.setError(getText(R.string.null_field));
                        verifyP = false;
                    } else {
                        verifyP = true;
                    }

                    if (verifyN && verifyP) {

                        // Valores de n e p do .xml
                        Integer nn = Integer.valueOf(n.getText().toString());
                        Integer pp = Integer.valueOf(p.getText().toString());

                        if (pp > nn) {
                            Toast.makeText(getApplicationContext(), R.string.p_big_than_n, Toast.LENGTH_SHORT).show();
                        } else {

                            // Mandar n para classe ~/.twaire.math.fatorial e pegar a String result
                            Long res = Arranjo.valueOf(nn, nn);
                            String nfat = String.valueOf(res);

                            // Mandar n-p para classe ~/.twaire.math.fatorial e pegar a String result
                            res = Arranjo.valueOf((nn - pp), (nn - pp));
                            String nmpfat = String.valueOf(res);

                            // Mandar p para classe ~/.twaire.math.fatorial e pegar a String result
                            res = Arranjo.valueOf(pp, pp);
                            String pfat = String.valueOf(res);

                            // Resultado final de Combinação
                            String resfat = String.valueOf(Double.valueOf(nfat) / (Double.valueOf(nmpfat) * Double.valueOf(pfat)));

                            // Mandar todos os resultados para uma String[] result
                            setRes(nfat, pfat, nmpfat, resfat);

                            if (Long.valueOf(nfat) <= 0) {
                                Toast.makeText(getApplicationContext(), R.string.big_values, Toast.LENGTH_SHORT).show();
                                verifyNfat = false;
                            } else {
                                verifyNfat = true;
                            }

                            if (Long.valueOf(pfat) <= 0) {
                                Toast.makeText(getApplicationContext(), R.string.big_values, Toast.LENGTH_SHORT).show();
                                verifyPfat = false;
                            } else {
                                verifyPfat = true;
                            }

                            if (verifyNfat && verifyPfat) {  
                                setRes(nfat, pfat, nmpfat, resfat);    
                                result.setText(
                                    getText(R.string.nfp)
                                    + " "
                                    + String.valueOf(getRes()[0])
                                    + "\n"
                                    + getText(R.string.pfp)
                                    + " "
                                    + String.valueOf(getRes()[1])
                                    + "\n"
                                    + getText(R.string.nmpfp)
                                    + " "
                                    + String.valueOf(getRes()[2])
                                    + "\n"
                                    + getText(R.string.resultp)
                                    + " "
                                    + String.valueOf(getRes()[3]));

                            }

                        }    
                    }
                    return;
                }
            });

        this.clear.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    n.setText(null);
                    p.setText(null);
                    result.setText(null);

                    return;
                }
            });
    }


    // Setters e getters
    private void setRes(String nfat, String pfat, String nmpfat, String resfat) {
        res[0] = nfat;
        res[1] = pfat;
        res[2] = nmpfat;
        res[3] = resfat;

        return;
    }

    private String[] getRes() {
        return res;
    }
}