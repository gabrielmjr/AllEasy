package com.GabrielMJr.Twaire.AllEasy.tools;

import android.app.AlertDialog;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.content.Context;
import android.content.DialogInterface;
import com.GabrielMJr.Twaire.AllEasy.app.MainActivity;
import android.graphics.drawable.Drawable;

public class DialogAlertData {
    
    private static Context context;
    
    // Construtor
    public DialogAlertData(Context context) {
        setContext(context);
    }
    
    // Dialogo de alerta
    public AlertDialog alertDialog(String title, String message, Drawable icon) {
        AlertDialog dialog = new AlertDialog.Builder(getContext())
            .setTitle(title)
            .setMessage(message)
            .setIcon(icon)
            .setCancelable(false)
            .setPositiveButton(R.string.close, new AlertDialog.OnClickListener() {
                @Override
                public void onClick(DialogInterface dia, int which) {
                    try {
                        finalize();
                    } catch (Throwable e) {}
                }
            })
            .create();
            return dialog;
    }
    
    public void setContext(Context context) {
        this.context = context;
    }
    
    public Context getContext() {
        return context;
    }
    
}
