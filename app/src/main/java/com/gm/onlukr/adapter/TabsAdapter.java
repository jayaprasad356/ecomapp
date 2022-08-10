package com.gm.onlukr.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.gm.onlukr.fragment.BulksellerApprovalFragment;
import com.gm.onlukr.fragment.DetailsbulksellerFragment;
import com.gm.onlukr.fragment.DocumentuploadFragment;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public TabsAdapter(FragmentManager fm, int NoofTabs) {
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DetailsbulksellerFragment DETAILS = new DetailsbulksellerFragment();
                return DETAILS;
            case 1:
                DocumentuploadFragment UPLOAD = new DocumentuploadFragment();
                return UPLOAD;

            case 2:
                BulksellerApprovalFragment APPROVAL = new BulksellerApprovalFragment();
                return APPROVAL;



            default:
                return null;
        }
    }

}
