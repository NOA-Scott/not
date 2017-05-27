package com.noa.iot.android.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noa.iot.android.R;
import com.noa.iot.android.databinding.FragmentDevicesBinding;

/**
 * Created by noalabs on 2017/5/27.
 */

public class DevicesFragment extends LazyFragment {

    public static final String INTENT_INT_INDEX = "index";

    public static DevicesFragment newInstance(int tabIndex, boolean isLazyLoad) {
        Bundle args = new Bundle();
        args.putInt(INTENT_INT_INDEX, tabIndex);
        args.putBoolean(LazyFragment.INTENT_BOOLEAN_LAZYLOAD, isLazyLoad);
        DevicesFragment fragment = new DevicesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentDevicesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_devices, container, false);
        return binding.getRoot();
    }
}
