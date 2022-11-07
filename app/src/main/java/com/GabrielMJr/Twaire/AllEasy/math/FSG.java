package com.GabrielMJr.Twaire.AllEasy.math;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.Math.SDF;
import com.gabrielMJr.twaire.tools.Tools;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.support.v7.widget.Toolbar;

public class FSG extends MyActivity {
    // Atrubutos
    private static Button calculate;
    private static EditText a;
    private static EditText b;
    private static EditText c;
    private static TextView var_a_x;
    private static TextView var_b_x;
    private static TextView result;
    private static Button clear;
      
    private static String ax;
    private static String bx;
    private static String cx;
    private static SDF SDF;
    private static int av;
    private static int bv;
    private static int cv;
    private static long value_a;
    private static Long value_b;
    private static Long value_c;
    private static Tools Tools;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById (R.id.toolbar));
        
        this.a = findViewById(R.id.a);
        this.b = findViewById(R.id.b);   
        this.c = findViewById(R.id.c);
        this.var_a_x = findViewById(R.id.var_a_x);
        this.var_b_x = findViewById(R.id.var_b_x);
        this.calculate = findViewById(R.id.calculate);
        this.result = findViewById(R.id.result);
        this.clear = findViewById(R.id.clear);
        this.SDF = new SDF();
        this.Tools = new Tools();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fsg);
        
        initialize();
        
        // Onclick do botão "determinar"
        this.calculate.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    // Armazenar valores de a, b e c em suas variavéis+"x"
                    ax = a.getText().toString();
                    bx = b.getText().toString();
                    cx = c.getText().toString();

                    // Verificar se valor de <a> é nulo, inválido ou válido
                    if (Tools.isNull(ax)) {
                        a.setError(getText(R.string.null_field));
                        av = 0;
                    } else { try {
                            value_a = Long.valueOf(ax);
                            av = 1;
                        } catch (Exception e) {
                            a.setError(getText(R.string.invalid_value));
                            av = 0;
                        }
                    }

                    // Verificar se valor de <b> é nulo, invàlido ou válido
                    if (Tools.isNull(bx)) {
                        b.setError(getText(R.string.null_field));
                        bv = 0;
                    } else { try {
                            value_b = Long.valueOf(bx);
                            bv = 1;
                        } catch (Exception e) {
                            b.setError(getText(R.string.invalid_value));
                            bv = 0;
                        }
                    }

                    // Verificar se valor de <c> é nulo, inválido ou válido
                    if (Tools.isNull(cx)) {
                        c.setError(getText(R.string.null_field));
                        cv = 0;
                    } else { try {
                            value_c = Long.valueOf(cx);
                            cv = 1;
                        } catch ( Exception e) {
                            c.setError(getText(R.string.invalid_value));			
                            cv = 0;
                        }
                    }

                    // Se os valores forem inseridos correctamente, prossiga normalmente
                    if ((av == 1) && (bv == 1) && (cv == 1)) {
                        if (value_b >= 0) {
                            var_a_x.setText("");
                            var_a_x.setText(getText(R.string.ax)
                                            + " +");
                        } else {
                            var_a_x.setText("");
                            var_a_x.setText(R.string.ax);
                        }

                        if (value_c >= 0) {
                            var_b_x.setText("");
                            var_b_x.setText(getText(R.string.bx)
                                            + " +");
                        } else {
                            var_b_x.setText("");
                            var_b_x.setText(R.string.bx);
                        }

                        SDF.setABC(value_a, value_b, value_c);
                        result.setText((CharSequence) SDF.getStepDelta()[0]
                                       + "\n" + SDF.getStepDelta()[1]
                                       + "\n" + SDF.getStepDelta()[2]
                                       + "\n" + SDF.getStepDelta()[3]
                                       + "\n" + SDF.getStepDelta()[4]
                                       + "\n\n"
                                       + getText(R.string.x1p)
                                       + " "
                                       + SDF.getX1()
                                       + "     "
                                       + getText(R.string.x2p)
                                       + " "
                                       + SDF.getX2()
                                       + "\n\n"
                                       + getText(R.string.dfp)
                                       + " "
                                       + SDF.getDominio()
                                       + "     "
                                       + getText(R.string.cdfp)
                                       + SDF.getContraDominio()
                                       + "\n\n"
                                       + getText(R.string.xvp)
                                       + " "
                                       + SDF.getXv()
                                       + "     "
                                       + getText(R.string.yvp)
                                       + " " 
                                       + SDF.getYv()
                                       + "\n\n"
                                       + getText(R.string.ooig_fsg)
                                       + SDF.getOrdenadaNaOrigem()
                                       + "\nEquação do eixo de simetria = "
                                       + SDF.getEES()
                                       + "\n\nConcavidade virada para"
                                       + SDF.getConcavidade());
                                       
                                       return;

                        // Senão, retorna um vazio
                    } else {
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
                    a.setText(null);
                    b.setText(null);
                    c.setText(null);
                    var_a_x.setText(null);
                    var_b_x.setText(null);
                    result.setText(null);
                    
                    return;
                }
            });
    }
}
