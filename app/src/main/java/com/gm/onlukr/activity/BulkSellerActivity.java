package com.gm.onlukr.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.gm.onlukr.R;
import com.gm.onlukr.fragment.DetailsbulksellerFragment;
import com.gm.onlukr.fragment.DocumentuploadFragment;

public class BulkSellerActivity extends AppCompatActivity {
    public static FragmentManager fm = null;
    Fragment detailsbulksellerFragment;
    Fragment uploaddocumentsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulk_seller);
        fm = getSupportFragmentManager();
        detailsbulksellerFragment = new DetailsbulksellerFragment();
        uploaddocumentsFragment = new DocumentuploadFragment();
        fm.beginTransaction().add(R.id.container, detailsbulksellerFragment).commit();
        //fm.beginTransaction().add(R.id.container, uploaddocumentsFragment).commit();





    }
}