package com.gabrielmjr.alleasy.activity.physic.vaz;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;

public class FluidFlow_ActivityMain extends BaseActivity {

    private LinearLayout vaz1;
    private LinearLayout vaz2;
    private LinearLayout vaz3;
    private LinearLayout t1;
    private LinearLayout V1;
    private LinearLayout vel1;
	private LinearLayout vel2;
    private LinearLayout area1;
    private LinearLayout raio1;
    
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
