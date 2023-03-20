package com.GabrielMJr.Twaire.AllEasy.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class SendMailActivity extends BaseActivity {

    // Attributes
    private EditText mail_message;
    private Button send_mail;
    private Intent intent;

    // This is mail of AllEasy support
    private static final String[] ALLEASY_SUPPORT_MAIL = {"alleasy@myself.com"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_mail);
        initialize();

        send_mail.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View p1) {
                    if (mail_message.getText().toString().isEmpty()) {
                        mail_message.setError(getText(R.string.null_field_mail));
                    } else {
                        sendMail(mail_message.getText().toString());
                    }
                }   

                // Send mail method
                private void sendMail(String message) {
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, ALLEASY_SUPPORT_MAIL);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "im testing");
                    intent.putExtra(Intent.EXTRA_TEXT, "im message");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }     
            });

    }

    //Initializing the activity
    private void initialize() {
        setToolBar((Toolbar)findViewById(R.id.toolbar));
        mail_message = findViewById(R.id.mail_message);
        send_mail = findViewById(R.id.send_mail);
        intent = new Intent(Intent.ACTION_SENDTO);
    }

}
