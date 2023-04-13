package com.gabrielmjr.alleasy.activity.physic.kinematic.mru;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;

public class MRU_Speed1 extends BaseActivity {

    private TextView delta_displacement_symbol;
    private TextView delta_time_symbol;
    private TextView velocity_symbol;

    private EditText delta_displacement_value;
    private EditText delta_time_value;

    private TextView delta_displacement_unit;
    private TextView delta_time_unit;

    private TextView formula;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*speed.setOnClickListener(
         new OnClickListener() {
         @Override
         public void onClick (View view) {

         if (tools.isNull(delta_displacement.getText ().toString())) { 
         delta_displacement.setError (getText(R.string.null_field));
         verify_deltaDisplacement = false;

         } else if (tools.isDot(delta_displacement.getText().toString())) {
         delta_displacement.setError(getText(R.string.dot_value));
         verify_deltaDisplacement = false;

         } else {
         deltaDisplacement = Double.valueOf(delta_displacement.getText().toString());
         verify_deltaDisplacement = true;
         }

         if (tools.isNull(delta_time.getText ().toString())) { 
         delta_time.setError (getText(R.string.null_field));
         verify_deltaTime = false;

         } else if (tools.isDot(delta_time.getText().toString())) {
         delta_time.setError(getText(R.string.dot_value));
         verify_deltaTime = false;

         } else {
         deltaTime = Double.valueOf(delta_time.getText().toString());
         verify_deltaTime = true;
         }

         if (verify_deltaDisplacement && verify_deltaTime) {
         res.setText(getText(R.string.speedp)
         + " "
         + deltaDisplacement
         + getText(R.string.dm)
         + " / "
         + deltaTime
         + getText(R.string.second)
         + "\n"
         + getText(R.string.speedp)
         + " "
         + mru.speed1(deltaDisplacement, deltaTime)
         + getText(R.string.speedmps));

         return;
         }
         else
         {
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
         delta_displacement.setText(null);
         delta_time.setText(null);
         res.setText(null);

         return;
         }
         });*/
    }
    
    @Override
    protected void initializeActivity() {
        setContentView(R.layout.activity_physic_calculations);
    }

    @Override
    protected void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        delta_displacement_symbol = findViewById(R.id.param_0_symbol);
        delta_time_symbol = findViewById(R.id.param_1_symbol);
        velocity_symbol = findViewById(R.id.result_symbol);

        delta_displacement_value = findViewById(R.id.param_0_value);
        delta_time_value = findViewById(R.id.param_1_value);

        delta_displacement_unit = findViewById(R.id.param_0_unit);
        delta_time_unit = findViewById(R.id.param_0_unit);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);
    }

    @Override
    protected void initializeAttributes() {
        delta_displacement_symbol.setText("∆S = ");
        delta_time_symbol.setText("∆t = ");
        velocity_symbol.setText("v = ?");

        delta_displacement_unit.setText("m");
        delta_time_unit.setText("s");

        formula.setText(R.string.kinematic_mru_speed_law1_formula);

        delta_displacement_symbol.setVisibility(View.VISIBLE);
        delta_time_symbol.setVisibility(View.VISIBLE);
        velocity_symbol.setVisibility(View.VISIBLE);

        delta_displacement_value.setVisibility(View.VISIBLE);
        delta_time_value.setVisibility(View.VISIBLE);

        delta_time_unit.setVisibility(View.VISIBLE);
        delta_time_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
