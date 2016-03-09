package com.example.abin.realm_example.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.abin.realm_example.R;
import com.example.abin.realm_example.activity.fragment.SignInFragment;
import com.example.abin.realm_example.activity.fragment.SignUpFragment;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {
    @InjectView(R.id.sign_up_btn)   protected Button loginBtn;
    @InjectView(R.id.sign_in_btn)   protected Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickListener();
    }

    private void clickListener() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.fragment_container
                        , new SignInFragment()).commit();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.fragment_container
                        , new SignUpFragment()).commit();
            }
        });

    }

}
