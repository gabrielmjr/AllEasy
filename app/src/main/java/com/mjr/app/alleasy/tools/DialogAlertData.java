package com.mjr.app.alleasy.tools;

import android.app.AlertDialog;
import com.mjr.app.alleasy.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;

public class DialogAlertData {
    
    private Context context;
    
    // Constructor
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
