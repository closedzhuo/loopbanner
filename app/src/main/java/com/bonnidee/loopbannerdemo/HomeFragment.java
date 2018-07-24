package com.bonnidee.loopbannerdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {


    private final int position;

    @SuppressLint("ValidFragment")
    public HomeFragment(int position) {
        this.position =position;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_image, container, false);
        TextView tv_title = view.findViewById(R.id.tv_title);
        tv_title.setText("position" + position);
        return view;
    }
}
