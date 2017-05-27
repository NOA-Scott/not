package com.noa.iot.android.viewmodel.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.noa.iot.android.R;
import com.noa.iot.android.databinding.ActivityMainBinding;
import com.noa.iot.android.view.adapter.PagerAdapter;
import com.noa.iot.android.view.fragment.DevicesFragment;
import com.noa.iot.android.view.fragment.GroupsFragment;
import com.noa.iot.android.view.fragment.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noalabs on 2017/5/27.
 */

public class MainViewModel {

    private MainViewListener listener;
    private List<Fragment> fragmentList = new ArrayList<>();

    private ActivityMainBinding binding;

    private Handler handler = new Handler();

    public MainViewModel(MainViewListener listener) {
        this.listener = listener;
        fragmentList.add(DevicesFragment.newInstance(1, true));
        fragmentList.add(GroupsFragment.newInstance(2, true));
        fragmentList.add(SettingsFragment.newInstance(3, true));
    }

    public void binding(ActivityMainBinding binding, FragmentManager manager) {
        this.binding = binding;
        PagerAdapter pgAdapter = new PagerAdapter(manager, fragmentList);
        binding.viewpager.setAdapter(pgAdapter);
        binding.setHandler(handler);
        binding.viewpager.setOffscreenPageLimit(3);
        binding.viewpager.setCurrentItem(1);
    }

    public class Handler {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.settings: {
                    binding.viewpager.setCurrentItem(2);
                    break;
                }
                case R.id.groups: {
                    binding.viewpager.setCurrentItem(1);
                    break;
                }
                case R.id.devices: {
                    binding.viewpager.setCurrentItem(0);
                    break;
                }
            }
        }
    }
}
