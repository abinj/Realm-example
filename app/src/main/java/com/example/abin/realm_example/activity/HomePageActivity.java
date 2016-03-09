package com.example.abin.realm_example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abin.realm_example.R;
import com.example.abin.realm_example.constants.DbConstants;
import com.example.abin.realm_example.constants.GenericConstants;
import com.example.abin.realm_example.model.User;
import com.example.abin.realm_example.utility.DbUtility;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * An activity class for home page.
 */
public class HomePageActivity extends RoboActivity {
    @InjectView(R.id.name_edit) EditText mNameEditTxt;
    @InjectView(R.id.email_edit) EditText mEmailEditText;
    @InjectView(R.id.password_edit) EditText mPasswordEditText;
    @InjectView(R.id.edit_account_btn) EditText mEditAccountBtn;
    @InjectView(R.id.delete_account_btn) EditText mDeleteAccountBtn;
    private String emailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        emailId = getIntent().getStringExtra(DbConstants.EMAIL_KEY);
        fetchUserDetails();
        clickListener();
    }

    private void fetchUserDetails() {
        DbUtility dbUtility = new DbUtility(this);
        User user = dbUtility.readUser(emailId);
        if (user != null) {
            mNameEditTxt.setText(user.getName());
            mEmailEditText.setText(user.getEmail());
            mPasswordEditText.setText(user.getPassword());
        } else {
            Toast.makeText(this, GenericConstants.READ_USER_FAILED, Toast.LENGTH_SHORT).show();
        }
    }

    private void clickListener() {
        mEditAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNameEditTxt.setEnabled(true);
                mEmailEditText.setEnabled(true);
                mPasswordEditText.setEnabled(true);
            }
        });

        mDeleteAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbUtility dbUtility = new DbUtility(getApplicationContext());
                boolean isDeleted = dbUtility.deleteUser(emailId);
                if (isDeleted) {

                }
            }
        });
    }
}
