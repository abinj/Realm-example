package com.example.abin.realm_example.activity.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abin.realm_example.R;
import com.example.abin.realm_example.activity.HomePageActivity;
import com.example.abin.realm_example.constants.GenericConstants;
import com.example.abin.realm_example.utility.DbUtility;

import roboguice.fragment.provided.RoboFragment;
import roboguice.inject.InjectView;

/**
 * Fragment class for sign in
 */
public class SignInFragment extends RoboFragment {
    @InjectView(R.id.email_txt) EditText mEmailTxt;
    @InjectView(R.id.password_txt) EditText mPasswordTxt;
    @InjectView(R.id.sign_in_btn) Button mSignInBtn;
    private FragmentActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (FragmentActivity)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_in, container, false);
        clickListener();
        return view;
    }

    private void clickListener() {
        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String validationResponse = validateFields();
                if(validationResponse.equals(GenericConstants.SUCCESS)) {
                    Intent intent = new Intent(mActivity, HomePageActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(mActivity, validationResponse, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String validateFields() {
        Editable email = mEmailTxt.getText();
        Editable password = mPasswordTxt.getText();
        DbUtility dbUtility = new DbUtility(mActivity);

        if (email == null || email.toString().trim().length() == 0) {
            return GenericConstants.NULL_FIELDS;
        } else if(password == null || password.toString().trim().length() == 0) {
            return GenericConstants.NULL_FIELDS;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()) {
            return GenericConstants.INCORRECT_EMAIL;
        } else if (!dbUtility.isUserExist(email.toString())) {
            return GenericConstants.USER_NOT_EXIST;
        } else {
            return GenericConstants.SUCCESS;
        }
    }
}
