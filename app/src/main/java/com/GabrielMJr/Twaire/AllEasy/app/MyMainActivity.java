package com.GabrielMJr.Twaire.AllEasy.app;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.Settings;
import android.view.MenuItem;
import android.content.Intent;

// Extends appcompatactivity and inflate menu
public class MyMainActivity extends AppCompatActivity
    {

        @Override
        public boolean onCreateOptionsMenu(Menu menu)
            {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu, menu);
                return true;
            }

        @Override
        public boolean onOptionsItemSelected(MenuItem item)
            {
                switch (item.getItemId())
                    {
                        case R.id.settings:
                            startActivity(new Intent(getApplicationContext(), Settings.class));
                            break;
                    }
                return true;
            }
    }
