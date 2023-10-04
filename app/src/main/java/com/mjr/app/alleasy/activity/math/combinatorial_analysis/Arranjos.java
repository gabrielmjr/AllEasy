package com.mjr.app.alleasy.activity.math.combinatorial_analysis;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mjr.app.alleasy.activity.BaseActivity;
import com.mjr.app.alleasy.R;
import com.gabrielMJr.twaire.tools.Tools;

public class Arranjos extends BaseActivity {
    private EditText n;
    private EditText p;
    private TextView a;
    private TextView result;
    private Button clear;

    //private Arranjo Arranjo;
    private Tools Tools;
    private Boolean verifyN;
    private Boolean verifyP;
    private int vn;
    private int vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    protected void initializeActivity() {
        setContentView(R.layout.arranjos);
    }

    @Override
    protected void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        n = findViewById(R.id.n);
        p = findViewById(R.id.p);
        a = findViewById(R.id.a);
        result = findViewById(R.id.result);
        clear = findViewById(R.id.clear);
      /*  Arranjo = new Arranjo();*/
    }

    @Override
    protected void initializeAttributes() {
        Tools = new Tools();
        //Arranjo = new Arranjo();
        aClick();
        clearClick();
    }
    
    private void aClick() {
        /*a.setOnClickListener(
                view -> {
                    if (Tools.isNull(n.getText().toString())) {
                        n.setError(getText(R.string.null_field));
                        verifyN = false; // Retorna 0 se nulo
                    } else {
                        vn = Integer.valueOf(n.getText().toString());
                        verifyN = true; // Retorna 1 se não nulo
                    }

                    if (Tools.isNull(p.getText().toString())) {
                        p.setError(getText(R.string.null_field));
                        verifyP = false;
                    } else {
                        vp = Integer.valueOf(p.getText().toString());
                        verifyP = true;
                    }

                    if (verifyN && verifyP) {

                        if (vn < vp) {
                            Toast.makeText(
                                            getApplicationContext(),
                                            R.string.p_big_than_n,
                                            Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            // Mandar n e p para OpEngeneer e pegar a String[] result
                            Long res = Arranjo.valueOf(vn, vp);

                            if (res < 0) {
                                Toast.makeText(
                                                getApplicationContext(),
                                                R.string.big_values,
                                                Toast.LENGTH_SHORT)
                                        .show();
                            } else {
                                result.setText("=" + res);
                            }
                        }
                    }
                });*/
    }
    
    private void clearClick() {
        clear.setOnClickListener(
                view -> {
                    n.setText(null);
                    p.setText(null);
                    result.setText(null);
                });
    }
}
