package com.mjr.twaire.app.alleasy.activity.math.function;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.GabrielMJr.Twaire.Math.SDF;
import com.gabrielMJr.twaire.tools.Tools;

public class FSG extends BaseActivity {
    private Button calculate;
    private EditText a;
    private EditText b;
    private EditText c;
    private TextView var_a_x;
    private TextView var_b_x;
    private TextView result;
    private Button clear;

    private String ax;
    private String bx;
    private String cx;
    private SDF SDF;
    private Boolean av;
    private Boolean bv;
    private Boolean cv;
    private long value_a;
    private Long value_b;
    private Long value_c;
    private Tools Tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.calculate.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {
                    ax = a.getText().toString();
                    bx = b.getText().toString();
                    cx = c.getText().toString();

                    if (Tools.isNull(ax)) {
                        a.setError(getText(R.string.null_field));
                        av = false;
                    } else { 
						try {
                            value_a = Long.valueOf(ax);
                            av = true;
                        } catch (Exception e) {
                            a.setError(getText(R.string.invalid_value));
                            av = false;
                        }
                    }

                    if (Tools.isNull(bx)) {
                        b.setError(getText(R.string.null_field));
                        bv = false;
                    } else { try {
                            value_b = Long.valueOf(bx);
                            bv = true;
                        } catch (Exception e) {
                            b.setError(getText(R.string.invalid_value));
                            bv = false;
                        }
                    }

                    if (Tools.isNull(cx)) {
                        c.setError(getText(R.string.null_field));
                        cv = false;
                    } else { try {
                            value_c = Long.valueOf(cx);
                            cv = true;
                        } catch ( Exception e) {
                            c.setError(getText(R.string.invalid_value));			
                            cv = false;
                        }
                    }
                    
                    if (av && bv && cv) {
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
                   }
                }
            });

        this.clear.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
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
    
    @Override
    protected void initializeActivity() {
        setContentView(R.layout.fsg);
    }

    @Override
    protected void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);   
        c = findViewById(R.id.c);
        var_a_x = findViewById(R.id.var_a_x);
        var_b_x = findViewById(R.id.var_b_x);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        clear = findViewById(R.id.clear);
        SDF = new SDF();
        Tools = new Tools();
    }

    @Override
    protected void initializeAttributes() {
    }
}
