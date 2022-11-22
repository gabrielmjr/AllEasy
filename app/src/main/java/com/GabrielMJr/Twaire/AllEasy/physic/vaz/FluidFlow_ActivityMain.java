package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.FlowRate1;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.FlowRate2;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.FlowRate3;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.Time1;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.Volume1;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.Speed1;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.Speed2;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.Area1;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.Ray1;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.support.v7.widget.Toolbar;

public class FluidFlow_ActivityMain extends MyActivity {

    private static LinearLayout vaz1;
    private static LinearLayout vaz2;
    private static LinearLayout vaz3;
    private static LinearLayout t1;
    private static LinearLayout V1;
    private static LinearLayout vel1;
	private static LinearLayout vel2;
    private static LinearLayout area1;
    private static LinearLayout raio1;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        this.vaz1 = findViewById(R.id.v1);
        this.vaz2 = findViewById(R.id.v2);
        this.vaz3 = findViewById(R.id.v3);
        this.t1 = findViewById(R.id.t1);
        this.V1 = findViewById(R.id.V1);
        this.vel1 = findViewById(R.id.vel1);
        this.vel2 = findViewById(R.id.vel2);
        this.area1 = findViewById(R.id.area);
        this.raio1 = findViewById(R.id.raio1); 
    }
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluid_flow_main);
        this.initialize();
        
        this.vaz1.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), FlowRate1.class));
                }});

        this.vaz2.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), FlowRate2.class));
                }
            });

        this.vaz3.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), FlowRate3.class));
                }
            });

        this.t1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), Time1.class));
                }
            });

        this.V1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), Volume1.class));
                }
            });

        this.vel1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), Speed1.class));
                }
            });
			
		this.vel2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(getApplicationContext(), Speed2.class));
			}
		});
		
        this.area1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), Area1.class));
                }
            });

        this.raio1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), Ray1.class));
                }
            });
    }
}
