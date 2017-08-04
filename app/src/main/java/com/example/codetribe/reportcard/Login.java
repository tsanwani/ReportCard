package com.example.codetribe.reportcard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

    EditText Username;
    EditText Passwod;
    TextView Warning;
    int counter = 3;
    Button Login_Button;
    TextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = (EditText) findViewById(R.id.USERNAME);
        Passwod = (EditText) findViewById(R.id.PASSWORD);
        Warning = (TextView) findViewById(R.id.Waning_text);
        btn = (TextView) findViewById(R.id.Login_text_btn);
        Warning.setVisibility(View.GONE);
        Login_Button = (Button) findViewById(R.id.Login_Btn);

    }

    public void Login(View v) {
        Intent log_pass = new Intent(this, Student_Entry.class);

        if (Username.getText().toString().equals("admin") &&
                Passwod.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Redirecting..", Toast.LENGTH_SHORT).show();
            startActivity(log_pass);
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();


            //Massage to shows How many attempt lef
            Warning.setVisibility(View.VISIBLE);
            counter--;
            Warning.setText(Integer.toString(counter));

            if (counter == 0) {
                Login_Button.setEnabled(false);
                btn.setEnabled(false);

            }
        }
    }

    public void Close(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(Login.this);
        dialog.setTitle("EXIT");
        dialog.setMessage("Are Sure You Want To Exit This Application? ");


        dialog.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        dialog.show();
    }
}


