package com.GabrielMJr.Twaire.AllEasy.math;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.GabrielMJr.Twaire.Math.Arranjo;
import com.gabrielMJr.twaire.tools.Tools;

public class Arranjos extends MyActivity
{

    // Atrubutes
    private static EditText n;
    private static EditText p;
    private static TextView a;
    private static TextView result;
    private static Button clear;

    private static Arranjo Arranjo;
    private static Tools Tools;
    private static int verifyN;
    private static int verifyP;
    private static int vn;
    private static int vp;


    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        this.n = findViewById(R.id.n);
        this.p = findViewById(R.id.p);
        this.a = findViewById(R.id.a);
        this.result = findViewById(R.id.result);
        this.clear = findViewById(R.id.clear);
        this.Arranjo = new Arranjo();
        this.Tools = new Tools();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arranjos);

        this.initialize();

        this.a.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view)
                {

                    if (Tools.isNull(Arranjos.n.getText().toString()))
                    {
                        n.setError(getText(R.string.null_field));
                        Arranjos.verifyN = 0; // Retorna 0 se nulo
                    }
                    else
                    {
                        Arranjos.vn = Integer.valueOf(n.getText().toString());
                        Arranjos.verifyN = 1; // Retorna 1 se não nulo
                    }

                    if (Tools.isNull(Arranjos.p.getText().toString()))
                    {
                        p.setError(getText(R.string.null_field));
                        Arranjos.verifyP = 0;
                    }
                    else
                    {
                        Arranjos.vp = Integer.valueOf(Arranjos.p.getText().toString());
                        Arranjos.verifyP = 1;
                    }


                    if (Arranjos.verifyN == 1 && Arranjos.verifyP == 1)
                    {


                        if (Arranjos.vn < Arranjos.vp)
                        {
                            Toast.makeText(Arranjos.this, R.string.p_big_than_n, Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            // Mandar n e p para OpEngeneer e pegar a String[] result
                            Long res = Arranjo.valueOf(Arranjos.vn, Arranjos.vp);

                            if (res < 0)
                            {
                                Toast.makeText(Arranjos.this, R.string.big_values, Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                result.setText((CharSequence) "=" + String.valueOf(res));
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
                    public void onClick(View view)
                    {
                        n.setText(null);
                        p.setText(null);
                        result.setText(null);
                        
                        return;
                    }
                });
    }
}
