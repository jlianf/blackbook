package com.yaydev.blackbook.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yaydev.blackbook.Configs;
import com.yaydev.blackbook.CustomPager;
import com.yaydev.blackbook.PrefManager;
import com.yaydev.blackbook.R;
import com.yaydev.blackbook.adapter.PermissionsAdapter;
import com.yaydev.blackbook.model.Board;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.scwang.wave.MultiWaveHeader;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity implements PermissionsAdapter.Listener {

    private CustomPager pager;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        Configs configs = new Configs(this);
        prefManager = new PrefManager(this);

        pager = findViewById(R.id.permissions_pager);
        PermissionsAdapter adapter = new PermissionsAdapter(getList(), this, configs);
        pager.setAdapter(adapter);

        MultiWaveHeader header = findViewById(R.id.waveHeader);
        header.setCloseColor(getResources().getColor(configs.getColor()));
        header.setStartColor(getResources().getColor(configs.getColor()));

        getWindow().setStatusBarColor(getResources().getColor(configs.getColor()));

    }

    private List<Board> getList() {
        List<Board> list = new ArrayList<>();

        list.add(new Board(R.drawable.ic_document, "Storage Permission",
                "This app needs storage permission to save data into your device",
                Manifest.permission.WRITE_EXTERNAL_STORAGE));
        list.add(new Board(R.drawable.ic_call, "Phone Permission",
                "This app needs phone permission to make and manage phone calls",
                Manifest.permission.CALL_PHONE));

        return list;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (prefManager.isFistCheck()) {
            Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onAllowTriggered(String permission) {
        prefManager.editFirstTimeCheck(true);
        Dexter.withContext(OnboardingActivity.this)
                .withPermission(permission)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        if (response.getPermissionName().equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            pager.setCurrentItem(1);
                        } else if (response.getPermissionName().equals(Manifest.permission.CALL_PHONE)) {
                            Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.getPermissionName().equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            pager.setCurrentItem(1);
                        } else if (response.getPermissionName().equals(Manifest.permission.CALL_PHONE)) {
                            Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }
}