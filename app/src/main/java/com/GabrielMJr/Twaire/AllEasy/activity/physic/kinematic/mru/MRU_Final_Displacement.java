package com.GabrielMJr.Twaire.AllEasy.activity.physic.kinematic.mru;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class MRU_Final_Displacement extends BaseActivity {
    private TextView initial_displacement_symbol;
    private TextView delta_displacement_symbol;
    private TextView final_displacement_symbol;

    private TextView initial_displacement_unit;
    private TextView delta_displacement_unit;

    private EditText initial_displacement_value;
    private EditText delta_displacement_value;

    private TextView formula;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
        initializeActivity();

        /*displacement.setOnClickListener(
		 new OnClickListener() {
		 @Override
		 public void onClick (View view) {

		 if (tools.isNull(initial_displacement.getText().toString())) {
		 initial_displacement.setError(getText(R.string.null_field));
		 verifyInitialDisplacement = false;

		 }
		 else if (tools.isDot(initial_displacement.getText().toString())) {
		 initial_displacement.setError(getText(R.string.dot_value));
		 verifyInitialDisplacement = false;

		 }
		 else {
		 initialDisplacement = Double.valueOf(initial_displacement.getText().toString());
		 verifyInitialDisplacement = true;
		 }                 

		 if (tools.isNull(delta_displacement.getText().toString())) {
		 delta_displacement.setError(getText(R.string.null_field));
		 verifyDeltaDisplacement = false;

		 }
		 else if (tools.isDot(delta_displacement.getText().toString())) {
		 delta_displacement.setError(getText(R.string.dot_value));
		 verifyDeltaDisplacement = false;

		 }
		 else {
		 deltaDisplacement = Double.valueOf(delta_displacement.getText().toString());
		 verifyDeltaDisplacement = true;
		 }              


		 if (verifyInitialDisplacement && verifyDeltaDisplacement) {
		 res.setText(getText(R.string.final_displacement)
		 + " = "
		 + delta_displacement.getText().toString()
		 + getText(R.string.dm)
		 + " + "
		 + initial_displacement.getText().toString()
		 + getText(R.string.dm));

		 res.setText(res.getText().toString()
		 + "\n"
		 + getText(R.string.final_displacement)      
		 + " = "
		 + mru.displacement5(initialDisplacement, deltaDisplacement)
		 + getText (R.string.dm));
		 }

		 }
		 });*/

    }


    private void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        initial_displacement_symbol = findViewById(R.id.param_0_symbol);
        delta_displacement_symbol = findViewById(R.id.param_1_symbol);
        final_displacement_symbol = findViewById(R.id.result_symbol);

        initial_displacement_value = findViewById(R.id.param_0_value);
        delta_displacement_value = findViewById(R.id.param_1_value);

        initial_displacement_unit = findViewById(R.id.param_0_unit);
        delta_displacement_unit = findViewById(R.id.param_1_unit);

        formula = findViewById(R.id.formula);
        result = findViewById(R.id.result);

        findViewById(R.id.param_2_symbol).setVisibility(View.GONE);
        findViewById(R.id.param_2_value).setVisibility(View.GONE);
        findViewById(R.id.param_2_unit).setVisibility(View.GONE);

        findViewById(R.id.param_3_symbol).setVisibility(View.GONE);
        findViewById(R.id.param_3_value).setVisibility(View.GONE);
        findViewById(R.id.param_3_unit).setVisibility(View.GONE);
    }


    private void initializeActivity() {
        initial_displacement_symbol.setText("Si = ");
        delta_displacement_symbol.setText("∆S = ");
        final_displacement_symbol.setText("S = ?");

        initial_displacement_unit.setText("m");
        delta_displacement_unit.setText("m");

        formula.setText(R.string.kinematic_mru_final_displacement_formula);

        initial_displacement_symbol.setVisibility(View.VISIBLE);
        delta_displacement_symbol.setVisibility(View.VISIBLE);
        final_displacement_symbol.setVisibility(View.VISIBLE);

        initial_displacement_value.setVisibility(View.VISIBLE);
        delta_displacement_value.setVisibility(View.VISIBLE);

        initial_displacement_unit.setVisibility(View.VISIBLE);
        delta_displacement_unit.setVisibility(View.VISIBLE);

        formula.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }
}
