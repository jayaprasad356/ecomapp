package com.gm.blackkite.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gm.blackkite.R;
import com.gm.blackkite.activity.BulkSellerActivity;
import com.gm.blackkite.activity.MainActivity;


public class DetailsbulksellerFragment extends Fragment {
    Button btnNext;


    public DetailsbulksellerFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_detailsbulkseller, container, false);

        btnNext = root.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new DocumentuploadFragment();
                BulkSellerActivity.fm.beginTransaction().add(R.id.container, fragment).addToBackStack(null).commit();

            }
        });
        return root;
    }
}