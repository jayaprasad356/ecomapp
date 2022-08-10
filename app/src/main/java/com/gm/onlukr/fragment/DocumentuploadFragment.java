package com.gm.onlukr.fragment;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.canhub.cropper.CropImage;
import com.canhub.cropper.CropImageView;
import com.gm.onlukr.R;
import com.gm.onlukr.activity.BulkSellerActivity;

public class DocumentuploadFragment extends Fragment {
    RelativeLayout uploadpancard,uploadaadhaar,uploadtmr,uploadgumas;
    ImageView panicon;
    ImageView aadhaaricon;
    ImageView tmricon;
    ImageView gumanuicon;
    Activity activity;
    public final int reqWritePermission = 2;
    public static final int SELECT_FILE = 110;
    static String FileCategory = "";
    Uri imageUri;
    String filePathPan = null;
    String filePathAadhaar = null;
    String filePathTmr = null;
    String filePathGumanu = null;
    Button btnNext;
    public DocumentuploadFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_documentupload, container, false);
        activity = getActivity();

        uploadpancard = root.findViewById(R.id.uploadpancard);
        uploadaadhaar = root.findViewById(R.id.uploadaadhaar);
        uploadtmr = root.findViewById(R.id.uploadtmr);
        uploadgumas = root.findViewById(R.id.uploadgumas);
        panicon = root.findViewById(R.id.panicon);
        aadhaaricon = root.findViewById(R.id.aadhaaricon);
        tmricon = root.findViewById(R.id.tmricon);
        gumanuicon = root.findViewById(R.id.gumanuicon);
        btnNext = root.findViewById(R.id.btnNext);

        
        uploadpancard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectPancardUpload();
                
            }
        });
        uploadaadhaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectAadhaarUpload();

            }
        });
        uploadtmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectTmrUpload();


            }
        });
        uploadgumas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectGumanuUpload();

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (filePathPan != null && filePathAadhaar != null && filePathGumanu != null && filePathTmr != null){
                    Fragment fragment = new BulksellerApprovalFragment();
                    BulkSellerActivity.fm.beginTransaction().add(R.id.container, fragment).addToBackStack(null).commit();
                }
                else {
                    Toast.makeText(activity, "Please Upload All File", Toast.LENGTH_SHORT).show();
                }
            }
        });




        return root;
    }

    private void SelectGumanuUpload() {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, reqWritePermission);
        } else if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, reqWritePermission);
        } else {
            selectGumanuDialog();
        }
    }

    private void SelectTmrUpload() {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, reqWritePermission);
        } else if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, reqWritePermission);
        } else {
            selectTmrDialog();
        }
    }

    private void selectTmrDialog()
    {
        FileCategory = "tmr";
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, SELECT_FILE);
    }
    private void selectGumanuDialog()
    {
        FileCategory = "gumanu";
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, SELECT_FILE);
    }

    private void SelectAadhaarUpload()
    {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, reqWritePermission);
        } else if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, reqWritePermission);
        } else {
            selectAadhaarDialog();
        }
    }

    private void selectAadhaarDialog()
    {
        FileCategory = "aadhaar";
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, SELECT_FILE);
    }

    private void SelectPancardUpload() {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, reqWritePermission);
        } else if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, reqWritePermission);
        } else {
            selectPanDialog();
        }
    }
    public void selectPanDialog() {
        FileCategory = "pancard";
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, SELECT_FILE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_FILE) {
                imageUri = data.getData();
                CropImage.activity(imageUri)
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setOutputCompressQuality(90)
                        .setRequestedSize(300, 300)
                        .setOutputCompressFormat(Bitmap.CompressFormat.JPEG)
                        .setAspectRatio(1, 1)
                        .start(getContext(), this);
            } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                assert result != null;
                if (FileCategory.equals("pancard")){
                    filePathPan = result.getUriFilePath(activity, true);
                    panicon.setImageResource(R.drawable.ic_baseline_check_circle_outline_24);
                }
                else if (FileCategory.equals("aadhaar")){
                    filePathAadhaar = result.getUriFilePath(activity, true);
                    aadhaaricon.setImageResource(R.drawable.ic_baseline_check_circle_outline_24);
                }
                else if (FileCategory.equals("tmr")){
                    filePathTmr = result.getUriFilePath(activity, true);
                    tmricon.setImageResource(R.drawable.ic_baseline_check_circle_outline_24);
                }
                else if (FileCategory.equals("gumanu")){
                    filePathGumanu = result.getUriFilePath(activity, true);
                    gumanuicon.setImageResource(R.drawable.ic_baseline_check_circle_outline_24);
                }


            }
        }
    }


}