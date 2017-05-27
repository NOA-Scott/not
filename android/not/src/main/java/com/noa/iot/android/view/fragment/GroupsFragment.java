package com.noa.iot.android.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noa.iot.android.R;
import com.noa.iot.android.databinding.FragmentGroupBinding;

/**
 * Created by noalabs on 2017/5/27.
 */

public class GroupsFragment extends LazyFragment {
    public static final String INTENT_INT_INDEX = "index";

    public static GroupsFragment newInstance(int tabIndex, boolean isLazyLoad) {
        Bundle args = new Bundle();
        args.putInt(INTENT_INT_INDEX, tabIndex);
        args.putBoolean(LazyFragment.INTENT_BOOLEAN_LAZYLOAD, isLazyLoad);
        GroupsFragment fragment = new GroupsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentGroupBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_group, container, false);
        return binding.getRoot();
    }


}
