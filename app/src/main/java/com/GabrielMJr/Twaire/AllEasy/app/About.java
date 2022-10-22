package com.GabrielMJr.Twaire.AllEasy.app;

import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.GabrielMJr.Twaire.AllEasy.R;

public class About extends MyActivity
{
    
   // About the app activity
   @Override
   protected void onCreate(Bundle savedInstabceStatus)
   {
       super.onCreate(savedInstabceStatus);
       setContentView(R.layout.about);
       
       initialize();
   }

   private void initialize()
   {
   }
    
}
