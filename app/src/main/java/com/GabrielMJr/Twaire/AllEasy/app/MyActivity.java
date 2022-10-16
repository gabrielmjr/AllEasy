package com.GabrielMJr.Twaire.AllEasy.app;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;


// Extends app compat activity and and set the back button on toolbar
public class MyActivity extends AppCompatActivity
    {
        private Toolbar setNavigationOnToolbar(Toolbar toolbar)
            {
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeButtonEnabled(true);
                toolbar.setNavigationOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View view)
                                {
                                    onBackPressed();
                                }
                        });
                return toolbar;
            }
            
        protected Toolbar setToolBar(Toolbar toolbar) {
            return setNavigationOnToolbar(toolbar);
        }
    }
