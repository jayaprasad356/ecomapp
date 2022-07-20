package com.gm.blackkite.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gm.blackkite.R;


public class BulksellerApprovalFragment extends Fragment {


    public BulksellerApprovalFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_approval_bulkseller, container, false);
        return  root;
    }
}