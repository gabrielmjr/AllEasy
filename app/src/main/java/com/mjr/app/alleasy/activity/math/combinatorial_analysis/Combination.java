package com.mjr.app.alleasy.activity.math.combinatorial_analysis;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mjr.app.alleasy.activity.BaseActivity;
import com.mjr.app.alleasy.R;
import com.gabrielMJr.twaire.tools.Tools;

public class Combination extends BaseActivity {
    private EditText n;
    private EditText p;
    private TextView c;
    private TextView result;
    private Button clear;

    private String[] res = new String[4];
    private Tools Tools;
   // private Arranjo Arranjo;
    private Boolean verifyN;
    private Boolean verifyP;
    private Boolean verifyNfat;
    private Boolean verifyPfat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeActivity() {
        setContentView(R.layout.combination);
    }

    @Override
    protected void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        n = findViewById(R.id.n);
        p = findViewById(R.id.p);
        c = findViewById(R.id.c);
        result = findViewById(R.id.result);
        clear = findViewById(R.id.clear);
    }

    @Override
    protected void initializeAttributes() {
        Tools = new Tools();
       // Arranjo = new Arranjo();
    }
    
    @Override
    protected void setListeners() {
       // cClick();
       // clearClick();
    }
    
    /*protected void cClick() {
        c.setOnClickListener(
                view -> {
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
                            Toast.makeText(
                                            getApplicationContext(),
                                            R.string.p_big_than_n,
                                            Toast.LENGTH_SHORT)
                                    .show();
                        } else {

                            // Mandar n para classe ~/.twaire.math.fatorial e pegar a String result
                      //      Long res = Arranjo.valueOf(nn, nn);
                            //String nfat = String.valueOf(res);

                            // Mandar n-p para classe ~/.twaire.math.fatorial e pegar a String
                            // result
                           // res = Arranjo.valueOf((nn - pp), (nn - pp));
                           // String nmpfat = String.valueOf(res);

                            // Mandar p para classe ~/.twaire.math.fatorial e pegar a String result
                           /* res = Arranjo.valueOf(pp, pp);
                            String pfat = String.valueOf(res);

                            // Resultado final de Combinação
                            String resfat =
                                    String.valueOf(
                                            Double.valueOf(nfat)
                                                    / (Double.valueOf(nmpfat)
                                                            * Double.valueOf(pfat)));

                            // Mandar todos os resultados para uma String[] result
                            setRes(nfat, pfat, nmpfat, resfat);

                            if (Long.valueOf(nfat) <= 0) {
                                Toast.makeText(
                                                getApplicationContext(),
                                                R.string.big_values,
                                                Toast.LENGTH_SHORT)
                                        .show();
                                verifyNfat = false;
                            } else {
                                verifyNfat = true;
                            }

                            if (Long.valueOf(pfat) <= 0) {
                                Toast.makeText(
                                                getApplicationContext(),
                                                R.string.big_values,
                                                Toast.LENGTH_SHORT)
                                        .show();
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
                });*/
        }
    
   /* private void clearClick() {
        clear.setOnClickListener(
                view -> {
                    n.setText(null);
                    p.setText(null);
                    result.setText(null);
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
    }*/

