package com.mjr.twaire.app.alleasy.activity.math.combinatorial_analysis;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.GabrielMJr.Twaire.Math.Arranjo;
import com.gabrielMJr.twaire.tools.Tools;

public class Fatorial extends BaseActivity {
    private EditText n;
    private TextView fat;
    private TextView result;
    private Button clear;

    private Tools tools;
    private Arranjo arranjo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    protected void initializeActivity() {
        setContentView(R.layout.fatorial);
    }

    @Override
    protected void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        n = findViewById(R.id.n);
        fat = findViewById(R.id.fat);
        result = findViewById(R.id.result);
        clear = findViewById(R.id.clear);
    }

    @Override
    protected void initializeAttributes() {
        tools = new Tools();
        arranjo = new Arranjo();
    }
    
    @Override
    protected void setListeners() {
        fatClick();
        clearClick();
    }
    
    private void fatClick() {
        fat.setOnClickListener(
                view -> {
                    // Verifica se n é nulo
                    if (tools.isNull(n.getText().toString())) {
                        n.setError(getText(R.string.null_field));
                    } else {

                        // Verifica se o limite de n do .xml é maior que 20 ou não
                        // Se for maior, não vai calcular, pois o resultado estará incorrecto

                        if (Integer.valueOf(n.getText().toString()) > 20) {
                            n.setError(getText(R.string.big_value));

                        } else {

                            // Senão, calcule normalmente
                            // Mandar n e p para OpEngeneer.Math
                            Long res =
                                    arranjo.valueOf(
                                            Integer.valueOf(n.getText().toString()),
                                            Integer.valueOf(n.getText().toString()));

                            // Pegar a String[] result
                            result.setText("=" + String.valueOf(res));
                        }
                    }
                });
    }
    
    private void  clearClick() {
        clear.setOnClickListener(
                view -> {
                    n.setText(null);
                    result.setText(null);
                });
    }
}
