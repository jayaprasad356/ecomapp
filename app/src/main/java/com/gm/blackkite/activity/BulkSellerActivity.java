package com.gm.blackkite.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.gm.blackkite.R;
import com.gm.blackkite.adapter.TabsAdapter;
import com.gm.blackkite.fragment.DetailsbulksellerFragment;
import com.gm.blackkite.fragment.DocumentuploadFragment;
import com.gm.blackkite.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

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