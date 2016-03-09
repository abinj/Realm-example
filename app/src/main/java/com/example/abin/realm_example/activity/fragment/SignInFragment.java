package com.example.abin.realm_example.activity.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abin.realm_example.R;

import roboguice.fragment.provided.RoboFragment;

/**
 * Fragment class for sign in
 */
public class SignInFragment extends RoboFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_in, container, false);
        return view;
    }
}
