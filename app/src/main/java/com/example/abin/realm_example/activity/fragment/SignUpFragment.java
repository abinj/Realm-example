package com.example.abin.realm_example.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.abin.realm_example.R;
import com.example.abin.realm_example.model.User;
import com.example.abin.realm_example.utility.BaseUtility;
import com.example.abin.realm_example.utility.DbUtility;

import roboguice.fragment.provided.RoboFragment;
import roboguice.inject.InjectView;

/**
 * Fragment class for sign up
 */
public class SignUpFragment extends RoboFragment {
    @InjectView(R.id.sign_up_btn) Button mSignUpBtn;
    @InjectView(R.id.email_txt) EditText mEmailTxt;
    @InjectView(R.id.password_txt) EditText mPasswordTxt;
    @InjectView(R.id.name_txt) EditText mNameTxt;
    private FragmentActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (FragmentActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up, container, false);
        clickListener();
        return view;
    }

    private void clickListener() {
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setEmail(mEmailTxt.getText().toString());
                BaseUtility baseUtility = new BaseUtility();
                String encryptedPassword = baseUtility.encrypt(mPasswordTxt.getText().toString());
                user.setPassword(encryptedPassword);
                user.setName(mNameTxt.getText().toString());
                DbUtility dbUtility = new DbUtility(mActivity);
                dbUtility.createUser(user);
            }
        });
    }
}
