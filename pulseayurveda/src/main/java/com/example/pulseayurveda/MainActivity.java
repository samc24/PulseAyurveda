package com.example.pulseayurveda;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fitbit.authentication.AuthenticationHandler;
import com.fitbit.authentication.AuthenticationManager;
import com.fitbit.authentication.AuthenticationResult;


public class MainActivity extends Activity implements AuthenticationHandler {

            public void onLoginClick(View view) {
            AuthenticationManager.login(this);
        }


        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            AuthenticationManager.onActivityResult(requestCode, resultCode, data, (AuthenticationHandler) this);
        }


        public void onAuthFinished(AuthenticationResult authenticationResult) {
            if (authenticationResult.isSuccessful()) {
                //WOOT WOOT!! It worked!
            } else {
                //Uh oh... errors...
            }
        }

    public void onLogoutClick(View view) {
        AuthenticationManager.logout(this);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}
}

