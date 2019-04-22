package com.ferechamitbeyli.instagramparsecloseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.signedUpActivityUserNameTextId);
        password = findViewById(R.id.signedActivityPasswordTextId);

        ParseUser parseUser = ParseUser.getCurrentUser();
        if(parseUser != null) {
            Intent intent = new Intent(MainActivity.this, FeedActivity.class);
            startActivity(intent);
        }
    }

    public void signIn(View view) {
        ParseUser.logInInBackground(userName.getText().toString().toLowerCase(), password.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null) {
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Welcome " + userName.getText(),Toast.LENGTH_LONG).show();
                    //intent
                    Intent intent = new Intent(MainActivity.this, FeedActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void signUp(View view) {
        ParseUser user = new ParseUser();
        user.setUsername(userName.getText().toString().toLowerCase());
        user.setPassword(password.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null) {
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"User has been created.",Toast.LENGTH_LONG).show();
                    //intent
                    Intent intent = new Intent(MainActivity.this, FeedActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}
