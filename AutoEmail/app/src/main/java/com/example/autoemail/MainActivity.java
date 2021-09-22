package com.example.autoemail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//package com.lib4.sendmail;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button send = (Button) this.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub


                new Thread(){
                    public void run(){
                        try {
                            Sender sender = new Sender(FROM_EMAIL_ID, FROM_PASSWORD);
                            sender.sendMail(SUBJECT,
                                    BODY,
                                    FROM,
                                    TO_EMAIL_ID);
                        } catch (Exception e) {
                            Log.e("SendMail", e.getMessage(), e);
                        }
                    }
                }.start();


            }
        });

    }
}
